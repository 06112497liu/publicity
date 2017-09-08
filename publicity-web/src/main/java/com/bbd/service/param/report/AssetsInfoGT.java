
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: AssetsInfoGT.java, v 0.1 2017年9月6日 上午9:56:53 liuweibo Exp $ 
 */
public class AssetsInfoGT extends AssetsInfo {
    
    /** 销售额或营业收入   */
    private String grossRevenue;
    
    /** 纳税总额   */
    private String taxTotal;

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
    
    
}

