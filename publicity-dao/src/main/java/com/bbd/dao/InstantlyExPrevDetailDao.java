package com.bbd.dao;

import com.bbd.domain.InstantlyExPrevDetail;
import com.bbd.domain.InstantlyExPrevDetailExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstantlyExPrevDetailDao {
    long countByExample(InstantlyExPrevDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InstantlyExPrevDetail record);

    int insertSelective(InstantlyExPrevDetail record);

    List<InstantlyExPrevDetail> selectByExampleWithPageBounds(InstantlyExPrevDetailExample example, PageBounds pageBounds);

    List<InstantlyExPrevDetail> selectByExample(InstantlyExPrevDetailExample example);

    InstantlyExPrevDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InstantlyExPrevDetail record, @Param("example") InstantlyExPrevDetailExample example);

    int updateByExample(@Param("record") InstantlyExPrevDetail record, @Param("example") InstantlyExPrevDetailExample example);

    int updateByPrimaryKeySelective(InstantlyExPrevDetail record);

    int updateByPrimaryKey(InstantlyExPrevDetail record);
}