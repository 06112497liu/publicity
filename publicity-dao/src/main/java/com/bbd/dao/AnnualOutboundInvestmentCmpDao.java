package com.bbd.dao;

import com.bbd.domain.AnnualOutboundInvestmentCmp;
import com.bbd.domain.AnnualOutboundInvestmentCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualOutboundInvestmentCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualOutboundInvestmentCmp record);

    int insertSelective(AnnualOutboundInvestmentCmp record);

    List<AnnualOutboundInvestmentCmp> selectByExampleWithPageBounds(AnnualOutboundInvestmentCmpExample example, PageBounds pageBounds);

    List<AnnualOutboundInvestmentCmp> selectByExample(AnnualOutboundInvestmentCmpExample example);

    AnnualOutboundInvestmentCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualOutboundInvestmentCmp record, @Param("example") AnnualOutboundInvestmentCmpExample example);

    int updateByExample(@Param("record") AnnualOutboundInvestmentCmp record, @Param("example") AnnualOutboundInvestmentCmpExample example);

    int updateByPrimaryKeySelective(AnnualOutboundInvestmentCmp record);

    int updateByPrimaryKey(AnnualOutboundInvestmentCmp record);
}