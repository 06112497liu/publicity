
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
    private Double grossRevenue;
    
    /** 纳税总额   */
    private Double taxTotal;

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
    
    
}

