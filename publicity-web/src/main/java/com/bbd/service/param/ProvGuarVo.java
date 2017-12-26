
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
 * @version $Id: ProvGuarVo.java, v 0.1 2017年7月14日 下午3:07:25 liuweibo Exp $ 
 */
@ApiModel("年报对外提供保证担保信息返回对象")
public class ProvGuarVo {

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "债权人", required = false)
    private String creditor;

    @ApiModelProperty(value = "债务人", required = false)
    private String debitor;

    @ApiModelProperty(value = "主债权种类（1.合同、2.其他）", required = false)
    private String priCalSecKind;

    @ApiModelProperty(value = "主债权数额", required = false)
    private Double priCalSecAm;

    @ApiModelProperty(value = "履行债务的期限自", required = false)
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date pefPerFrom;

    @ApiModelProperty(value = "履行债务的期限至", required = false)
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date pefPerTo;

    @ApiModelProperty(value = "保证的期间（1.期限、2.未约定）", required = false)
    private String guarantePeriod;

    @ApiModelProperty(value = "保证的方式（1.一般保证、2.连带责任保证、3.未约定）", required = false)
    private String guaranteType;

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
        return priCalSecAm == null ? 0 : priCalSecAm;
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

    @Override
    public String toString() {
        return "ProvGuarVo [nbxh=" + nbxh + ", serialNo=" + serialNo + ", creditor=" + creditor + ", debitor=" + debitor + ", priCalSecKind=" + priCalSecKind + ", priCalSecAm=" + priCalSecAm
               + ", pefPerFrom=" + pefPerFrom + ", pefPerTo=" + pefPerTo + ", guarantePeriod=" + guarantePeriod + ", guaranteType=" + guaranteType + "]";
    }

}

