package com.bbd.dao;

import com.bbd.domain.InstantlyExDetail;
import com.bbd.domain.InstantlyExDetailExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstantlyExDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(InstantlyExDetail record);

    int insertSelective(InstantlyExDetail record);

    List<InstantlyExDetail> selectByExampleWithPageBounds(InstantlyExDetailExample example, PageBounds pageBounds);

    List<InstantlyExDetail> selectByExample(InstantlyExDetailExample example);

    InstantlyExDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InstantlyExDetail record, @Param("example") InstantlyExDetailExample example);

    int updateByExample(@Param("record") InstantlyExDetail record, @Param("example") InstantlyExDetailExample example);

    int updateByPrimaryKeySelective(InstantlyExDetail record);

    int updateByPrimaryKey(InstantlyExDetail record);
}