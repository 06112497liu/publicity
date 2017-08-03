/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.param;

/**
 * @author tjwang
 * @version $Id: ExceptionSearchParam.java, v 0.1 2017/7/18 0018 16:47 tjwang Exp $
 */
public class ExceptionSearchParam {

    /**
     * 地区
     */
    private String region;

    /**
     * 行业
     */
    private String primaryIndustry;

    /**
     * 对比属性
     */
    private int moduleType;

    /**
     * 异常类型
     */
    private int exType;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }

    public int getExType() {
        return exType;
    }

    public void setExType(int exType) {
        this.exType = exType;
    }
}
