package com.bbd.dao;

import com.bbd.domain.InsAdminLicenseCmp;
import com.bbd.domain.InsAdminLicenseCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsAdminLicenseCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(InsAdminLicenseCmp record);

    int insertSelective(InsAdminLicenseCmp record);

    List<InsAdminLicenseCmp> selectByExampleWithPageBounds(InsAdminLicenseCmpExample example, PageBounds pageBounds);

    List<InsAdminLicenseCmp> selectByExample(InsAdminLicenseCmpExample example);

    InsAdminLicenseCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InsAdminLicenseCmp record, @Param("example") InsAdminLicenseCmpExample example);

    int updateByExample(@Param("record") InsAdminLicenseCmp record, @Param("example") InsAdminLicenseCmpExample example);

    int updateByPrimaryKeySelective(InsAdminLicenseCmp record);

    int updateByPrimaryKey(InsAdminLicenseCmp record);
}