package com.bbd.dao;

import com.bbd.domain.AnnualEquityChangeCmp;
import com.bbd.domain.AnnualEquityChangeCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualEquityChangeCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualEquityChangeCmp record);

    int insertSelective(AnnualEquityChangeCmp record);

    List<AnnualEquityChangeCmp> selectByExampleWithPageBounds(AnnualEquityChangeCmpExample example, PageBounds pageBounds);

    List<AnnualEquityChangeCmp> selectByExample(AnnualEquityChangeCmpExample example);

    AnnualEquityChangeCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualEquityChangeCmp record, @Param("example") AnnualEquityChangeCmpExample example);

    int updateByExample(@Param("record") AnnualEquityChangeCmp record, @Param("example") AnnualEquityChangeCmpExample example);

    int updateByPrimaryKeySelective(AnnualEquityChangeCmp record);

    int updateByPrimaryKey(AnnualEquityChangeCmp record);
}