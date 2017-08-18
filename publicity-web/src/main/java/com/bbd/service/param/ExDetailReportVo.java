
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param; 
/** 
 * 企业比对信息详情对象
 * @author liuweibo 
 * @version $Id: ExDetailReportVo.java, v 0.1 2017年8月17日 下午4:33:18 liuweibo Exp $ 
 */
public class ExDetailReportVo {

    private String exType;
    
    private String companyName;
    
    private String regno;
    
    private String adress;
    
    private String phone;
    
    private String email;
    
    private String exItem;
    
    private String exReason;
    
    private String base;
    
    private String other;

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExItem() {
        return exItem;
    }

    public void setExItem(String exItem) {
        this.exItem = exItem;
    }

    public String getExReason() {
        return exReason;
    }

    public void setExReason(String exReason) {
        this.exReason = exReason;
    }    
    
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "ExDetailReportVo [exType=" + exType + ", companyName=" + companyName + ", regno=" + regno + ", adress=" + adress + ", phone=" + phone + ", email=" + email + ", exItem=" + exItem
               + ", exReason=" + exReason + ", other=" + other + "]";
    }      
    
}

