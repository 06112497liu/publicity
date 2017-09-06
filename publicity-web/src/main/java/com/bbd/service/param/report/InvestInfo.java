
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: InvestInfo.java, v 0.1 2017年9月6日 上午9:31:52 liuweibo Exp $ 
 */
public class InvestInfo {
    
    /** 行号   */
    private Integer line;
    
    /** 投资公司名称   */
    private String companyName;
    
    /** 注册号和信用代码   */
    private String code;

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

