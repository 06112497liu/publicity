
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import com.bbd.dao.CompanyExItemExtDao;
import com.bbd.dao.ExportReportDao;
import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.domain.AnnualExDetail;
import com.bbd.domain.InstantlyExDetail;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.domain.PubCompanyInfoExample;
import com.bbd.enums.ExReasonEnum;
import com.bbd.report.ReportEngine;
import com.bbd.report.enums.ElementEnum;
import com.bbd.report.enums.ExportEnum;
import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.service.ICompareExceptionService;
import com.bbd.service.IDictionaryService;
import com.bbd.service.IExportExDetailReportService;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.InstantlyModule;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.param.ExDetailVo;
import com.bbd.service.param.ExceptionSearchParam;
import com.bbd.service.param.report.ExDetailReportVo;
import com.bbd.util.DateUtil;
import com.bbd.util.ReportUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.domain.PageBounds;
import com.utils.BeanMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/** 
 * 异常详情报告服务层
 * @author liuweibo 
 * @version $Id: ExportReportServiceImpl.java, v 0.1 2017年8月17日 下午3:45:40 liuweibo Exp $ 
 */
@Service
public class ExportReportExDetailServiceImpl implements IExportExDetailReportService {
    
    private static final Logger logger = LoggerFactory.getLogger(ExportReportExDetailServiceImpl.class);

    private static final Object[] reportTitle =
            new Object[]{"companyName", "regno", "adress", "phone", "email", "exType", "exClass", "exItem", "base", "other", "exReason"};

    private static final Optional<String> resource = Optional.of("report/ExceptionList.prpt");
    private static final Optional<String> resourceAll = Optional.of("report/ExceptionListAll.prpt");
    private static final String updateDate = DateUtil.formatDateByPatten(new Date(), "yyyy-MM-dd HH:mm");
    
    @Autowired
    private ICompareExceptionService compareExceptionService;

    @Autowired
    private PubCompanyInfoDao companyInfoDao;

    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    @Autowired
    private ExportReportDao exportReportDao;

    @Autowired
    private IDictionaryService dictionaryService;
    
    /**
     * 企业信息比对详情报告（单个）
     */
    @Override
    public void exDetailByNbxh(String nbxh, OutputStream out) {

        // 1.查询某个企业的 年报 信息对比详情
        List<ExDetailVo> annualList = compareExceptionService.getCompanyAnnualExDetails(nbxh);
        sortExcel(annualList);
        // 2.查询某个企业的 即时 信息对比详情
        List<ExDetailVo> insList = compareExceptionService.getCompanyInstantlyExDetails(nbxh);
        // 3.导出报告
        generatExport(resource, annualList, insList, out, null);
    }
   

    /**
     * 企业信息对比详情报告（批量）
     */
    @Override
    public void exDetailByNbxhs(String[] nbxhs, OutputStream out, Integer exType) {
        
        String nbxh = null;
        List<ExDetailVo> annualList = Lists.newLinkedList();
        List<ExDetailVo> insList = Lists.newLinkedList();
        if(exType == 1) { //即时信息异常详情            
            for (int i = 0; i < nbxhs.length; i++) {
                nbxh = nbxhs[i];
                annualList.addAll(compareExceptionService.getCompanyAnnualExDetails(nbxh));
            }            
        } else if(exType == 2) { //年报信息异常详情
            for (int i = 0; i < nbxhs.length; i++) {
                nbxh = nbxhs[i];
                insList.addAll(compareExceptionService.getCompanyAnnualExDetails(nbxh));
            } 
        } else if(exType == 3) {
            for (int i = 0; i < nbxhs.length; i++) {
                nbxh = nbxhs[i];
                annualList.addAll(compareExceptionService.getCompanyAnnualExDetails(nbxh));
                insList.addAll(compareExceptionService.getCompanyAnnualExDetails(nbxh));
            } 
        }
        // 排序
        sortExcel(annualList);
        sortExcel(insList);
        generatExport(resource, annualList, insList, out, null);
    }

    /**
     * 多条件全量导出
     */
    @Override
    public void exDetailAll(int type, OutputStream out, ExceptionSearchParam param) {

        List<ExDetailVo> annualList = Lists.newLinkedList();
        List<ExDetailVo> insList = Lists.newLinkedList();
        if(1 == type) {
            List<String> nbxhList = getNbxhList(param, 1);
            annualList = getExDetailVoList(nbxhList, 1);
        }
        if(2 == type) {
            List<String> nbxhList = getNbxhList(param, 2);
            insList = getExDetailVoList(nbxhList, 2);
        }
        if(3 == type) {
            List<String> nbxhList = getNbxhList(param, 3);
            annualList = getExDetailVoList(nbxhList, 1);
            insList = getExDetailVoList(nbxhList, 2);
        }
        // 排序
        sortExcel(annualList);
        sortExcel(insList);

        generatExport(resourceAll, annualList, insList, out, getParams(param, type));
    }

    /**
     * 根据企业异常项数量导出报告
     */
    @Override
    public void exDetailAll(Integer type, Integer count, Integer sortType, String sort, OutputStream out) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("count", count);
        params.put("date", updateDate);
        List<ExDetailVo> annualList = Lists.newLinkedList();
        List<ExDetailVo> insList = Lists.newLinkedList();
        List<String> nbxhList;
        if(1 == type) {
            nbxhList = compareExceptionService.searchAnnualByExCount(count, sort, sortType, new PageBounds(1, 1500));
            annualList = getExDetailVoList(nbxhList,1);
            params.put("nameType", "异常项数量查询年报信息异常名单");
        }
        if(2 == type) {
            nbxhList = compareExceptionService.searchInstantlyByExCount(count, sort, sortType, new PageBounds(1, 1500));
            insList = getExDetailVoList(nbxhList, 2);
            params.put("nameType", "异常项数量查询及时信息异常名单");
        }
        if(3 == type) {
            nbxhList = compareExceptionService.searchAllByExCount(count, sort, sortType, new PageBounds(1, 1500));
            annualList = getExDetailVoList(nbxhList, 1);
            insList = getExDetailVoList(nbxhList, 2);
            params.put("nameType", "异常项数量查询完整异常名单");
        }
        // 排序
        sortExcel(annualList);
        sortExcel(insList);
        generatExport(resourceAll, annualList, insList, out, params);
    }

    /**
     * 根据企业名称导出
     */
    @Override
    public void exDetailAll(Integer type, String companyName, Integer sortType, String sort, OutputStream out) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("companyName", companyName);
        params.put("date", updateDate);
        List<ExDetailVo> annualList = Lists.newLinkedList();
        List<ExDetailVo> insList = Lists.newLinkedList();
        List<String> nbxhList;
        if(type == 1) {
            nbxhList = compareExceptionService.searchAnnualByCompanyName(companyName, sort, sortType, new PageBounds(1, 1500));
            annualList = getExDetailVoList(nbxhList, 1);
            params.put("nameType", "企业名称模糊查询年报信息异常名单");
        }
        if(type == 2) {
            nbxhList = compareExceptionService.searchInstantlyByCompanyName(companyName, sort, sortType, new PageBounds(1, 1500));
            insList = getExDetailVoList(nbxhList, 2);
            params.put("nameType", "企业名称模糊查询及时信息异常名单");
        }
        if(type == 3) {
            nbxhList = compareExceptionService.searchAllByCompanyName(companyName, sort, sortType, new PageBounds(1, 1500));
            annualList = getExDetailVoList(nbxhList, 1);
            insList = getExDetailVoList(nbxhList, 2);
            params.put("nameType", "企业名称模糊查询完整异常名单");
        }
        // 排序
        sortExcel(annualList);
        sortExcel(insList);
        generatExport(resourceAll, annualList, insList, out, params);
    }

    private Map<String, Object> getParams(ExceptionSearchParam param, int type) {
        Map<String, String> disMap = dictionaryService.getDistrict();
        Map<String, String> industryMap = dictionaryService.getIndustry();
        Map<String, Object> map = Maps.newHashMap();
        String nameType;
        String region = param.getRegion() == null ? "全市" : disMap.get(param.getRegion());
        String industry = param.getPrimaryIndustry() == null ? "所有行业" : industryMap.get(param.getPrimaryIndustry());
        String moduleType;
        String exType = param.getExType() == 0 ? "全部异常原因" : ExReasonEnum.getDescByCode(param.getExType());
        if(type == 1) {
            nameType = "年报信息公示异常名单";
            moduleType = param.getModuleType() == 0 ? "全部年报对比项" : AnnualModule.getDescByCode(param.getModuleType());
        } else if(type == 2) {
            nameType = "即时信息公示异常名单";
            moduleType = param.getModuleType() == 0 ? "全部即时信息对比项" : AnnualModule.getDescByCode(param.getModuleType());
        } else {
            nameType = "完整异常名单";
            moduleType = "";
        }
        map.put("nameType", nameType);
        map.put("date", updateDate);
        map.put("region", region);
        map.put("primaryIndustry", industry);
        map.put("moduleType", moduleType);
        return map;
    }

    // 获取满足条件企业的nbxh集合
    private List<String> getNbxhList(ExceptionSearchParam param, int type) {

        String region = param.getRegion();
        String primaryIndustry = param.getPrimaryIndustry();
        int moduleType = param.getModuleType();
        int exType = param.getExType();
        int sortType = param.getSortType();
        String sort = param.getSort();

        List<String> nbxhList = Lists.newLinkedList();
        if(type == 1)
            nbxhList = companyExItemExtDao.queryAnnualByParam(region, primaryIndustry, moduleType, exType, sortType, sort, new PageBounds(1, 1500));
        if(type == 2)
            nbxhList = companyExItemExtDao.queryInstantlyByParam(region, primaryIndustry, moduleType, exType, sort, sortType, new PageBounds(1, 1500));
        if(type == 3)
            nbxhList = companyExItemExtDao.queryAllByParam(region, primaryIndustry, exType, sort, sortType, new PageBounds(1, 1500));
        return nbxhList;
    }

    // 构建excel对象(原始)
    private List<ExDetailVo> getExDetailVoList(List<String> nbxhList, int type) {
        List<ExDetailVo> rs = Lists.newLinkedList();
        Map<Integer, String> map = splitList(nbxhList, 300);
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            String nbxhs = map.get(it.next());
            if(type == 1) {
                List<AnnualExDetail> list = exportReportDao.queryAnnualAllByParam(nbxhs);
                rs = BeanMapperUtil.mapList(list, ExDetailVo.class);
            }
            if(type == 2) {
                List<InstantlyExDetail> list = exportReportDao.queryInsAllByparam(nbxhs);
                rs = BeanMapperUtil.mapList(list, ExDetailVo.class);
            }
        }
        return rs;
    }

    // 切片list，分成多次查询
    private Map<Integer, String> splitList(List<String> list, int splitLength) {
        Map<Integer, String> map = Maps.newHashMap();
        Joiner joiner = Joiner.on(",").skipNulls();
        if(list != null && !list.isEmpty()) {
            int size = list.size();
            if(size <= splitLength) {
                String s = joiner.join(list);
                map.put(0, s);
                return map;
            } else {
                int yu = size % splitLength;
                int chu = size / splitLength;
                for (int i=0; i<=chu; i++) {
                    List<String> sublist;
                    if(i == chu) {
                        if(yu == 0) break;
                        sublist = list.subList(i * splitLength, i * splitLength + yu);
                    } else {
                        sublist = list.subList(i * splitLength, (i+1) * splitLength);
                    }
                    String subs = joiner.join(sublist);
                    map.put(i, subs);
                }
                return map;
            }
        }
        return map;
    }

    //生成报告
    private void generatExport(Optional<String> resource, List<ExDetailVo> annualList, List<ExDetailVo> insList, OutputStream out, Map<String, Object> params) {
        // 构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);
        exportExcel(resource, sourceList, reportTitle, out, params);
    }

    // 分类构建excel对象（1-年报异常，2-即时信息异常）
    private List<ExDetailReportVo> buildOneExDetailReportVo(List<ExDetailVo> list, Integer exType) {
        
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        PubCompanyInfo info;
        
        List<ExDetailReportVo> rs = Lists.newLinkedList();
        String baseNbxh = null;        
        String baseExClass = null;
        String baseExItem = null;
        
        for (int i = 0; i < list.size(); i++) {            
            ExDetailReportVo vo = new ExDetailReportVo();
            ExDetailVo exVo = list.get(i);
            String nbxh = exVo.getNbxh();
            if(!nbxh.equals(baseNbxh)) {
                example.createCriteria().andNbxhEqualTo(nbxh);
                info = companyInfoDao.selectByExample(example).get(0);
                example.clear();
                vo.setCompanyName(info.getCompanyName());
                vo.setRegno(info.getRegno());
                vo.setAdress(info.getAddr());
                vo.setPhone(info.getPhones());
                vo.setEmail(info.getEmails());
                if(exType == 1) vo.setExType("年报信息异常");
                if(exType == 2) vo.setExType("即时信息异常");
            }         
            baseNbxh = nbxh;  

            if(exType == 1) {                     
                String exClass = exVo.getSubmodule().toString() + exVo.getNbxh();
                String exItem = exVo.getPropName();
                if(!exClass.equals(baseExClass)) {
                    vo.setExClass(AnnualModule.getDescByCode(exVo.getSubmodule()));                        
                }
                if(!exItem.equals(baseExItem)) {
                    vo.setExItem(PropertyEnum.getNameByCode(exVo.getPropName()));
                }
                baseExClass = exClass;
                baseExItem = exItem;
            }
            if(exType == 2) {                  
                String exClass = exVo.getSubmodule().toString() + exVo.getNbxh();
                String exItem = exVo.getPropName();
                if(!exClass.equals(baseExClass)) {
                    vo.setExClass(InstantlyModule.getDescByCode(exVo.getSubmodule()));                        
                }
                if(!exItem.equals(baseExItem)) {
                    vo.setExItem(PropertyEnum.getNameByCode(exVo.getPropName()));
                }
                baseExClass = exClass;
                baseExItem = exItem;
            }
            
            vo.setExReason(ExReasonEnum.getDescByCode(exVo.getExType()));
            vo.setBase(exVo.getBase());
            vo.setOther(exVo.getOther());
            rs.add(vo);
        }
        return rs;
    }
    
    // 导出excel
    private void exportExcel(Optional<String> resource, List<ExDetailReportVo> list, Object[] reportTitle, OutputStream out, Map<String, Object> params) {

        ArrayListMultimap<StructureEnum, ReportElementModel> elements = ArrayListMultimap.create();
        ReportElementModel model = buildReportElementModel("listInfo", "listData", list, reportTitle);
        elements.put(StructureEnum.REPORT_HEADER, model);
        //封装文件
        ReportEngine re = new ReportEngine();
        re.generateReport(resource, elements, params, ExportEnum.EXCEL_07, out);
        //使用输出流返回文件
        try {
            out.flush();
        } catch (IOException e) {
            logger.info("导出失败", e.getMessage());
        } finally{
            try {
                out.close();
            } catch (IOException e) {
                logger.info("导出失败", e.getMessage());
            }
        }
    }

    private <T> ReportElementModel buildReportElementModel(String name, String dataName, List<T> lists, Object[] title) {
        ReportElementModel model = new ReportElementModel();
        Object[][] arrays = ReportUtils.buildTwoArray(lists);
        TableDataModel dataModel = new TableDataModel(arrays, title);
        model.setName(name);
        model.setDataName(dataName);
        model.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        model.setDataModel(dataModel);
        return model;

    }
    
    private void sortExcel(List<ExDetailVo> list) {
        list.sort((x, y) -> {
            return ComparisonChain.start()
                    .compare(x.getNbxh(), y.getNbxh())
                    .compare(x.getSubmodule(), y.getSubmodule())
                    .compare(x.getPropName(), y.getPropName())
                    .result();
        });
    }
}

























