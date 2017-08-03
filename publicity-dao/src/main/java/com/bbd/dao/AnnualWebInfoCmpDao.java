package com.bbd.dao;

import com.bbd.domain.AnnualWebInfoCmp;
import com.bbd.domain.AnnualWebInfoCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualWebInfoCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualWebInfoCmp record);

    int insertSelective(AnnualWebInfoCmp record);

    List<AnnualWebInfoCmp> selectByExampleWithPageBounds(AnnualWebInfoCmpExample example, PageBounds pageBounds);

    List<AnnualWebInfoCmp> selectByExample(AnnualWebInfoCmpExample example);

    AnnualWebInfoCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualWebInfoCmp record, @Param("example") AnnualWebInfoCmpExample example);

    int updateByExample(@Param("record") AnnualWebInfoCmp record, @Param("example") AnnualWebInfoCmpExample example);

    int updateByPrimaryKeySelective(AnnualWebInfoCmp record);

    int updateByPrimaryKey(AnnualWebInfoCmp record);
}