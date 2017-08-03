package com.bbd.dao;

import com.bbd.domain.AnnualBranchCmp;
import com.bbd.domain.AnnualBranchCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualBranchCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualBranchCmp record);

    int insertSelective(AnnualBranchCmp record);

    List<AnnualBranchCmp> selectByExampleWithPageBounds(AnnualBranchCmpExample example, PageBounds pageBounds);

    List<AnnualBranchCmp> selectByExample(AnnualBranchCmpExample example);

    AnnualBranchCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualBranchCmp record, @Param("example") AnnualBranchCmpExample example);

    int updateByExample(@Param("record") AnnualBranchCmp record, @Param("example") AnnualBranchCmpExample example);

    int updateByPrimaryKeySelective(AnnualBranchCmp record);

    int updateByPrimaryKey(AnnualBranchCmp record);
}