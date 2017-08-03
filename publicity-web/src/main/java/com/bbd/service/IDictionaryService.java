
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service;

import java.util.Map;

/** 
 * 数据字典服务
 * @author liuweibo 
 * @version $Id: IDictionaryService.java, v 0.1 2017年7月20日 上午10:17:52 liuweibo Exp $ 
 */
public interface IDictionaryService {
    
    /**
     * 获取一级行业字典
     * @return
     */
    Map<String, String> getIndustry();
    
    /**
     * 获取区域字典
     * @return
     */
    Map<String, String> getDistrict();
    
    /**
     * 获取年报信息对比项数据字典
     * @return
     */
    Map<String, String> getAnnualItem();
    
    /**
     * 即时信息对比项数据字典
     * @return
     */
    Map<String, String> getInsItem();
    
    /**
     * 企业类型数据字典
     * @return
     */    
    Map<String, String> getCompanyPropertyItem();
    
    /**
     * 行政许可文件名称类型字典表
     * @return
     */
    Map<String, String> getFileTypeItem();
    
}

