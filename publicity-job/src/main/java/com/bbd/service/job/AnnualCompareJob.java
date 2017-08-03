/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job;

import com.bbd.common.Constants;
import com.bbd.domain.CompareTask;
import com.bbd.service.ICompareTaskService;
import com.bbd.service.ITaskExecuteService;
import com.google.common.base.Optional;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 年报对比任务
 *
 * @author tjwang
 * @version $Id: AnnualCompareJob.java, v 0.1 2017/7/12 0012 14:27 tjwang Exp $
 */
@DisallowConcurrentExecution
public class AnnualCompareJob extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICompareTaskService compareTaskService;

    @Resource(name = "annualTaskExecuteService")
    private ITaskExecuteService taskExecuteService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Execute AnnualCompareJob");
        try {
            CompareTask task;
            Optional<CompareTask> opt = compareTaskService.getCurrentRunningTask(Constants.TASK_ANNUAL_TYPE);
            if (opt.isPresent()) {
                task = opt.get();
            } else {
                Long taskId = compareTaskService.createNextCompareTask(Constants.TASK_ANNUAL_TYPE);
                task = compareTaskService.getById(taskId);
            }
            taskExecuteService.excuteCompareTask(task.getId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
