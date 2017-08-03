
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: StockholderInfosVo.java, v 0.1 2017年7月14日 上午11:39:17 liuweibo Exp $ 
 */
@ApiModel("年报股东及出资公司返回对象")
public class StockholderInfosVo {
    
    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "股东", required = false)
    private String shareholder;

    @ApiModelProperty(value = "认缴出资额（万元）", required = false)
    private Double subCronCap;

    @ApiModelProperty(value = "认缴出资时间", required = false)
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date subCronDate;

    @ApiModelProperty(value = "认缴出资方式", required = false)
    private String subCronFrom;

    @ApiModelProperty(value = "实缴出资额（万元）", required = false)
    private Double acCronCap;

    @ApiModelProperty(value = "实缴出资时间", required = false)
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date acCronDate;

    @ApiModelProperty(value = "实缴出资方式", required = false)
    private String acCronFrom;

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

    public String getSubCronFrom() {
        return subCronFrom;
    }

    public void setSubCronFrom(String subCronFrom) {
        this.subCronFrom = subCronFrom;
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

    public String getAcCronFrom() {
        return acCronFrom;
    }

    public void setAcCronFrom(String acCronFrom) {
        this.acCronFrom = acCronFrom;
    }

    @Override
    public String toString() {
        return "StockholderInfosVo [nbxh=" + nbxh + ", serialNo=" + serialNo + ", shareholder=" + shareholder + ", subCronCap=" + subCronCap + ", subCronDate=" + subCronDate + ", subCronFrom="
               + subCronFrom + ", acCronCap=" + acCronCap + ", acCronDate=" + acCronDate + ", acCronFrom=" + acCronFrom + "]";
    }
    
    
}

