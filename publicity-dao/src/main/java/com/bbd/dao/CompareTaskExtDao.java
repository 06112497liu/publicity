/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author tjwang
 * @version $Id: CompareTaskExtDao.java, v 0.1 2017/7/12 0012 18:04 tjwang Exp $
 */
public interface CompareTaskExtDao {

    /**
     * 更新任务数量统计
     *
     * @param id
     * @param total
     * @param totalItem
     */
    int updateCount(@Param("id") long id, @Param("total") int total, @Param("totalItem") int totalItem);
    
    /**
     * 更新异常企业增量
     *
     * @param id
     * @return
     */
    int updateExIncreased(@Param("id") long id);
    
    /**
     * 更新异常企业减量
     *
     * @param id
     * @return
     */
    int updateExDecreased(@Param("id") long id);

}
