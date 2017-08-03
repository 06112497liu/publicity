package com.bbd.domain;

import java.util.Date;

public class InsStockholderCmp {
    private Long id;

    private String nbxh;

    private String shareholder;

    private String subCronFrom;

    private Double subCronCap;

    private Date subCronDate;

    private String acCronFrom;

    private Double acCronCap;

    private Date acCronDate;

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

    public String getShareholder() {
        return shareholder;
    }

    public void setShareholder(String shareholder) {
        this.shareholder = shareholder;
    }

    public String getSubCronFrom() {
        return subCronFrom;
    }

    public void setSubCronFrom(String subCronFrom) {
        this.subCronFrom = subCronFrom;
    }

    public Double getSubCronCap() {
        return subCronCap;
    }

    public void setSubCronCap(Double subCronCap) {
        this.subCronCap = subCronCap;
    }

    public Date getSubCronDate() {
        return subCronDate;
    }

    public void setSubCronDate(Date subCronDate) {
        this.subCronDate = subCronDate;
    }

    public String getAcCronFrom() {
        return acCronFrom;
    }

    public void setAcCronFrom(String acCronFrom) {
        this.acCronFrom = acCronFrom;
    }

    public Double getAcCronCap() {
        return acCronCap;
    }

    public void setAcCronCap(Double acCronCap) {
        this.acCronCap = acCronCap;
    }

    public Date getAcCronDate() {
        return acCronDate;
    }

    public void setAcCronDate(Date acCronDate) {
        this.acCronDate = acCronDate;
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