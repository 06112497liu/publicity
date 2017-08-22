/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.job;

import com.bbd.common.Constants;
import com.bbd.domain.CompareTask;
import com.bbd.service.ICompareTaskService;
import com.bbd.service.ITaskExecuteService;
import com.bbd.util.DateUtil;
import com.google.common.base.Optional;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.time.LocalDate;
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
        boolean flag = true;
        // 1. 获取上次年报对比任务
        Optional<CompareTask> task = compareTaskService.getLastAnnualTask();
        if (task.isPresent()) {
            CompareTask taskInfo = task.get();
            LocalDate d = LocalDate.of(LocalDate.now().getYear(), 8, 1);
            int baseDay = d.getDayOfYear();
            Date compareTime = taskInfo.getEndTime();
            LocalDate temp = DateUtil.convertDateToLocalDate(compareTime);
            int year = temp.getYear();
            int day = temp.getDayOfYear();
            if (year == LocalDate.now().getYear()) {
                flag = (day < baseDay);
            }
        }
        return flag;
    }
}




















