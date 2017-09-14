
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

import com.bbd.util.ReportUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.dao.PubCompanyInfoDao;
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
import com.bbd.service.param.report.ExDetailReportVo;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import javax.annotation.Resource;

/** 
 * 异常详情报告服务层
 * @author liuweibo 
 * @version $Id: ExportReportServiceImpl.java, v 0.1 2017年8月17日 下午3:45:40 liuweibo Exp $ 
 */
@Service
public class ExportReportExDetailServiceImpl implements IExportExDetailReportService {
    
    public static final Logger logger = LoggerFactory.getLogger(ExportReportExDetailServiceImpl.class);
    
    @Autowired
    private ICompareExceptionService compareExceptionService;

    @Autowired
    private PubCompanyInfoDao companyInfoDao;
    
    /**
     * 企业信息比对详情报告（单个）
     */
    @Override
    public void exDetailByNbxh(String nbxh, OutputStream out) {
        
        // 1.查询某个企业的 年报 信息对比详情
        List<ExDetailVo> annualList = compareExceptionService.getCompanyAnnualExDetails(nbxh);
        sortExcel(annualList, 1);        
        
        // 2.查询某个企业的 即时 信息对比详情
        List<ExDetailVo> insList = compareExceptionService.getCompanyInstantlyExDetails(nbxh);                
        sortExcel(insList, 1);
        
        // 3.构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);
        
        // 4.构建表头
        Object[] reportTitle = new Object[]{"companyName", "regno", "adress", "phone", "email", "exType", "exClass", "exItem", "base", "other", "exReason"};
        
        // 5.导出
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
        sortExcel(annualList, 2);
        sortExcel(insList, 2);
        
        // 构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);

        // 构建表头
        Object[] reportTitle = new Object[]{"companyName", "regno", "adress", "phone", "email", "exType", "exClass", "exItem", "base", "other", "exReason"};
        
        // 导出
        exportExcel("report/ExceptionList.prpt", "ExceptionData", sourceList, reportTitle, out);
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
    
    private void sortExcel(List<ExDetailVo> list, Integer sortType) {
        if(1 == sortType) {
            list.sort((x, y) -> {
                Integer rs = x.getSubmodule().compareTo(y.getSubmodule());
                if (rs != 0) {
                    return rs;
                } else {
                    return x.getPropName().compareTo(y.getPropName());
                }
            });
        }
        if(2 == sortType) {
            list.sort((x, y) -> {
//                return ComparisonChain.start()
//                                      .compare(x.getNbxh(), y.getBase())
//                                      .compare(x.getSubmodule(), y.getSubmodule())
//                                      .compare(x.getPropName(), y.getPropName())
//                                      .result();
                Integer a = x.getNbxh().compareTo(y.getNbxh());
                if(a != 0) {
                    return a;
                } else {
                    Integer b = x.getSubmodule().compareTo(y.getSubmodule());
                    if(b != 0) {
                        return b;
                    } else {
                        return x.getPropName().compareTo(y.getPropName());
                    }                
                }
            });
        }
    }

}

























