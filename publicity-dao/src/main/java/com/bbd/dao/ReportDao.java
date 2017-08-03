/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao;

import java.util.List;
import java.util.Map;

/**
 * @author tjwang
 * @version $Id: ReportDao.java, v 0.1 2017/7/19 0019 16:38 tjwang Exp $
 */
public interface ReportDao {

    /**
     * 按区域统计地图数据
     *
     * @return
     */
    List<Map<String, Object>> queryDistrictExStatistics();

    /**
     * 按区域统计年报信息异常企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryDistrictAnnualExStatistics();

    /**
     * 按区域统计即时信息异常企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryDistrictInsExStatistics();

    /**
     * 按行业统计地图数据
     *
     * @return
     */
    List<Map<String, Object>> queryIndustryExStatistics();

    /**
     * 按行业统计年报信息异常企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryIndustryAnnualExStatistics();

    /**
     * 按行业统计即时信息异常企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryIndustryInsExStatistics();

    /**
     * 按企业性质统计地图数据
     *
     * @return
     */
    List<Map<String, Object>> queryCompanyPropertyExStatistics();

    /**
     * 按企业性质统计年报信息异常企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryCompanyPropertyAnnualExStatistics();

    /**
     * 按企业性质统计即时信息异常企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryCompanyPropertyInsExStatistics();
    
    /**
     * 查询各个区域的企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryCompanyCountGroupDistrict();
    
    /**
     * 查询各个行业的企业数量
     *
     * @return
     */
    List<Map<String, Object>> queryCompanyCountGroupIndustry();

}
