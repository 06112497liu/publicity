/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common;

/**
 * @author tjwang
 * @version $Id: Constants.java, v 0.1 2017/7/12 0012 15:49 tjwang Exp $
 */
public class Constants {

    /**
     * 年报任务类型
     */
    public static final int TASK_ANNUAL_TYPE = 1;
    /**
     * 即时信息任务类型
     */
    public static final int TASK_INSTANTLY_TYPE = 2;

    /**
     * 企业
     */
    public static final int COMPANY_PROPERTY_ENTERPISE = 1;
    /**
     * 个体
     */
    public static final int COMPANY_PROPERTY_PERSONAL = 2;
    /**
     * 农专社
     */
    public static final int COMPANY_PROPERTY_NZ = 3;

    // 异常类型
    /**
     * 正常
     */
    public static final int EX_TYPE_NORMAL = 0;
    /**
     * 隐瞒未报
     */
    public static final int EX_TYPE_HIDE = 1;

    /**
     * 登记不一致
     */
    public static final int EX_TYPE_NOT_IDENTICAL = 2;

    /**
     * 格式错误
     */
    public static final int EX_TYPE_INVALID_FORMAT = 4;
}
