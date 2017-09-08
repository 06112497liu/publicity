
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
    private String grossRevenue;
    
    /** 纳税情况   */
    private String taxTotal;
    
    /** 金融贷款  */
    private String loan;
    
    /** 盈余总额   */
    private String proTotalNet;
    
    /** 获得政府扶持基金、补助   */
    private String supFund;

    public String getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(String grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public String getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(String taxTotal) {
        this.taxTotal = taxTotal;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getProTotalNet() {
        return proTotalNet;
    }

    public void setProTotalNet(String proTotalNet) {
        this.proTotalNet = proTotalNet;
    }

    public String getSupFund() {
        return supFund;
    }

    public void setSupFund(String supFund) {
        this.supFund = supFund;
    }
    
}

