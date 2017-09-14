package com.bbd.dao;

import com.bbd.domain.AnnualExtProvGuarInfo;
import com.bbd.domain.AnnualExtProvGuarInfoExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AnnualExtProvGuarInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualExtProvGuarInfo record);

    int insertSelective(AnnualExtProvGuarInfo record);

    List<AnnualExtProvGuarInfo> selectByExampleWithPageBounds(AnnualExtProvGuarInfoExample example, PageBounds pageBounds);

    List<AnnualExtProvGuarInfo> selectByExample(AnnualExtProvGuarInfoExample example);

    AnnualExtProvGuarInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualExtProvGuarInfo record, @Param("example") AnnualExtProvGuarInfoExample example);

    int updateByExample(@Param("record") AnnualExtProvGuarInfo record, @Param("example") AnnualExtProvGuarInfoExample example);

    int updateByPrimaryKeySelective(AnnualExtProvGuarInfo record);

    int updateByPrimaryKey(AnnualExtProvGuarInfo record);
}