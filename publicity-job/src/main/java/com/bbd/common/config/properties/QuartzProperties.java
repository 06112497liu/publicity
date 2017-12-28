/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tjwang
 * @version $Id: QuartzProperties.java, v 0.1 2017/7/5 0005 18:12 tjwang Exp $
 */
@Component
@ConfigurationProperties(prefix = "quartz", ignoreUnknownFields = true)
public class QuartzProperties {

    private String instanceName;

    /**
     * 年报定时任务表达式
     */
    private String annualCmpJobExpression;

    /**
     * 即时信息定时任务表达式
     */
    private String insCmpJobExpression;

    /**
     * 记录被删除企业定时任务表达式
     */
    private String recordDeletedCompanyExpression;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getAnnualCmpJobExpression() {
        return annualCmpJobExpression;
    }

    public void setAnnualCmpJobExpression(String annualCmpJobExpression) {
        this.annualCmpJobExpression = annualCmpJobExpression;
    }

    public String getInsCmpJobExpression() {
        return insCmpJobExpression;
    }

    public void setInsCmpJobExpression(String insCmpJobExpression) {
        this.insCmpJobExpression = insCmpJobExpression;
    }

    public String getRecordDeletedCompanyExpression() {
        return recordDeletedCompanyExpression;
    }

    public void setRecordDeletedCompanyExpression(String recordDeletedCompanyExpression) {
        this.recordDeletedCompanyExpression = recordDeletedCompanyExpression;
    }
}
