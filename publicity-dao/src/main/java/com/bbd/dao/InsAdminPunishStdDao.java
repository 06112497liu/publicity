package com.bbd.dao;

import com.bbd.domain.InsAdminPunishStd;
import com.bbd.domain.InsAdminPunishStdExample;
import com.mybatis.domain.PageBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsAdminPunishStdDao {
    int deleteByPrimaryKey(Long id);

    int insert(InsAdminPunishStd record);

    int insertSelective(InsAdminPunishStd record);

    List<InsAdminPunishStd> selectByExampleWithPageBounds(InsAdminPunishStdExample example, PageBounds pageBounds);

    List<InsAdminPunishStd> selectByExample(InsAdminPunishStdExample example);

    InsAdminPunishStd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InsAdminPunishStd record, @Param("example") InsAdminPunishStdExample example);

    int updateByExample(@Param("record") InsAdminPunishStd record, @Param("example") InsAdminPunishStdExample example);

    int updateByPrimaryKeySelective(InsAdminPunishStd record);

    int updateByPrimaryKey(InsAdminPunishStd record);
}