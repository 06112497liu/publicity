/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common.config;

import com.bbd.common.config.properties.QuartzProperties;
import com.bbd.common.quartz.AutowiringSpringBeanJobFactory;
import com.bbd.service.job.AnnualCompareJob;
import com.bbd.service.job.InstantlyCompareJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * quartz配置
 *
 * @author tjwang
 * @version $Id: QuartzConfig.java, v 0.1 2017/7/6 0006 10:50 tjwang Exp $
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private QuartzProperties quartzProperties;

    private static JobDetailFactoryBean createJobDetail(Class<?> jobClass) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    private static CronTriggerFactoryBean createCronTriggerFactoryBean(JobDetail jobDetail, String cronExpression, long startDelay) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setCronExpression(cronExpression);
        cronTriggerFactoryBean.setStartDelay(startDelay);
        return cronTriggerFactoryBean;
    }

    private Properties getQuartzProperties() {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "publicity-job");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.jmx.export", "true");

        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.dataSource", "dataSource");
        prop.put("org.quartz.jobStore.tablePrefix", "qrtz_pub_");
        prop.put("org.quartz.jobStore.isClustered", "true");

        prop.put("org.quartz.jobStore.clusterCheckinInterval", "20000");
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        prop.put("org.quartz.jobStore.misfireThreshold", "120000");
        prop.put("org.quartz.jobStore.txIsolationLevelSerializable", "true");
        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS WHERE LOCK_NAME = ? FOR UPDATE");

        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "10");
        prop.put("org.quartz.threadPool.threadPriority", "5");
        prop.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");

        prop.put("org.quartz.plugin.triggHistory.class", "org.quartz.plugins.history.LoggingJobHistoryPlugin");
        prop.put("org.quartz.plugin.shutdownhook.class", "org.quartz.plugins.management.ShutdownHookPlugin");
        prop.put("org.quartz.plugin.shutdownhook.cleanShutdown", "true");
        return prop;
    }

    @Bean
    public JobDetailFactoryBean annualCompareJob() {
        return createJobDetail(AnnualCompareJob.class);
    }

    @Bean
    CronTriggerFactoryBean annualCompareJobTrigger() {
        String cronExpression = quartzProperties.getAnnualCmpJobExpression();
        return createCronTriggerFactoryBean(annualCompareJob().getObject(), cronExpression, 5);
    }

    @Bean
    public JobDetailFactoryBean instantlyCompareJob() {
        return createJobDetail(InstantlyCompareJob.class);
    }

    @Bean
    public CronTriggerFactoryBean instantlyCompareJobTrigger() {
        String cronExpression = quartzProperties.getInsCmpJobExpression();
        return createCronTriggerFactoryBean(instantlyCompareJob().getObject(), cronExpression, 5);
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger[] triggers) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setDataSource(dataSource);

        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setStartupDelay(10);
        schedulerFactoryBean.setQuartzProperties(getQuartzProperties());
        schedulerFactoryBean.setAutoStartup(true);

        schedulerFactoryBean.setTriggers(triggers);

        return schedulerFactoryBean;
    }

}
