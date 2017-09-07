
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report;

/** 
 *  
 * @author liuweibo 
 * @version $Id: GuaranteeInfo.java, v 0.1 2017年9月6日 下午2:00:22 liuweibo Exp $ 
 */
public class GuaranteeInfo {
    
    /** 行号   */
    private Integer line;
    
    /** 债权人   */
    private String creditor;
    
    /** 债务人   */
    private String debitor;
    
    /** 主债权种类   */
    private String priCalSecKind;
    
    /** 主债权数额   */
    private Double priCalSecAm;
    
    /** 履行债务的期限   */
    private String pefPerLimit;
    
    /** 保证的期间   */
    private String guarantePeriod;
    
    /** 保证的方式   */
    private String guaranteType;

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
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
        if("1".equals(priCalSecKind)) this.priCalSecKind = "合同";
        else this.priCalSecKind = "其它";
    }

    public Double getPriCalSecAm() {
        return priCalSecAm;
    }

    public void setPriCalSecAm(Double priCalSecAm) {
        this.priCalSecAm = priCalSecAm;
    }

    public String getPefPerLimit() {
        return pefPerLimit;
    }

    public void setPefPerLimit(String pefPerLimit) {
        this.pefPerLimit = pefPerLimit;
    }

    public String getGuarantePeriod() {

        return guarantePeriod;
        
    }

    public void setGuarantePeriod(String guarantePeriod) {
        if("1".equals(guarantePeriod)) this.guarantePeriod = "期限";
        if("2".equals(guarantePeriod)) this.guarantePeriod = "合同"; 
    }

    public String getGuaranteType() {
        return guaranteType;
    }

    public void setGuaranteType(String guaranteType) {
        if("1".equals(guaranteType)) this.guaranteType = "一般保证";
        if("2".equals(guaranteType)) this.guaranteType = "连带责任保证";
        if("3".equals(guaranteType)) this.guaranteType = "未约定";
    }
    
}

