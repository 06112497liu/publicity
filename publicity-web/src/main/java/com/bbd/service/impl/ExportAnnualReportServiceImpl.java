
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.OutputStream;

import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.service.IExportAnnualReportService;
import com.google.common.collect.ArrayListMultimap;

/** 
 * 年报报告导出服务层
 * @author liuweibo 
 * @version $Id: ExportAnnualReportServiceImpl.java, v 0.1 2017年9月4日 上午9:52:53 liuweibo Exp $ 
 */
public class ExportAnnualReportServiceImpl implements IExportAnnualReportService {

    /**
     * 企业年报报告
     */
    @Override
    public void getAnnualQY(OutputStream out) {
        
        // 报告元素集合
        ArrayListMultimap<StructureEnum, ReportElementModel> lists = ArrayListMultimap.create();
        
        ReportElementModel baseModel = new ReportElementModel();
        
        
    }

}






















