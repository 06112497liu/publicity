package com.bbd.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("公示系统首页统计数据返回对象")
public class CompareStatisticVo {

    @ApiModelProperty(value = "年报异常企业户数", required = false)
    private Integer annualExTotal;

    @ApiModelProperty(value = "即时信息异常企业数量", required = false)
    private Integer instantlyExTotal;

    @ApiModelProperty(value = "异常企业总数", required = false)
    private Integer exTotal;

    @ApiModelProperty(value = "比对企业户数", required = false)
    private Integer total;

    @ApiModelProperty(value = "比对数据条数", required = false)
    private Integer totalItem;

    @ApiModelProperty(value = "全量比对次数", required = false)
    private Integer fullTaskNum;

    @ApiModelProperty(value = "持续运行天数", required = false)
    private Integer runnedDays;    

    public Integer getAnnualExTotal() {
        return annualExTotal;
    }

    public void setAnnualExTotal(Integer annualExTotal) {
        this.annualExTotal = annualExTotal;
    }

    public Integer getInstantlyExTotal() {
        return instantlyExTotal;
    }

    public void setInstantlyExTotal(Integer instantlyExTotal) {
        this.instantlyExTotal = instantlyExTotal;
    }

    public Integer getExTotal() {
        return exTotal;
    }

    public void setExTotal(Integer exTotal) {
        this.exTotal = exTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer getFullTaskNum() {
        return fullTaskNum;
    }

    public void setFullTaskNum(Integer fullTaskNum) {
        this.fullTaskNum = fullTaskNum;
    }

    public Integer getRunnedDays() {
        return runnedDays;
    }

    public void setRunnedDays(Integer runnedDays) {
        this.runnedDays = runnedDays;
    }
}