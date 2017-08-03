package com.bbd.dao;

import com.bbd.domain.AnnualBase;
import com.bbd.domain.AnnualBaseExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnualBaseDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualBase record);

    int insertSelective(AnnualBase record);

    List<AnnualBase> selectByExampleWithPageBounds(AnnualBaseExample example, PageBounds pageBounds);

    List<AnnualBase> selectByExample(AnnualBaseExample example);

    AnnualBase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualBase record, @Param("example") AnnualBaseExample example);

    int updateByExample(@Param("record") AnnualBase record, @Param("example") AnnualBaseExample example);

    int updateByPrimaryKeySelective(AnnualBase record);

    int updateByPrimaryKey(AnnualBase record);
}