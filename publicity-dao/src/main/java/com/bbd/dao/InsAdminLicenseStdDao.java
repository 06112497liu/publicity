package com.bbd.dao;

import com.bbd.domain.InsAdminLicenseStd;
import com.bbd.domain.InsAdminLicenseStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsAdminLicenseStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(InsAdminLicenseStd record);

    int insertSelective(InsAdminLicenseStd record);

    List<InsAdminLicenseStd> selectByExampleWithPageBounds(InsAdminLicenseStdExample example, PageBounds pageBounds);

    List<InsAdminLicenseStd> selectByExample(InsAdminLicenseStdExample example);

    InsAdminLicenseStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InsAdminLicenseStd record, @Param("example") InsAdminLicenseStdExample example);

    int updateByExample(@Param("record") InsAdminLicenseStd record, @Param("example") InsAdminLicenseStdExample example);

    int updateByPrimaryKeySelective(InsAdminLicenseStd record);

    int updateByPrimaryKey(InsAdminLicenseStd record);
}