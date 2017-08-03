package com.bbd.dao;

import com.bbd.domain.AnnualBranch;
import com.bbd.domain.AnnualBranchExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualBranchDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualBranch record);

    int insertSelective(AnnualBranch record);

    List<AnnualBranch> selectByExampleWithPageBounds(AnnualBranchExample example, PageBounds pageBounds);

    List<AnnualBranch> selectByExample(AnnualBranchExample example);

    AnnualBranch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualBranch record, @Param("example") AnnualBranchExample example);

    int updateByExample(@Param("record") AnnualBranch record, @Param("example") AnnualBranchExample example);

    int updateByPrimaryKeySelective(AnnualBranch record);

    int updateByPrimaryKey(AnnualBranch record);
}