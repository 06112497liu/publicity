package com.bbd.dao;

import com.bbd.domain.AnnualExDetail;
import com.bbd.domain.AnnualExDetailExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnualExDetailDao {
    long countByExample(AnnualExDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AnnualExDetail record);

    int insertSelective(AnnualExDetail record);

    List<AnnualExDetail> selectByExampleWithPageBounds(AnnualExDetailExample example, PageBounds pageBounds);

    List<AnnualExDetail> selectByExample(AnnualExDetailExample example);

    AnnualExDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualExDetail record, @Param("example") AnnualExDetailExample example);

    int updateByExample(@Param("record") AnnualExDetail record, @Param("example") AnnualExDetailExample example);

    int updateByPrimaryKeySelective(AnnualExDetail record);

    int updateByPrimaryKey(AnnualExDetail record);
}