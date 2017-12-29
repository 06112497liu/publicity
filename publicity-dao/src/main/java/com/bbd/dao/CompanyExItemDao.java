package com.bbd.dao;

import com.bbd.domain.CompanyExItem;
import com.bbd.domain.CompanyExItemExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyExItemDao {
    int deleteByPrimaryKey(Long id);

    int insert(CompanyExItem record);

    int insertSelective(CompanyExItem record);

    List<CompanyExItem> selectByExampleWithPageBounds(CompanyExItemExample example, PageBounds pageBounds);

    // 新添加的方法
    List<CompanyExItem> selectByExampleWithPageBounds2(CompanyExItemExample example, PageBounds pageBounds);

    List<CompanyExItem> selectByExample(CompanyExItemExample example);

    CompanyExItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompanyExItem record, @Param("example") CompanyExItemExample example);

    int updateByExample(@Param("record") CompanyExItem record, @Param("example") CompanyExItemExample example);

    int updateByPrimaryKeySelective(CompanyExItem record);

    int updateByPrimaryKey(CompanyExItem record);
}