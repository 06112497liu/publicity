package com.bbd.dao;

import com.bbd.domain.AnnualOutboundInvestment;
import com.bbd.domain.AnnualOutboundInvestmentExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualOutboundInvestmentDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualOutboundInvestment record);

    int insertSelective(AnnualOutboundInvestment record);

    List<AnnualOutboundInvestment> selectByExampleWithPageBounds(AnnualOutboundInvestmentExample example, PageBounds pageBounds);

    List<AnnualOutboundInvestment> selectByExample(AnnualOutboundInvestmentExample example);

    AnnualOutboundInvestment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualOutboundInvestment record, @Param("example") AnnualOutboundInvestmentExample example);

    int updateByExample(@Param("record") AnnualOutboundInvestment record, @Param("example") AnnualOutboundInvestmentExample example);

    int updateByPrimaryKeySelective(AnnualOutboundInvestment record);

    int updateByPrimaryKey(AnnualOutboundInvestment record);
}