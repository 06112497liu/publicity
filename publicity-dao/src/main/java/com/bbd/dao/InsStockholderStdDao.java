package com.bbd.dao;

import com.bbd.domain.InsStockholderStd;
import com.bbd.domain.InsStockholderStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsStockholderStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(InsStockholderStd record);

    int insertSelective(InsStockholderStd record);

    List<InsStockholderStd> selectByExampleWithPageBounds(InsStockholderStdExample example, PageBounds pageBounds);

    List<InsStockholderStd> selectByExample(InsStockholderStdExample example);

    InsStockholderStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InsStockholderStd record, @Param("example") InsStockholderStdExample example);

    int updateByExample(@Param("record") InsStockholderStd record, @Param("example") InsStockholderStdExample example);

    int updateByPrimaryKeySelective(InsStockholderStd record);

    int updateByPrimaryKey(InsStockholderStd record);
}