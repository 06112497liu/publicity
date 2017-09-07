
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service;

import java.io.OutputStream;

/** 
 * 年报报告导出服务层接口
 * @author liuweibo 
 * @version $Id: IExportAnnualReportService.java, v 0.1 2017年9月4日 上午9:51:29 liuweibo Exp $ 
 */
public interface IExportAnnualReportService {
    
    /**
     * 企业年报报告
     *
     * @param out
     */
    void getAnnualQY(OutputStream out, String nbxh, String year);
    
}

