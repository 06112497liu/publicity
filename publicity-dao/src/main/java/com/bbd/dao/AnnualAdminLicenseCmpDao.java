package com.bbd.dao;

import com.bbd.domain.AnnualAdminLicenseCmp;
import com.bbd.domain.AnnualAdminLicenseCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualAdminLicenseCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualAdminLicenseCmp record);

    int insertSelective(AnnualAdminLicenseCmp record);

    List<AnnualAdminLicenseCmp> selectByExampleWithPageBounds(AnnualAdminLicenseCmpExample example, PageBounds pageBounds);

    List<AnnualAdminLicenseCmp> selectByExample(AnnualAdminLicenseCmpExample example);

    AnnualAdminLicenseCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualAdminLicenseCmp record, @Param("example") AnnualAdminLicenseCmpExample example);

    int updateByExample(@Param("record") AnnualAdminLicenseCmp record, @Param("example") AnnualAdminLicenseCmpExample example);

    int updateByPrimaryKeySelective(AnnualAdminLicenseCmp record);

    int updateByPrimaryKey(AnnualAdminLicenseCmp record);
}