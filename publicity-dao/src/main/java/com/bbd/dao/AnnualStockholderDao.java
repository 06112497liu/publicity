package com.bbd.dao;

import com.bbd.domain.AnnualStockholder;
import com.bbd.domain.AnnualStockholderExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualStockholderDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualStockholder record);

    int insertSelective(AnnualStockholder record);

    List<AnnualStockholder> selectByExampleWithPageBounds(AnnualStockholderExample example, PageBounds pageBounds);

    List<AnnualStockholder> selectByExample(AnnualStockholderExample example);

    AnnualStockholder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualStockholder record, @Param("example") AnnualStockholderExample example);

    int updateByExample(@Param("record") AnnualStockholder record, @Param("example") AnnualStockholderExample example);

    int updateByPrimaryKeySelective(AnnualStockholder record);

    int updateByPrimaryKey(AnnualStockholder record);
}