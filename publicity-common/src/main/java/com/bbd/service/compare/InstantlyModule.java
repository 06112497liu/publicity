/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare;

/**
 * 即时信息对比模块
 *
 * @author tjwang
 * @version $Id: InstantlyModule.java, v 0.1 2017/7/17 0017 14:53 tjwang Exp $
 */
public enum InstantlyModule {

    STOCKHOLDER(1, "股东及出资信息"),
    ADMIN_LICENSE(2, "行政许可信息"),
    ADMIN_PUBLISH(4, "行政处罚信息"),
    EQUITY_CHANGE(8, "股权变更信息"),
    KNOWLEDGE_EQUITY(16, "知识产权出质登记信息"),
    CANCELLATION_NOTICE(32, "企业简易注销公告");
    
    private int code;

    private String desc;

    InstantlyModule(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }    
    
}
