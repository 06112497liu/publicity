/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao;

import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tjwang
 * @version $Id: CompareTaskExtDao.java, v 0.1 2017/7/12 0012 18:04 tjwang Exp $
 */
public interface CompanyExItemExtDao {
    
    /**
     * 插入bbd_pub_company_ex_item_pre年报异常信息
     */
    void insertCompanyExItemPreAnnual();
    
    /**
     * 更新bbd_pub_company_ex_item_pre年报异常信息
     */
    void updateCompanyExItemPreAnnual();
    
    /**
     * 插入bbd_pub_company_ex_item_pre即时异常信息
     */
    void insertCompanyExItemPreIns();

    /**
     * 更新bbd_pub_company_ex_item_pre即时异常信息
     */
    void updateCompanyExItemPreIns();
    
    /**
     * 更新年报对比异常项数量统计
     *
     * @param nbxh
     */
    int updateAnnualInfo(@Param("nbxh") String nbxh, 
                         @Param("num") int num, 
                         @Param("exTypes") int exTypes, 
                         @Param("exModules") int exModules,
                         @Param("exModulesNum") int exModulesNum);

    /**
     * 更新即时信息对比异常项数量统计
     *
     * @param nbxh
     */
    int updateInstantlyInfo(@Param("nbxh") String nbxh, 
                            @Param("num") int num, 
                            @Param("exTypes") int exTypes, 
                            @Param("exModules") int exModules,
                            @Param("exModulesNum") int exModulesNum);

    /**
     * 查询年报异常企业
     *
     * @param region
     * @param primaryIndustry
     * @param moduleType
     * @param exType
     * @return
     */
    List<String> queryAnnualByParam(@Param("region") String region, @Param("primaryIndustry") String primaryIndustry,
                                    @Param("moduleType") int moduleType, @Param("exType") int exType, @Param("sort")String sort, PageBounds pb);

    /**
     * 查询即时信息异常企业
     *
     * @param region
     * @param primaryIndustry
     * @param moduleType
     * @param exType
     * @return
     */
    List<String> queryInstantlyByParam(@Param("region") String region, @Param("primaryIndustry") String primaryIndustry,
                                       @Param("moduleType") int moduleType, @Param("exType") int exType, @Param("sort") String sort, PageBounds pb);

    /**
     * 查询所有异常企业
     *
     * @param region
     * @param primaryIndustry
     * @param exType
     * @param pb
     * @return
     */
    List<String> queryAllByParam(@Param("region") String region, @Param("primaryIndustry") String primaryIndustry,
                                 @Param("exType") int exType, @Param("sort") String sort, PageBounds pb);
}
