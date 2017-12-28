package com.bbd.service.job;

import com.bbd.service.IRecordService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 记录被删除企业的定时任务
 * @author Liuweibo
 * @version Id: RecordDeletedCompanyJob.java, v0.1 2017/12/28 Liuweibo Exp $$
 */
@DisallowConcurrentExecution
public class RecordDeletedCompanyJob extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IRecordService recordService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Execute RecordDeletedCompanyJob");
        recordService.recordDeletedCompany();
        logger.info("RecordDeletedCompanyJob end");
    }
}
    
    