
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.bbd.service.IExportCmpStaReportService;

/** 
 * 比对统计分析报告服务层
 * @author liuweibo 
 * @version $Id: ExportCmpStaReportService.java, v 0.1 2017年8月24日 下午4:13:32 liuweibo Exp $ 
 */
@Service
public class ExportCmpStaReportServiceImpl implements IExportCmpStaReportService {

    /**
     * 对比统计分析报告
     */
    @Override
    public void cmpStaReport(OutputStream out) {
    }

}

