package com.bbd.dao;

import com.bbd.domain.InsStockholderCmp;
import com.bbd.domain.InsStockholderCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsStockholderCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(InsStockholderCmp record);

    int insertSelective(InsStockholderCmp record);

    List<InsStockholderCmp> selectByExampleWithPageBounds(InsStockholderCmpExample example, PageBounds pageBounds);

    List<InsStockholderCmp> selectByExample(InsStockholderCmpExample example);

    InsStockholderCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InsStockholderCmp record, @Param("example") InsStockholderCmpExample example);

    int updateByExample(@Param("record") InsStockholderCmp record, @Param("example") InsStockholderCmpExample example);

    int updateByPrimaryKeySelective(InsStockholderCmp record);

    int updateByPrimaryKey(InsStockholderCmp record);
}