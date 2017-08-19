package com.bbd.dao;

import com.bbd.domain.AnnualExPrevDetail;
import com.bbd.domain.AnnualExPrevDetailExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnualExPrevDetailDao {
    long countByExample(AnnualExPrevDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AnnualExPrevDetail record);

    int insertSelective(AnnualExPrevDetail record);

    List<AnnualExPrevDetail> selectByExampleWithPageBounds(AnnualExPrevDetailExample example, PageBounds pageBounds);

    List<AnnualExPrevDetail> selectByExample(AnnualExPrevDetailExample example);

    AnnualExPrevDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualExPrevDetail record, @Param("example") AnnualExPrevDetailExample example);

    int updateByExample(@Param("record") AnnualExPrevDetail record, @Param("example") AnnualExPrevDetailExample example);

    int updateByPrimaryKeySelective(AnnualExPrevDetail record);

    int updateByPrimaryKey(AnnualExPrevDetail record);
}