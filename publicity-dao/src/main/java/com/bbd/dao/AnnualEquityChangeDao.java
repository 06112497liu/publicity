package com.bbd.dao;

import com.bbd.domain.AnnualEquityChange;
import com.bbd.domain.AnnualEquityChangeExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualEquityChangeDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualEquityChange record);

    int insertSelective(AnnualEquityChange record);

    List<AnnualEquityChange> selectByExampleWithPageBounds(AnnualEquityChangeExample example, PageBounds pageBounds);

    List<AnnualEquityChange> selectByExample(AnnualEquityChangeExample example);

    AnnualEquityChange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualEquityChange record, @Param("example") AnnualEquityChangeExample example);

    int updateByExample(@Param("record") AnnualEquityChange record, @Param("example") AnnualEquityChangeExample example);

    int updateByPrimaryKeySelective(AnnualEquityChange record);

    int updateByPrimaryKey(AnnualEquityChange record);
}