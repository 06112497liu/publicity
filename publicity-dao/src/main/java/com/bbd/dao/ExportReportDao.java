package com.bbd.dao;

import com.bbd.domain.CompanyExItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报告导出dao层
 * @author Liuweibo
 * @version Id: ExportReportDao.java, v0.1 2017/9/18 Liuweibo Exp $$
 */
public interface ExportReportDao {

    /**
     * 多条件查询年报异常企业信息
     * @param region
     * @param primaryIndustry
     * @param moduleType
     * @param exType
     * @param sortType
     * @param sort
     * @return
     */
    List<CompanyExItem> queryAnnualExByParam(@Param("region") String region,
                                             @Param("primaryIndustry") String primaryIndustry,
                                             @Param("moduleType") int moduleType,
                                             @Param("exType") int exType,
                                             @Param("sortType") int sortType,
                                             @Param("sort") String sort);
    /**
     * 多条件查询即时信息异常企业信息
     * @param region
     * @param primaryIndustry
     * @param moduleType
     * @param exType
     * @param sortType
     * @param sort
     * @return
     */
    List<CompanyExItem> queryInsExByParam(@Param("region") String region,
                                          @Param("primaryIndustry") String primaryIndustry,
                                          @Param("moduleType") int moduleType,
                                          @Param("exType") int exType,
                                          @Param("sortType") int sortType,
                                          @Param("sort") String sort);

    /**
     * 查询所有异常企业
     *
     * @param region
     * @param primaryIndustry
     * @param exType
     * @return
     */
    List<CompanyExItem> queryAllExByParam(@Param("region") String region,
                                          @Param("primaryIndustry") String primaryIndustry,
                                          @Param("exType") int exType,
                                          @Param("sortType") int sortType,
                                          @Param("sort") String sort);

    /**
     * 根据异常数量查询企业信息
     * @param type
     * @param num
     * @param sort
     * @param sortType
     * @return
     */
    List<CompanyExItem> queryExceptionByNum(@Param("type") int type,
                                            @Param("num") int num,
                                            @Param("sortType") int sortType,
                                            @Param("sort") String sort);

    /**
     * 根据企业名称模糊查询企业信息
     * @param type
     * @param companyName
     * @param sort
     * @param sortType
     * @return
     */
    List<CompanyExItem> queryExceptionByName(@Param("type") int type,
                                             @Param("companyName") String companyName,
                                             @Param("sortType") int sortType,
                                             @Param("sort") String sort);

}
    
    