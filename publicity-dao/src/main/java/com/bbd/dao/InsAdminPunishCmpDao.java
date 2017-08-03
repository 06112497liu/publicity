package com.bbd.dao;

import com.bbd.domain.InsAdminPunishCmp;
import com.bbd.domain.InsAdminPunishCmpExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsAdminPunishCmpDao {
    int deleteByPrimaryKey(Long id);

    int insert(InsAdminPunishCmp record);

    int insertSelective(InsAdminPunishCmp record);

    List<InsAdminPunishCmp> selectByExampleWithPageBounds(InsAdminPunishCmpExample example, PageBounds pageBounds);

    List<InsAdminPunishCmp> selectByExample(InsAdminPunishCmpExample example);

    InsAdminPunishCmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InsAdminPunishCmp record, @Param("example") InsAdminPunishCmpExample example);

    int updateByExample(@Param("record") InsAdminPunishCmp record, @Param("example") InsAdminPunishCmpExample example);

    int updateByPrimaryKeySelective(InsAdminPunishCmp record);

    int updateByPrimaryKey(InsAdminPunishCmp record);
}