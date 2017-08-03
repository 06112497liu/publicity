package com.bbd.dao;

import com.bbd.domain.AnnualBaseStd;
import com.bbd.domain.AnnualBaseStdExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnualBaseStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualBaseStd record);

    int insertSelective(AnnualBaseStd record);

    List<AnnualBaseStd> selectByExampleWithPageBounds(AnnualBaseStdExample example, PageBounds pageBounds);

    List<AnnualBaseStd> selectByExample(AnnualBaseStdExample example);

    AnnualBaseStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualBaseStd record, @Param("example") AnnualBaseStdExample example);

    int updateByExample(@Param("record") AnnualBaseStd record, @Param("example") AnnualBaseStdExample example);

    int updateByPrimaryKeySelective(AnnualBaseStd record);

    int updateByPrimaryKey(AnnualBaseStd record);
}