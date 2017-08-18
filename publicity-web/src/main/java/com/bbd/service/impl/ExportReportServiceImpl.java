
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

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
import com.bbd.service.IExportReportService;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.param.ExDetailReportVo;
import com.bbd.service.param.ExDetailVo;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/** 
 *  
 * @author liuweibo 
 * @version $Id: ExportReportServiceImpl.java, v 0.1 2017年8月17日 下午3:45:40 liuweibo Exp $ 
 */
@Service
public class ExportReportServiceImpl implements IExportReportService {
    
    public static final Logger logger = LoggerFactory.getLogger(ExportReportServiceImpl.class);
    
    @Autowired
    private ICompareExceptionService compareExceptionService;
    
    @Autowired
    private PubCompanyInfoDao companyInfoDao;
    
    /**
     * 企业信息比对详情报告
     */
    @Override
    public void exDetailByNbxh(String nbxh, OutputStream out) {
        
        // 1.查询某个企业的 年报 信息对比详情
        List<ExDetailVo> annualList = compareExceptionService.getCompanyAnnualExDetails(nbxh);
        
        // 2.查询某个企业的 即时 信息对比详情
        List<ExDetailVo> insList = compareExceptionService.getCompanyInstantlyExDetails(nbxh);
        
        // 3.构建excel导出对象
        List<ExDetailReportVo> sourceList = Lists.newLinkedList();
        List<ExDetailReportVo> list1 = buildOneExDetailReportVo(annualList, 1);
        List<ExDetailReportVo> list2 = buildOneExDetailReportVo(insList, 2);
        sourceList.addAll(list1);
        sourceList.addAll(list2);
        
        // 4.构建表头
        Object[] reportTitle = new Object[]{"exType", "companyName", "regno", "adress", "phone", "email", "exItem", "exReason", "base", "other"};
        
        // 5.导出
        exportExcel("report/ExceptionList.prpt", "ExceptionData", sourceList, reportTitle, out);
        
    }    
    
    // 分类构建excel对象（1-年报异常，2-即时信息异常）
    private List<ExDetailReportVo> buildOneExDetailReportVo(List<ExDetailVo> list, Integer exType) {
        
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        PubCompanyInfo info = null;
        
        List<ExDetailReportVo> rs = Lists.newLinkedList();
        String baseNbxh = null;
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
            }         
            baseNbxh = nbxh;
            if(exType == 1) {
                vo.setExType("年报信息异常");
            } else if(exType == 2) {
                vo.setExType("即时信息异常");
            }
            vo.setExItem(PropertyEnum.getNameByCode(exVo.getPropName()));
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
        Object[][] reportInfo = buildTwoArray(list);
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
    
    // 构建二维数组
    private <T> Object[][] buildTwoArray(List<T> datas) {
        
        Integer rows = datas.size();
        Field[] declaredFields = datas.get(0).getClass().getDeclaredFields();
        Integer columns = declaredFields.length;
        
        Object[][] rs = new Object[rows][columns];
        
        for (int i = 0; i < rows; i++) {            
            for (int j = 0; j < columns; j++) {
                declaredFields[j].setAccessible(true);
                try {
                    rs[i][j] = declaredFields[j].get(datas.get(i));
                } catch (IllegalArgumentException e) {
                    logger.error("", e);
                } catch (IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }
        return rs;
    }

}

























