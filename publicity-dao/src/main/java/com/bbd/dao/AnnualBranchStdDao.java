package com.bbd.dao;

import com.bbd.domain.AnnualBranchStd;
import com.bbd.domain.AnnualBranchStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualBranchStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualBranchStd record);

    int insertSelective(AnnualBranchStd record);

    List<AnnualBranchStd> selectByExampleWithPageBounds(AnnualBranchStdExample example, PageBounds pageBounds);

    List<AnnualBranchStd> selectByExample(AnnualBranchStdExample example);

    AnnualBranchStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualBranchStd record, @Param("example") AnnualBranchStdExample example);

    int updateByExample(@Param("record") AnnualBranchStd record, @Param("example") AnnualBranchStdExample example);

    int updateByPrimaryKeySelective(AnnualBranchStd record);

    int updateByPrimaryKey(AnnualBranchStd record);
}