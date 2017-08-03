package com.bbd.dao;

import com.bbd.domain.AnnualExtProvGuarInfoCmp;
import com.bbd.domain.AnnualExtProvGuarInfoCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualExtProvGuarInfoCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualExtProvGuarInfoCmp record);

    int insertSelective(AnnualExtProvGuarInfoCmp record);

    List<AnnualExtProvGuarInfoCmp> selectByExampleWithPageBounds(AnnualExtProvGuarInfoCmpExample example, PageBounds pageBounds);

    List<AnnualExtProvGuarInfoCmp> selectByExample(AnnualExtProvGuarInfoCmpExample example);

    AnnualExtProvGuarInfoCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualExtProvGuarInfoCmp record, @Param("example") AnnualExtProvGuarInfoCmpExample example);

    int updateByExample(@Param("record") AnnualExtProvGuarInfoCmp record, @Param("example") AnnualExtProvGuarInfoCmpExample example);

    int updateByPrimaryKeySelective(AnnualExtProvGuarInfoCmp record);

    int updateByPrimaryKey(AnnualExtProvGuarInfoCmp record);
}