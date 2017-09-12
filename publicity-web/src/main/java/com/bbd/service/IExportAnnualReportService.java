
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
     * @param out 输出流
     * @param nbxh 企业nbxh
     * @param year 年报年度
     */
    void getAnnualQY(OutputStream out, String nbxh, String year);
    
    /**
     * 个体年报报告
     *
     * @param out 输出流
     * @param nbxh 企业nbxh
     * @param year 年报年度
     */
    void getAnnualGT(OutputStream out, String nbxh, String year);
    
    /**
     * 农专年报报告
     *
     * @param out 输出流
     * @param nbxh 企业nbxh
     * @param year 年报年度
     */
    void getAnnualNZ(OutputStream out, String nbxh, String year);
}













