
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: EnterpriseAssetVo.java, v 0.1 2017年7月14日 下午2:37:26 liuweibo Exp $ 
 */
@ApiModel("年报企业资产状况信息返回对象")
public class EnterpriseAssetVo {

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "资产总额", required = false)
    private Double assTotal;

    @ApiModelProperty(value = "营业总收入", required = false)
    private Double grossRevenue;

    @ApiModelProperty(value = "营业总收入中主营业务收入", required = false)
    private Double mainGrossRevenue;

    @ApiModelProperty(value = "纳税总额", required = false)
    private Double taxTotal;

    @ApiModelProperty(value = "所有者权益合计", required = false)
    private Double ownEquity;

    @ApiModelProperty(value = "利润总额", required = false)
    private Double proTotal;

    @ApiModelProperty(value = "净利润", required = false)
    private Double proNet;

    @ApiModelProperty(value = "负债总额", required = false)
    private Double liabTotal;

    @ApiModelProperty(value = "盈余总额（农专）", required = false)
    private Double proTotalNet;

    @ApiModelProperty(value = "获得政府扶持资金、补助（农专）", required = false)
    private Double supFund;

    @ApiModelProperty(value = "金融贷款（农专）", required = false)
    private Double loan;

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

    public Double getAssTotal() {
        return assTotal == null ? 0 : assTotal;
    }

    public void setAssTotal(Double assTotal) {
        this.assTotal = assTotal;
    }

    public Double getGrossRevenue() {
        return grossRevenue == null ? 0 : grossRevenue;
    }

    public void setGrossRevenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public Double getMainGrossRevenue() {
        return mainGrossRevenue == null ? 0 : mainGrossRevenue;
    }

    public void setMainGrossRevenue(Double mainGrossRevenue) {
        this.mainGrossRevenue = mainGrossRevenue;
    }

    public Double getTaxTotal() {
        return taxTotal == null ? 0 : taxTotal;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getOwnEquity() {
        return ownEquity == null ? 0 : ownEquity;
    }

    public void setOwnEquity(Double ownEquity) {
        this.ownEquity = ownEquity;
    }

    public Double getProTotal() {
        return proTotal == null ? 0 : proTotal;
    }

    public void setProTotal(Double proTotal) {
        this.proTotal = proTotal;
    }

    public Double getProNet() {
        return proNet == null ? 0 : proNet;
    }

    public void setProNet(Double proNet) {
        this.proNet = proNet;
    }

    public Double getLiabTotal() {
        return liabTotal == null ? 0 : liabTotal;
    }

    public void setLiabTotal(Double liabTotal) {
        this.liabTotal = liabTotal;
    }

    public Double getProTotalNet() {
        return proTotalNet == null ? 0 : proTotalNet;
    }

    public void setProTotalNet(Double proTotalNet) {
        this.proTotalNet = proTotalNet;
    }

    public Double getSupFund() {
        return supFund == null ? 0 : supFund;
    }

    public void setSupFund(Double supFund) {
        this.supFund = supFund;
    }

    public Double getLoan() {
        return loan == null ? 0 : loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "EnterpriseAssetVo [nbxh=" + nbxh + ", serialNo=" + serialNo + ", assTotal=" + assTotal + ", grossRevenue=" + grossRevenue + ", mainGrossRevenue=" + mainGrossRevenue + ", taxTotal="
               + taxTotal + ", ownEquity=" + ownEquity + ", proTotal=" + proTotal + ", proNet=" + proNet + ", liabTotal=" + liabTotal + ", proTotalNet=" + proTotalNet + ", supFund=" + supFund
               + ", loan=" + loan + "]";
    }   
    
}

