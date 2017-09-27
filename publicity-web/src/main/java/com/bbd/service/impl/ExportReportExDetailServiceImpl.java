
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import com.bbd.dao.CompanyExItemExtDao;
import com.bbd.dao.ExportReportDao;
import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.domain.*;
import com.bbd.enums.ExReasonEnum;
import com.bbd.report.ReportEngine;
import com.bbd.report.enums.ElementEnum;
import com.bbd.report.enums.ExportEnum;
import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.service.ICompanyService;
import com.bbd.service.ICompareExceptionService;
import com.bbd.service.IDictionaryService;
import com.bbd.service.IExportExDetailReportService;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.InstantlyModule;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.param.ExDetailVo;
import com.bbd.service.param.ExceptionSearchParam;
import com.bbd.service.param.report.ExDetailReportVo;
import com.bbd.service.param.report.ExListReportVo;
import com.bbd.util.DateUtil;
import com.bbd.util.NumUtils;
import com.bbd.util.ReportUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.domain.PageBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

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

    private static final Object[] reportTitleAll =
            new Object[]{"companyName", "regno", "adress", "phone", "email", "exType", "num", "exClass"};

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

    @Autowired
    private ICompanyService companyService;
    
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
        String nbxh;
        List<ExDetailVo> annualList = Lists.newLinkedList();
        List<ExDetailVo> insList = Lists.newLinkedList();
        if(exType == 1) { //年报信息异常详情
            for (int i = 0; i < nbxhs.length; i++) {
                nbxh = nbxhs[i];
                annualList.addAll(compareExceptionService.getCompanyAnnualExDetails(nbxh));
            }            
        } else if(exType == 2) { //即时信息异常详情
            for (int i = 0; i < nbxhs.length; i++) {
                nbxh = nbxhs[i];
                insList.addAll(compareExceptionService.getCompanyInstantlyExDetails(nbxh));
            } 
        } else if(exType == 3) {
            for (int i = 0; i < nbxhs.length; i++) {
                nbxh = nbxhs[i];
                annualList.addAll(compareExceptionService.getCompanyAnnualExDetails(nbxh));
                insList.addAll(compareExceptionService.getCompanyInstantlyExDetails(nbxh));
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
        // step1：构建入参
        String region = param.getRegion();
        String primaryIndustry = param.getPrimaryIndustry();
        int moduleType = param.getModuleType();
        int exType = param.getExType();
        int sortType = param.getSortType();
        String sort = param.getSort();
        // step2：查询
        List<CompanyExItem> list;
        if(1 == type) list = exportReportDao.queryAnnualExByParam(region, primaryIndustry, moduleType, exType, sortType, sort);
        else if(2 == type) list = exportReportDao.queryInsExByParam(region, primaryIndustry, moduleType, exType, sortType, sort);
        else list = exportReportDao.queryAllExByParam(region, primaryIndustry, exType, sortType, sort);
        // step3：构建excel（ExListReportVo）对象
        List<ExListReportVo> exList = buildExcelVo(list, type);
        // step4：构建报表参数
        Map<String, Object> p = getParams(param, type);
        // step3：生成报告
        exportExcel(resourceAll, exList, reportTitleAll, out, p);
    }

    private String buildExClass(int type, int exNum) {
        Joiner joiner = Joiner.on("、").skipNulls();
        List<Integer> l = Arrays.asList(1, 2, 4, 8, 16);
        List<Integer> list = NumUtils.getExistNum(exNum, l);
        List<String> strs = Lists.newLinkedList();
        if(type == 1) strs = list.stream().map(p -> AnnualModule.getDescByCode(p)).collect(Collectors.toList());
        if(type == 2) strs = list.stream().map(p -> InstantlyModule.getDescByCode(p)).collect(Collectors.toList());
        return joiner.join(strs);
    }

    private List<ExListReportVo> buildExcelVo(List<CompanyExItem> list, int type) {
        List<ExListReportVo> exList = Lists.newLinkedList();
        for (CompanyExItem c : list) {
            PubCompanyInfo p = companyService.getByNbxh(c.getNbxh());
            ExListReportVo v = new ExListReportVo(p.getCompanyName(), buildRegnoCode(p.getCreditCode(), p.getRegno()), p.getAddr(), p.getPhones(), p.getEmails());
            if(1 == type) {
                v.setNum(c.getAnnualNum());
                v.setExType("年报信息异常");
                String s = buildExClass(1, c.getAnnualExModules());
                v.setExClass(s);
            } else if(2 == type) {
                v.setNum(c.getInstantlyNum());
                v.setExType("即时信息异常");
                String s = buildExClass(2, c.getInsExModules());
                v.setExClass(s);
            } else {
                v.setNum(c.getNum());
                v.setExType("完整异常");
                String s = "【年报】" + buildExClass(1, c.getAnnualExModules()) + ";【即时信息】" + buildExClass(2, c.getInsExModules());
                v.setExClass(s);
            }
            exList.add(v);
        }
        return exList;
    }

    private String buildRegnoCode(String...params) {
        Joiner joiner = Joiner.on("/").skipNulls();
        return joiner.join(params);
    }

    /**
     * 根据企业异常项数量导出报告
     */
    @Override
    public void exDetailAll(Integer type, Integer count, Integer sortType, String sort, OutputStream out) {
        // step1：构建报表参数
        Map<String, Object> params = Maps.newHashMap();
        params.put("count", count);
        params.put("date", updateDate);
        params.put("nameType", buildNameType(type));
        // step2：构建excel对象
        List<CompanyExItem> list = exportReportDao.queryExceptionByNum(type, count, sortType, sort);
        List<ExListReportVo> exList = buildExcelVo(list, type);
        // step3：导出报告
        exportExcel(resourceAll, exList, reportTitleAll, out, params);
    }

    /**
     * 根据企业名称模糊查询导出报告
     */
    @Override
    public void exDetailAll(Integer type, String companyName, Integer sortType, String sort, OutputStream out) {
        // step1：构建报表参数
        Map<String, Object> params = Maps.newHashMap();
        params.put("companyName", companyName);
        params.put("date", updateDate);
        params.put("nameType", buildNameType(type));
        // step2：构建excel对象
        List<CompanyExItem> list = exportReportDao.queryExceptionByName(type, "'%" + companyName + "%'", sortType, sort);
        List<ExListReportVo> exList = buildExcelVo(list, type);
        // step3：导出报告
        exportExcel(resourceAll, exList, reportTitleAll, out, params);
    }

    private String buildNameType(int type) {
        if(type == 1) return "年报公示信息异常企业名单（全量）";
        else if(type == 2) return "即时信息公示异常企业名单（全量）";
        else return "完整公示信息对比异常企业名单（全量）";
    }

    private Map<String, Object> getParams(ExceptionSearchParam param, int type) {
        Map<String, String> disMap = dictionaryService.getDistrict();
        Map<String, String> industryMap = dictionaryService.getIndustry();
        Map<String, Object> map = Maps.newHashMap();
        String region = param.getRegion() == null ? "全市" : disMap.get(param.getRegion());
        String industry = param.getPrimaryIndustry() == null ? "所有行业" : industryMap.get(param.getPrimaryIndustry());
        String moduleType;
        String exType = param.getExType() == 0 ? "全部异常原因" : ExReasonEnum.getDescByCode(param.getExType());
        if(type == 1) moduleType = param.getModuleType() == 0 ? "全部年报对比项" : AnnualModule.getDescByCode(param.getModuleType());
        else if(type == 2) moduleType = param.getModuleType() == 0 ? "全部即时信息对比项" : InstantlyModule.getDescByCode(param.getModuleType());
        else moduleType = "年报信息和即时信息全部对比项";
        map.put("nameType", buildNameType(type));
        map.put("date", updateDate);
        map.put("region", region);
        map.put("primaryIndustry", industry);
        map.put("moduleType", moduleType);
        map.put("exType", exType);
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

        PubCompanyInfo p;
        List<ExDetailReportVo> rs = Lists.newLinkedList();
        String baseNbxh = null;
        String baseExClass = null;
        String baseExItem = null;
        
        for (int i = 0; i < list.size(); i++) {            
            ExDetailReportVo vo = new ExDetailReportVo();
            ExDetailVo exVo = list.get(i);
            String nbxh = exVo.getNbxh();
            if(!nbxh.equals(baseNbxh)) {
                p = companyService.getByNbxh(nbxh);
                vo.setCompanyName(p.getCompanyName());
                vo.setRegno(buildRegnoCode(p.getRegno(), p.getCreditCode()));
                vo.setAdress(p.getAddr());
                vo.setPhone(p.getPhones());
                vo.setEmail(p.getEmails());
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
    private <T> void exportExcel(Optional<String> resource, List<T> list, Object[] reportTitle, OutputStream out, Map<String, Object> params) {

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

























