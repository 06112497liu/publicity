package com.bbd.dao;

import com.bbd.domain.AnnualOutboundInvestmentStd;
import com.bbd.domain.AnnualOutboundInvestmentStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualOutboundInvestmentStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualOutboundInvestmentStd record);

    int insertSelective(AnnualOutboundInvestmentStd record);

    List<AnnualOutboundInvestmentStd> selectByExampleWithPageBounds(AnnualOutboundInvestmentStdExample example, PageBounds pageBounds);

    List<AnnualOutboundInvestmentStd> selectByExample(AnnualOutboundInvestmentStdExample example);

    AnnualOutboundInvestmentStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualOutboundInvestmentStd record, @Param("example") AnnualOutboundInvestmentStdExample example);

    int updateByExample(@Param("record") AnnualOutboundInvestmentStd record, @Param("example") AnnualOutboundInvestmentStdExample example);

    int updateByPrimaryKeySelective(AnnualOutboundInvestmentStd record);

    int updateByPrimaryKey(AnnualOutboundInvestmentStd record);
}