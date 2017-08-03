package com.bbd.dao;

import org.apache.ibatis.annotations.Param;

public interface CompareStatisticExtDao {

    /**
     * 更新年报统计数量
     *
     * @param itemNum
     */
    void updateAnnualCount(@Param("id") long id, @Param("itemNum") int itemNum, @Param("flag") boolean flag);

    /**
     * 更新即时信息统计数量
     *
     * @param itemNum
     */
    void updateInstantlyCount(@Param("id") long id, @Param("itemNum") int itemNum, @Param("flag") boolean flag);

    /**
     * 更新执行完成任务数量
     */
    void updateFullTaskNum();

}