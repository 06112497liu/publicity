/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

/**
 * 任务执行服务
 *
 * @author tjwang
 * @version $Id: ITaskExecuteService.java, v 0.1 2017/7/13 0013 17:53 tjwang Exp $
 */
public interface ITaskExecuteService {

    /**
     * 执行对比任务
     *
     * @param taskId
     */
    void excuteCompareTask(Long taskId);

}
