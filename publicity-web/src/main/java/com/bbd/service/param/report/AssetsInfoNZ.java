
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: AssetsInfoNZ.java, v 0.1 2017年9月6日 上午9:56:33 liuweibo Exp $ 
 */
public class AssetsInfoNZ extends AssetsInfo {
    
    /** 销售额或营业收入   */
    private Double grossRevenue;
    
    /** 纳税情况   */
    private Double taxTotal;
    
    /** 金融贷款  */
    private Double loan;
    
    /** 盈余总额   */
    private Double proTotalNet;
    
    /** 获得政府扶持基金、补助   */
    private Double supFund;

    public Double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getProTotalNet() {
        return proTotalNet;
    }

    public void setProTotalNet(Double proTotalNet) {
        this.proTotalNet = proTotalNet;
    }

    public Double getSupFund() {
        return supFund;
    }

    public void setSupFund(Double supFund) {
        this.supFund = supFund;
    }
    
}

