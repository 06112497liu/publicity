package com.bbd.domain;

import java.util.Date;

public class AnnualEquityChange {
    private Long id;

    private String nbxh;

    private String serialNo;

    private String shareholder;

    private Double preEquityRatio;

    private Double aftEquityRatio;

    private Date changeDate;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getShareholder() {
        return shareholder;
    }

    public void setShareholder(String shareholder) {
        this.shareholder = shareholder;
    }

    public Double getPreEquityRatio() {
        return preEquityRatio;
    }

    public void setPreEquityRatio(Double preEquityRatio) {
        this.preEquityRatio = preEquityRatio;
    }

    public Double getAftEquityRatio() {
        return aftEquityRatio;
    }

    public void setAftEquityRatio(Double aftEquityRatio) {
        this.aftEquityRatio = aftEquityRatio;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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