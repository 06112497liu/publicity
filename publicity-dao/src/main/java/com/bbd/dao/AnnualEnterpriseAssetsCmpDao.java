package com.bbd.dao;

import com.bbd.domain.AnnualEnterpriseAssetsCmp;
import com.bbd.domain.AnnualEnterpriseAssetsCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualEnterpriseAssetsCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualEnterpriseAssetsCmp record);

    int insertSelective(AnnualEnterpriseAssetsCmp record);

    List<AnnualEnterpriseAssetsCmp> selectByExampleWithPageBounds(AnnualEnterpriseAssetsCmpExample example, PageBounds pageBounds);

    List<AnnualEnterpriseAssetsCmp> selectByExample(AnnualEnterpriseAssetsCmpExample example);

    AnnualEnterpriseAssetsCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualEnterpriseAssetsCmp record, @Param("example") AnnualEnterpriseAssetsCmpExample example);

    int updateByExample(@Param("record") AnnualEnterpriseAssetsCmp record, @Param("example") AnnualEnterpriseAssetsCmpExample example);

    int updateByPrimaryKeySelective(AnnualEnterpriseAssetsCmp record);

    int updateByPrimaryKey(AnnualEnterpriseAssetsCmp record);
}