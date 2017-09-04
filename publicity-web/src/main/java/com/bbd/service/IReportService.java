/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import java.util.List;

import com.bbd.service.param.CompareReportVo;

/**
 * 报表服务
 *
 * @author tjwang
 * @version $Id: IReportService.java, v 0.1 2017/7/19 0019 16:32 tjwang Exp $
 */
public interface IReportService {

    /**
     * 按地区分组统计
     * @return
     */
    List<CompareReportVo> queryDistrictExInfos();

    /**
     * 按行业分组统计
     * @return
     */
    List<CompareReportVo> queryIndustryExInfos();

    /**
     * 按企业性质分组统计
     * @return
     */
    List<CompareReportVo> queryCompanyPropertyExInfos();
    
    /**
     * 获取整个贵阳市的统计数据
     * @return
     */
    CompareReportVo queryWholeCity();

}
