
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service;

import java.io.OutputStream;

/** 
 * 报告导出服务层
 * @author liuweibo 
 * @version $Id: IExportReportService.java, v 0.1 2017年8月17日 下午3:39:33 liuweibo Exp $ 
 */
public interface IExportReportService {
    
    /**
     * 企业信息比对详情报告（单个）
     * @param nbxh
     * @param out
     */
    void exDetailByNbxh(String nbxh, OutputStream out);  
    
    /**
     * 企业信息对比详情报告（批量）
     * @param nbxhs
     * @param out
     */
    void exDetailByNbxhs(String[] nbxhs, OutputStream out, Integer exType);
    
}

