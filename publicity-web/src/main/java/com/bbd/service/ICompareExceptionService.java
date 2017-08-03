/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import java.util.List;
import java.util.Map;

import com.bbd.service.param.ExDetailVo;
import com.bbd.service.param.ExceptionSearchParam;
import com.mybatis.domain.PageBounds;

/**
 * 对比异常服务
 *
 * @author tjwang
 * @version $Id: ICompareExceptionService.java, v 0.1 2017/7/18 0018 16:44 tjwang Exp $
 */
public interface ICompareExceptionService {

    /**
     * 通过多项查询条件查询
     *
     * @param param
     * @return
     */
    List<String> searchAnnualByParam(ExceptionSearchParam param, PageBounds pb);

    /**
     * 通过异常项数量查询
     *
     * @param count
     * @param pb
     * @return
     */
    List<String> searchAnnualByExCount(int count, PageBounds pb);

    /**
     * 通过企业名称查询年报异常
     *
     * @param companyName
     * @param pb
     * @return
     */
    List<String> searchAnnualByCompanyName(String companyName, PageBounds pb);

    /**
     * 通过多项查询条件查询
     *
     * @param param
     * @return
     */
    List<String> searchInstantlyByParam(ExceptionSearchParam param, PageBounds pb);

    /**
     * 通过异常项数量查询
     *
     * @param count
     * @param pb
     * @return
     */
    List<String> searchInstantlyByExCount(int count, PageBounds pb);

    /**
     * 通过企业名称查询年报异常
     *
     * @param companyName
     * @param pb
     * @return
     */
    List<String> searchInstantlyByCompanyName(String companyName, PageBounds pb);

    /**
     * 通过多项查询条件查询
     *
     * @param param
     * @return
     */
    List<String> searchAllByParam(ExceptionSearchParam param, PageBounds pb);

    /**
     * 通过异常项数量查询
     *
     * @param count
     * @param pb
     * @return
     */
    List<String> searchAllByExCount(int count, PageBounds pb);

    /**
     * 通过企业名称查询年报异常
     *
     * @param companyName
     * @param pb
     * @return
     */
    List<String> searchAllByCompanyName(String companyName, PageBounds pb);

    /**
     * 获取企业年报异常项
     *
     * @param nbxh
     * @return
     */
    List<ExDetailVo> getCompanyAnnualExDetails(String nbxh);

    /**
     * 获取企业即时信息异常项
     *
     * @param nbxh
     * @return
     */
    List<ExDetailVo> getCompanyInstantlyExDetails(String nbxh);
    
    /**
     * 根据企业nbxh查询企业异常详情头部信息
     *
     * @param nbxh
     * @return
     */
    Map<String, Object> getCompanyInfo(String nbxh);
}
