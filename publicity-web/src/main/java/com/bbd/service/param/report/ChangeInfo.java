
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report;

import java.util.Date;

/** 
 *  
 * @author liuweibo 
 * @version $Id: ChangeInfo.java, v 0.1 2017年9月7日 下午3:22:54 liuweibo Exp $ 
 */
public class ChangeInfo {
    
    /** 行号   */
    private Integer line;
    
    /** 股东   */
    private String shareholder;
    
    /** 变更前股权比例   */
    private String preEquityRatio;
    
    /** 变更后股权比例   */
    private String aftEquityRatio;
    
    /** 变更日期   */
    private String changeDate;

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

    public String getPreEquityRatio() {
        return preEquityRatio;
    }

    public void setPreEquityRatio(String preEquityRatio) {
        this.preEquityRatio = preEquityRatio;
    }

    public String getAftEquityRatio() {
        return aftEquityRatio;
    }

    public void setAftEquityRatio(String aftEquityRatio) {
        this.aftEquityRatio = aftEquityRatio;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
    
}

