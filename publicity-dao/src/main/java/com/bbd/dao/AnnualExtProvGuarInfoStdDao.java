package com.bbd.dao;

import com.bbd.domain.AnnualExtProvGuarInfoStd;
import com.bbd.domain.AnnualExtProvGuarInfoStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualExtProvGuarInfoStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualExtProvGuarInfoStd record);

    int insertSelective(AnnualExtProvGuarInfoStd record);

    List<AnnualExtProvGuarInfoStd> selectByExampleWithPageBounds(AnnualExtProvGuarInfoStdExample example, PageBounds pageBounds);

    List<AnnualExtProvGuarInfoStd> selectByExample(AnnualExtProvGuarInfoStdExample example);

    AnnualExtProvGuarInfoStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualExtProvGuarInfoStd record, @Param("example") AnnualExtProvGuarInfoStdExample example);

    int updateByExample(@Param("record") AnnualExtProvGuarInfoStd record, @Param("example") AnnualExtProvGuarInfoStdExample example);

    int updateByPrimaryKeySelective(AnnualExtProvGuarInfoStd record);

    int updateByPrimaryKey(AnnualExtProvGuarInfoStd record);
}