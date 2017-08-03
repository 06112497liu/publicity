package com.bbd.dao;

import com.bbd.domain.CompareStatistic;
import com.bbd.domain.CompareStatisticExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompareStatisticDao {
    int deleteByPrimaryKey(Long id);

    int insert(CompareStatistic record);

    int insertSelective(CompareStatistic record);

    List<CompareStatistic> selectByExampleWithPageBounds(CompareStatisticExample example, PageBounds pageBounds);

    List<CompareStatistic> selectByExample(CompareStatisticExample example);

    CompareStatistic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompareStatistic record, @Param("example") CompareStatisticExample example);

    int updateByExample(@Param("record") CompareStatistic record, @Param("example") CompareStatisticExample example);

    int updateByPrimaryKeySelective(CompareStatistic record);

    int updateByPrimaryKey(CompareStatistic record);
}