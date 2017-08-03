/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tjwang
 * @version $Id: ExceptionCompanyVo.java, v 0.1 2017/7/18 0018 17:46 tjwang Exp $
 */
@ApiModel("异常企业名单返回对象")
public class ExceptionCompanyVo {

    private long id;

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;
    
    @ApiModelProperty(value = "公司名称", required = false)
    private String companyName;

    @ApiModelProperty(value = "异常项数量", required = false)
    private int count;

    @ApiModelProperty(value = "比对时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date compareTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCompareTime() {
        return compareTime;
    }

    public void setCompareTime(Date compareTime) {
        this.compareTime = compareTime;
    }
}
