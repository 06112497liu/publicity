package com.bbd.domain;

import java.util.Date;

public class CompareTask {
    private Long id;

    private Integer type;

    private Integer num;

    private String curNbxh;

    private Integer total;

    private Integer totalItem;

    private Integer exNum;

    private Date beginTime;

    private Date endTime;

    private Integer exIncreased;

    private Integer exDecrease;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCurNbxh() {
        return curNbxh;
    }

    public void setCurNbxh(String curNbxh) {
        this.curNbxh = curNbxh;
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

    public Integer getExNum() {
        return exNum;
    }

    public void setExNum(Integer exNum) {
        this.exNum = exNum;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExIncreased() {
        return exIncreased;
    }

    public void setExIncreased(Integer exIncreased) {
        this.exIncreased = exIncreased;
    }

    public Integer getExDecrease() {
        return exDecrease;
    }

    public void setExDecrease(Integer exDecrease) {
        this.exDecrease = exDecrease;
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