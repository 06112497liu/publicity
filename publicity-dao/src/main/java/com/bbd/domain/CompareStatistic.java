package com.bbd.domain;

import java.util.Date;

public class CompareStatistic {
    private Long id;

    private Integer annualTotal;

    private Integer annualItemTotal;

    private Integer instantlyTotal;

    private Integer instantlyItemTotal;

    private Integer annualExTotal;

    private Integer instantlyExTotal;

    private Integer exTotal;

    private Integer total;

    private Integer totalItem;

    private Integer startTime;

    private Integer fullTaskNum;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnnualTotal() {
        return annualTotal;
    }

    public void setAnnualTotal(Integer annualTotal) {
        this.annualTotal = annualTotal;
    }

    public Integer getAnnualItemTotal() {
        return annualItemTotal;
    }

    public void setAnnualItemTotal(Integer annualItemTotal) {
        this.annualItemTotal = annualItemTotal;
    }

    public Integer getInstantlyTotal() {
        return instantlyTotal;
    }

    public void setInstantlyTotal(Integer instantlyTotal) {
        this.instantlyTotal = instantlyTotal;
    }

    public Integer getInstantlyItemTotal() {
        return instantlyItemTotal;
    }

    public void setInstantlyItemTotal(Integer instantlyItemTotal) {
        this.instantlyItemTotal = instantlyItemTotal;
    }

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

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getFullTaskNum() {
        return fullTaskNum;
    }

    public void setFullTaskNum(Integer fullTaskNum) {
        this.fullTaskNum = fullTaskNum;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}