
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
 * @version $Id: EquityChangeVo.java, v 0.1 2017年7月14日 下午2:59:09 liuweibo Exp $ 
 */
@ApiModel("年报股权变更信息返回对象")
public class EquityChangeVo {

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "股东", required = false)
    private String shareholder;

    @ApiModelProperty(value = "变更前股权比例", required = false)
    private Double preEquityRatio;

    @ApiModelProperty(value = "变更后股权比例", required = false)
    private Double aftEquityRatio;

    @ApiModelProperty(value = "股权变更日期", required = false)
    @JsonFormat(pattern = "yyyy年MM年dd月", timezone = "GMT+8")
    private Date changeDate;

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

    @Override
    public String toString() {
        return "EquityChangeVo [nbxh=" + nbxh + ", serialNo=" + serialNo + ", shareholder=" + shareholder + ", preEquityRatio=" + preEquityRatio + ", aftEquityRatio=" + aftEquityRatio
               + ", changeDate=" + changeDate + "]";
    }    
    
}

