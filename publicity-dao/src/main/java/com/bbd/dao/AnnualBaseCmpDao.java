package com.bbd.dao;

import com.bbd.domain.AnnualBaseCmp;
import com.bbd.domain.AnnualBaseCmpExample;
import com.mybatis.domain.PageBounds;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnualBaseCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(AnnualBaseCmp record);

    int insertSelective(AnnualBaseCmp record);

    List<AnnualBaseCmp> selectByExampleWithPageBounds(AnnualBaseCmpExample example, PageBounds pageBounds);

    List<AnnualBaseCmp> selectByExample(AnnualBaseCmpExample example);

    AnnualBaseCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnnualBaseCmp record, @Param("example") AnnualBaseCmpExample example);

    int updateByExample(@Param("record") AnnualBaseCmp record, @Param("example") AnnualBaseCmpExample example);

    int updateByPrimaryKeySelective(AnnualBaseCmp record);

    int updateByPrimaryKey(AnnualBaseCmp record);
}