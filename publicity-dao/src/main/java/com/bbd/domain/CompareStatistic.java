package com.bbd.domain;

import java.util.Date;

public class CompareStatistic {
    private Long id;

    private Long annualTotal;

    private Long annualItemTotal;

    private Long instantlyTotal;

    private Long instantlyItemTotal;

    private Long annualExTotal;

    private Long instantlyExTotal;

    private Long exTotal;

    private Long total;

    private Long totalItem;

    private Date startTime;

    private Integer fullTaskNum;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnnualTotal() {
        return annualTotal;
    }

    public void setAnnualTotal(Long annualTotal) {
        this.annualTotal = annualTotal;
    }

    public Long getAnnualItemTotal() {
        return annualItemTotal;
    }

    public void setAnnualItemTotal(Long annualItemTotal) {
        this.annualItemTotal = annualItemTotal;
    }

    public Long getInstantlyTotal() {
        return instantlyTotal;
    }

    public void setInstantlyTotal(Long instantlyTotal) {
        this.instantlyTotal = instantlyTotal;
    }

    public Long getInstantlyItemTotal() {
        return instantlyItemTotal;
    }

    public void setInstantlyItemTotal(Long instantlyItemTotal) {
        this.instantlyItemTotal = instantlyItemTotal;
    }

    public Long getAnnualExTotal() {
        return annualExTotal;
    }

    public void setAnnualExTotal(Long annualExTotal) {
        this.annualExTotal = annualExTotal;
    }

    public Long getInstantlyExTotal() {
        return instantlyExTotal;
    }

    public void setInstantlyExTotal(Long instantlyExTotal) {
        this.instantlyExTotal = instantlyExTotal;
    }

    public Long getExTotal() {
        return exTotal;
    }

    public void setExTotal(Long exTotal) {
        this.exTotal = exTotal;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
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