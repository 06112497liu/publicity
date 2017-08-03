package com.bbd.dao;

import com.bbd.domain.AnnualWebInfo;
import com.bbd.domain.AnnualWebInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualWebInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualWebInfo record);

    int insertSelective(AnnualWebInfo record);

    List<AnnualWebInfo> selectByExampleWithPageBounds(AnnualWebInfoExample example, PageBounds pageBounds);

    List<AnnualWebInfo> selectByExample(AnnualWebInfoExample example);

    AnnualWebInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualWebInfo record, @Param("example") AnnualWebInfoExample example);

    int updateByExample(@Param("record") AnnualWebInfo record, @Param("example") AnnualWebInfoExample example);

    int updateByPrimaryKeySelective(AnnualWebInfo record);

    int updateByPrimaryKey(AnnualWebInfo record);
}