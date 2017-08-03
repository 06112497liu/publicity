package com.bbd.domain;

import java.util.Date;

public class AnnualExtProvGuarInfoCmp {
    private Long id;

    private String nbxh;

    private String serialNo;

    private String creditor;

    private String debitor;

    private String priCalSecKind;

    private Double priCalSecAm;

    private Date pefPerFrom;

    private Date pefPerTo;

    private String guarantePeriod;

    private String guaranteType;

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

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebitor() {
        return debitor;
    }

    public void setDebitor(String debitor) {
        this.debitor = debitor;
    }

    public String getPriCalSecKind() {
        return priCalSecKind;
    }

    public void setPriCalSecKind(String priCalSecKind) {
        this.priCalSecKind = priCalSecKind;
    }

    public Double getPriCalSecAm() {
        return priCalSecAm;
    }

    public void setPriCalSecAm(Double priCalSecAm) {
        this.priCalSecAm = priCalSecAm;
    }

    public Date getPefPerFrom() {
        return pefPerFrom;
    }

    public void setPefPerFrom(Date pefPerFrom) {
        this.pefPerFrom = pefPerFrom;
    }

    public Date getPefPerTo() {
        return pefPerTo;
    }

    public void setPefPerTo(Date pefPerTo) {
        this.pefPerTo = pefPerTo;
    }

    public String getGuarantePeriod() {
        return guarantePeriod;
    }

    public void setGuarantePeriod(String guarantePeriod) {
        this.guarantePeriod = guarantePeriod;
    }

    public String getGuaranteType() {
        return guaranteType;
    }

    public void setGuaranteType(String guaranteType) {
        this.guaranteType = guaranteType;
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