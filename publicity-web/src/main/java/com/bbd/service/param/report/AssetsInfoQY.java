
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
    private String assTotal;
    
    /** 所有者权益合计   */
    private String ownEquity;
    
    /** 营业总收入   */
    private String grossRevenue;
    
    /** 利润总额   */
    private String proTotal;
    
    /** 营业总收入中主营业务收入   */
    private String mainGrossRevenue;
    
    /** 净利润   */
    private String proNet;
    
    /** 纳税总额   */
    private String taxTotal;
    
    /** 负债总额   */
    private String liabTotal;

    public String getAssTotal() {
        return assTotal;
    }

    public void setAssTotal(String assTotal) {
        this.assTotal = assTotal;
    }

    public String getOwnEquity() {
        return ownEquity;
    }

    public void setOwnEquity(String ownEquity) {
        this.ownEquity = ownEquity;
    }

    public String getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(String grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public String getProTotal() {
        return proTotal;
    }

    public void setProTotal(String proTotal) {
        this.proTotal = proTotal;
    }

    public String getMainGrossRevenue() {
        return mainGrossRevenue;
    }

    public void setMainGrossRevenue(String mainGrossRevenue) {
        this.mainGrossRevenue = mainGrossRevenue;
    }

    public String getProNet() {
        return proNet;
    }

    public void setProNet(String proNet) {
        this.proNet = proNet;
    }

    public String getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(String taxTotal) {
        this.taxTotal = taxTotal;
    }

    public String getLiabTotal() {
        return liabTotal;
    }

    public void setLiabTotal(String liabTotal) {
        this.liabTotal = liabTotal;
    }

}

