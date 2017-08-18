package com.bbd.dao;

import com.bbd.domain.PubCompanyInfo;
import com.bbd.domain.PubCompanyInfoExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PubCompanyInfoDao {
    long countByExample(PubCompanyInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PubCompanyInfo record);

    int insertSelective(PubCompanyInfo record);

    List<PubCompanyInfo> selectByExampleWithPageBounds(PubCompanyInfoExample example, PageBounds pageBounds);

    List<PubCompanyInfo> selectByExample(PubCompanyInfoExample example);

    PubCompanyInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PubCompanyInfo record, @Param("example") PubCompanyInfoExample example);

    int updateByExample(@Param("record") PubCompanyInfo record, @Param("example") PubCompanyInfoExample example);

    int updateByPrimaryKeySelective(PubCompanyInfo record);

    int updateByPrimaryKey(PubCompanyInfo record);
}