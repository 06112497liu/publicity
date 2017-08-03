/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import com.bbd.domain.CompareTask;
import com.google.common.base.Optional;

/**
 * 对比任务接口
 *
 * @author tjwang
 * @version $Id: ICompareTaskService.java, v 0.1 2017/7/12 0012 14:43 tjwang Exp $
 */
public interface ICompareTaskService {

    CompareTask getById(Long id);

    /**
     * 创建下一次对比任务
     *
     * @param type 1.年报；2.
     * @return
     */
    Long createNextCompareTask(int type);

    /**
     * 获取正在运行的任务
     *
     * @param type
     * @return
     */
    Optional<CompareTask> getCurrentRunningTask(int type);

    /**
     * 获取最后一次执行的年报比较任务
     *
     * @return
     */
    Optional<CompareTask> getLastAnnualTask();

    /**
     * 更新任务数量统计信息
     *
     * @param taskId
     * @param nbxh
     * @param count
     */
    void updateCompareTaskInfo(long taskId, String nbxh, int count);

    /**
     * 完成年报对比任务
     *
     * @param taskId
     */
    void finishAnnualCompareTask(long taskId);

    /**
     * 完成即时信息对比任务
     *
     * @param taskId
     */
    void finishInstantlyCompareTask(long taskId);

    /**
     * 更新新增异常企业数量
     *
     * @param taskId
     * @param nbxh
     */
    void updateExIncreased(long taskId, String nbxh);

}
