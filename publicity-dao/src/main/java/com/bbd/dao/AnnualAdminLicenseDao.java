package com.bbd.dao;

import com.bbd.domain.AnnualAdminLicense;
import com.bbd.domain.AnnualAdminLicenseExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualAdminLicenseDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualAdminLicense record);

    int insertSelective(AnnualAdminLicense record);

    List<AnnualAdminLicense> selectByExampleWithPageBounds(AnnualAdminLicenseExample example, PageBounds pageBounds);

    List<AnnualAdminLicense> selectByExample(AnnualAdminLicenseExample example);

    AnnualAdminLicense selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualAdminLicense record, @Param("example") AnnualAdminLicenseExample example);

    int updateByExample(@Param("record") AnnualAdminLicense record, @Param("example") AnnualAdminLicenseExample example);

    int updateByPrimaryKeySelective(AnnualAdminLicense record);

    int updateByPrimaryKey(AnnualAdminLicense record);
}