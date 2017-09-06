
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report;

/** 
 *  
 * @author liuweibo 
 * @version $Id: StockholderInfo.java, v 0.1 2017年9月5日 下午2:45:46 liuweibo Exp $ 
 */
public class StockholderInfo {
    
    /** 行号  */
    private Integer line;
    
    /** 股东  */
    private String shareholder;
    
    /** 认缴出资额  */
    private Double subCronCap;
    
    /** 认缴出资时间  */
    private String subCronDate;
    
    /** 认缴出资方式  */
    private String subCroFromDesc;
    
    /** 实缴出资额  */
    private Double acCronCap;
    
    /** 实缴出资时间  */
    private String acCronDate;
    
    /** 实缴出资方式  */
    private String acCronFromDesc;

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
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

    public String getAcCronDate() {
        return acCronDate;
    }

    public void setAcCronDate(String acCronDate) {
        this.acCronDate = acCronDate;
    }

    public String getSubCroFromDesc() {
        return subCroFromDesc;
    }

    public void setSubCroFromDesc(String subCroFromDesc) {
        this.subCroFromDesc = subCroFromDesc;
    }

    public Double getAcCronCap() {
        return acCronCap;
    }

    public void setAcCronCap(Double acCronCap) {
        this.acCronCap = acCronCap;
    }

    public String getSubCronDate() {
        return subCronDate;
    }

    public void setSubCronDate(String subCronDate) {
        this.subCronDate = subCronDate;
    }

    public String getAcCronFromDesc() {
        return acCronFromDesc;
    }

    public void setAcCronFromDesc(String acCronFromDesc) {
        this.acCronFromDesc = acCronFromDesc;
    }

}

