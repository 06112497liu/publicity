
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: AssetsInfoQY.java, v 0.1 2017年9月6日 上午9:56:12 liuweibo Exp $ 
 */
public class AssetsInfoQY extends AssetsInfo {
    
    /** 资产总额   */
    private Double assTotal;
    
    /** 所有者权益合计   */
    private Double ownEquity;
    
    /** 营业总收入   */
    private Double grossRevenue;
    
    /** 利润总额   */
    private Double proTotal;
    
    /** 营业总收入中主营业务收入   */
    private Double mainGrossRevenue;
    
    /** 净利润   */
    private Double proNet;
    
    /** 纳税总额   */
    private Double taxTotal;
    
    /** 负债总额   */
    private Double liabTotal;

    public Double getAssTotal() {
        return assTotal;
    }

    public void setAssTotal(Double assTotal) {
        this.assTotal = assTotal;
    }

    public Double getOwnEquity() {
        return ownEquity;
    }

    public void setOwnEquity(Double ownEquity) {
        this.ownEquity = ownEquity;
    }

    public Double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(Double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public Double getProTotal() {
        return proTotal;
    }

    public void setProTotal(Double proTotal) {
        this.proTotal = proTotal;
    }

    public Double getMainGrossRevenue() {
        return mainGrossRevenue;
    }

    public void setMainGrossRevenue(Double mainGrossRevenue) {
        this.mainGrossRevenue = mainGrossRevenue;
    }

    public Double getProNet() {
        return proNet;
    }

    public void setProNet(Double proNet) {
        this.proNet = proNet;
    }

    public Double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(Double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Double getLiabTotal() {
        return liabTotal;
    }

    public void setLiabTotal(Double liabTotal) {
        this.liabTotal = liabTotal;
    }
    
}

