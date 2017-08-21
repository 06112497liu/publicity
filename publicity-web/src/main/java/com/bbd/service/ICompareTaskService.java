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

    /**
     * 获取正在运行的任务
     *
     * @param type
     * @return
     */
    Optional<CompareTask> getCurrentRunningTask(int type);
    
    /**
     * 获取上一次对比信息
     *
     * @param type
     * @return
     */
    Optional<CompareTask> getLastTask(int type, int last);


}
