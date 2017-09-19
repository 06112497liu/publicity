
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
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.service.ICompareExceptionService;
import com.bbd.service.IExportExDetailReportService;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.InstantlyModule;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.param.ExDetailVo;
import com.bbd.service.param.ExceptionSearchParam;
import com.bbd.service.param.report.ExDetailReportVo;
import com.bbd.util.ReportUtils;
import com.bbd.util.StringUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.domain.PageBounds;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.utils.BeanMapperUtil;
import jdk.nashorn.internal.scripts.JO;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.collections.ListUtils;
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
    
    @Autowired
    private ICompareExceptionService compareExceptionService;

    @Autowired
    private PubCompanyInfoDao companyInfoDao;

    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    @Autowired
    private ExportReportDao exportReportDao;
    
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
        sortExcel(insList);
        // 3.构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);
        // 4.导出
        exportExcel("report/ExceptionList.prpt", "ExceptionData", sourceList, reportTitle, out);
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
        // 构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);

        // 导出
        exportExcel("report/ExceptionList.prpt", "ExceptionData", sourceList, reportTitle, out);
    }

    /**
     * 多条件全量导出
     */
    @Override
    public void exDetailAll(int type, OutputStream out, ExceptionSearchParam param) {

        List<ExDetailVo> annualList = Lists.newLinkedList();
        List<ExDetailVo> insList = Lists.newLinkedList();
        if(1 == type) annualList = buildExDetailVoList(param, 1);
        if(2 == type) insList = buildExDetailVoList(param, 2);
        if(3 == type) {
            annualList = buildExDetailVoList(param, 1);
            insList = buildExDetailVoList(param, 2);
        }
        // 排序
        sortExcel(annualList);
        sortExcel(insList);
        // 构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);
        // 导出
        exportExcel("report/ExceptionList.prpt", "ExceptionData", sourceList, reportTitle, out);
    }

    @Override
    public void exDetailAll(Integer type, Integer count, Integer sortType, String sort, OutputStream out) {

    }

    // 构建excel对象
    private List<ExDetailVo> buildExDetailVoList(ExceptionSearchParam param, int type) {

        String region = param.getRegion();
        String primaryIndustry = param.getPrimaryIndustry();
        int moduleType = param.getModuleType();
        int exType = param.getExType();
        int sortType = param.getSortType();
        String sort = param.getSort();

        List<ExDetailVo> rs = Lists.newLinkedList();
        List<String> nbxhList = Lists.newLinkedList();
        if(type == 1)
            nbxhList = companyExItemExtDao.queryAnnualByParam(region, primaryIndustry, moduleType, exType, sortType, sort, new PageBounds(1, 1500));
        if(type == 2)
            nbxhList = companyExItemExtDao.queryInstantlyByParam(region, primaryIndustry, moduleType, exType, sort, sortType, new PageBounds(1, 1500));
        if(type == 3)
            nbxhList = companyExItemExtDao.queryAllByParam(region, primaryIndustry, exType, sort, sortType, new PageBounds(1, 1500));

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
                    List<String> sublist = new ArrayList<>(300);
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

    // 分类构建excel对象（1-年报异常，2-即时信息异常）
    private List<ExDetailReportVo> buildOneExDetailReportVo(List<ExDetailVo> list, Integer exType) {
        
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        PubCompanyInfo info = null;
        
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
    private void exportExcel(String resourceURL, 
                             String reportName, 
                             List<ExDetailReportVo> list, 
                             Object[] reportTitle,  
                             OutputStream out) {
        
        Optional<String> resource = Optional.of(resourceURL);
        Object[][] reportInfo = ReportUtils.buildTwoArray(list);
        TableDataModel tableDataModel = new TableDataModel(reportInfo, reportTitle);
        ReportElementModel elementModel = new ReportElementModel();
        elementModel.setDataName(reportName);
        elementModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        elementModel.setDataModel(tableDataModel);
        //封装文件
        ReportEngine re = new ReportEngine();
        re.generateReport(resource, elementModel,ExportEnum.EXCEL_07, out);
        
        //使用输出流返回文件
        try {
            out.flush();
        } catch (IOException e) {
            logger.error("", e);
        } finally{
            try {
                out.close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
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

























