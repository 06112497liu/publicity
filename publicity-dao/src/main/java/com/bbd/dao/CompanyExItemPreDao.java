package com.bbd.dao;

import com.bbd.domain.CompanyExItemPre;
import com.bbd.domain.CompanyExItemPreExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyExItemPreDao {
    int deleteByPrimaryKey(Long id);

    int insert(CompanyExItemPre record);

    int insertSelective(CompanyExItemPre record);

    List<CompanyExItemPre> selectByExampleWithPageBounds(CompanyExItemPreExample example, PageBounds pageBounds);

    List<CompanyExItemPre> selectByExample(CompanyExItemPreExample example);

    CompanyExItemPre selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CompanyExItemPre record, @Param("example") CompanyExItemPreExample example);

    int updateByExample(@Param("record") CompanyExItemPre record, @Param("example") CompanyExItemPreExample example);

    int updateByPrimaryKeySelective(CompanyExItemPre record);

    int updateByPrimaryKey(CompanyExItemPre record);
}