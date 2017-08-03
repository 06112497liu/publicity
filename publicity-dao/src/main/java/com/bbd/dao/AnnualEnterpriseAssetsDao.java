package com.bbd.dao;

import com.bbd.domain.AnnualEnterpriseAssets;
import com.bbd.domain.AnnualEnterpriseAssetsExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualEnterpriseAssetsDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualEnterpriseAssets record);

    int insertSelective(AnnualEnterpriseAssets record);

    List<AnnualEnterpriseAssets> selectByExampleWithPageBounds(AnnualEnterpriseAssetsExample example, PageBounds pageBounds);

    List<AnnualEnterpriseAssets> selectByExample(AnnualEnterpriseAssetsExample example);

    AnnualEnterpriseAssets selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualEnterpriseAssets record, @Param("example") AnnualEnterpriseAssetsExample example);

    int updateByExample(@Param("record") AnnualEnterpriseAssets record, @Param("example") AnnualEnterpriseAssetsExample example);

    int updateByPrimaryKeySelective(AnnualEnterpriseAssets record);

    int updateByPrimaryKey(AnnualEnterpriseAssets record);
}