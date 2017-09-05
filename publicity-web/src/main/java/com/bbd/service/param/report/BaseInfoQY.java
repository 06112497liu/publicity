
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: BaseInfoQY.java, v 0.1 2017年9月4日 下午5:03:13 liuweibo Exp $ 
 */
public class BaseInfoQY extends BaseInfo {
    
    /** 注册号和信用代码   */
    private String code;
    
    /** 公司名称   */
    private String companyName;
    
    /** 地址   */
    private String addr;
    
    /** 邮政编码   */
    private String postalCode;
    
    /** 电话   */
    private String phones;
    
    /** 邮箱   */
    private String emails;
    
    /** 从业人数   */
    private Long empnum;
    
    /** 女性从业人数   */
    private Integer womenNum;
    
    /** 经营状态   */
    private String opstateDesc;
    
    /** 控股情况   */
    private String holdings;
    
    /** 是否有投资信息或购买其它公司股权   */
    private String haveInvest;
    
    /** 是否有网站网店信息   */
    private String haveWeb;
    
    /** 是否有对外提供担保信息   */
    private String haveGuarantee;
    
    /** 是否发生股权转让   */
    private String haveEqTrans;
    
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
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
    public String getOpstateDesc() {
        return opstateDesc;
    }
    public void setOpstateDesc(String opstateDesc) {
        this.opstateDesc = opstateDesc;
    }
    public String getHoldings() {
        return holdings;
    }
    public void setHoldings(String holdings) {
        this.holdings = holdings;
    }
    public String getHaveInvest() {
        return haveInvest;
    }
    public void setHaveInvest(String haveInvest) {
        this.haveInvest = haveInvest;
    }
    public String getHaveWeb() {
        return haveWeb;
    }
    public void setHaveWeb(String haveWeb) {
        this.haveWeb = haveWeb;
    }
    public String getHaveGuarantee() {
        return haveGuarantee;
    }
    public void setHaveGuarantee(String haveGuarantee) {
        this.haveGuarantee = haveGuarantee;
    }
    public String getHaveEqTrans() {
        return haveEqTrans;
    }
    public void setHaveEqTrans(String haveEqTrans) {
        this.haveEqTrans = haveEqTrans;
    }
    public String getOpActivity() {
        return opActivity;
    }
    public void setOpActivity(String opActivity) {
        this.opActivity = opActivity;
    }
    
}

