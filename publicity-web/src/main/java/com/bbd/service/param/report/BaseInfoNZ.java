
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: BaseInfoNZ.java, v 0.1 2017年9月5日 上午9:48:24 liuweibo Exp $ 
 */
public class BaseInfoNZ extends BaseInfo {
    
    /** 注册号和信用代码   */
    private String code;
    
    /** 公司名称   */
    private String companyName;
    
    /** 电话   */
    private String phones;
    
    /** 邮箱   */
    private String emails;
    
    /** 成员人数   */
    private Long memnum;
    
    /** 控股情况   */
    private String holdings;
    
    /** 从业人数   */
    private Long empnum;
    
    /** 女性从业人数   */
    private Integer womenNum;
    
    /** 地址   */
    private String addr;
    
    /** 企业主营业务活动   */
    private String opActivity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public Long getMemnum() {
        return memnum;
    }

    public void setMemnum(Long memnum) {
        this.memnum = memnum;
    }

    public String getHoldings() {
        return holdings;
    }

    public void setHoldings(String holdings) {
        this.holdings = holdings;
    }

    public Long getEmpnum() {
        return empnum;
    }

    public void setEmpnum(Long empnum) {
        this.empnum = empnum;
    }

    public Integer getWomenNum() {
        return womenNum;
    }

    public void setWomenNum(Integer womenNum) {
        this.womenNum = womenNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOpActivity() {
        return opActivity;
    }

    public void setOpActivity(String opActivity) {
        this.opActivity = opActivity;
    }
    
}

