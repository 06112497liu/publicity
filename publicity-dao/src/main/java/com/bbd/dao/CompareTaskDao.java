package com.bbd.dao;

import com.bbd.domain.CompareTask;
import com.bbd.domain.CompareTaskExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompareTaskDao {
    int deleteByPrimaryKey(Long id);

    int insert(CompareTask record);

    int insertSelective(CompareTask record);

    List<CompareTask> selectByExampleWithPageBounds(CompareTaskExample example, PageBounds pageBounds);

    List<CompareTask> selectByExample(CompareTaskExample example);

    CompareTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompareTask record, @Param("example") CompareTaskExample example);

    int updateByExample(@Param("record") CompareTask record, @Param("example") CompareTaskExample example);

    int updateByPrimaryKeySelective(CompareTask record);

    int updateByPrimaryKey(CompareTask record);
}