package com.bbd.dao;

import com.bbd.domain.AnnualStockholderCmp;
import com.bbd.domain.AnnualStockholderCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualStockholderCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualStockholderCmp record);

    int insertSelective(AnnualStockholderCmp record);

    List<AnnualStockholderCmp> selectByExampleWithPageBounds(AnnualStockholderCmpExample example, PageBounds pageBounds);

    List<AnnualStockholderCmp> selectByExample(AnnualStockholderCmpExample example);

    AnnualStockholderCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualStockholderCmp record, @Param("example") AnnualStockholderCmpExample example);

    int updateByExample(@Param("record") AnnualStockholderCmp record, @Param("example") AnnualStockholderCmpExample example);

    int updateByPrimaryKeySelective(AnnualStockholderCmp record);

    int updateByPrimaryKey(AnnualStockholderCmp record);
}