
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service;

import java.io.OutputStream;

/** 
 * 比对统计分析报告服务层
 * @author liuweibo 
 * @version $Id: IExportCmpStaReportService.java, v 0.1 2017年8月24日 下午4:10:50 liuweibo Exp $ 
 */
public interface IExportCmpStaReportService {

    /**
     * 对比统计分析报告
     */
    void cmpStaReport(OutputStream out);
}

