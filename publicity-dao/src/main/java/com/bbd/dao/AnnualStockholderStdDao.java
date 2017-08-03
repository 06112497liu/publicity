package com.bbd.dao;

import com.bbd.domain.AnnualStockholderStd;
import com.bbd.domain.AnnualStockholderStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualStockholderStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualStockholderStd record);

    int insertSelective(AnnualStockholderStd record);

    List<AnnualStockholderStd> selectByExampleWithPageBounds(AnnualStockholderStdExample example, PageBounds pageBounds);

    List<AnnualStockholderStd> selectByExample(AnnualStockholderStdExample example);

    AnnualStockholderStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualStockholderStd record, @Param("example") AnnualStockholderStdExample example);

    int updateByExample(@Param("record") AnnualStockholderStd record, @Param("example") AnnualStockholderStdExample example);

    int updateByPrimaryKeySelective(AnnualStockholderStd record);

    int updateByPrimaryKey(AnnualStockholderStd record);
}