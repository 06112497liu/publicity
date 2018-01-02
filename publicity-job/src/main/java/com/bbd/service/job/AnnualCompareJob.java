/**
.
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job;

import com.bbd.common.Constants;
import com.bbd.domain.CompareTask;
import com.bbd.service.ICompareTaskService;
import com.bbd.service.ITaskExecuteService;
import com.google.common.base.Optional;
import org.joda.time.DateTime;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Date;

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
                if (!needExecuteAnnualJob()) {
                    return;
                }
                Long taskId = compareTaskService.createNextCompareTask(Constants.TASK_ANNUAL_TYPE);
                task = compareTaskService.getById(taskId);
            }
            taskExecuteService.excuteCompareTask(task.getId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    // 判断是否需要进行年报对比
    private boolean needExecuteAnnualJob() {
        DateTime now = DateTime.now();
        int nowYear = now.getYear();
        // 年报对比周期（每年的7月到12月对比年报）
        DateTime start = new DateTime(nowYear, 7, 1, 0, 0);
        DateTime end = new DateTime(nowYear + 1, 1, 1, 0, 0);
        if (now.isAfter(start) && now.isBefore(end)) {
            Optional<CompareTask> op = compareTaskService.getLastAnnualTask();
            if (op.isPresent()) {
                CompareTask task = op.get();
                DateTime compareTime = new DateTime(task.getBeginTime());
                if (compareTime.isBefore(end) && compareTime.isAfter(start)) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}




















