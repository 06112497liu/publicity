
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

    // 公司名称
    private String companyName;
    
    
    // 注册号或信用代码
    private String regno;
    
    // 地址
    private String adress;
    
    // 电话
    private String phone;
    
    // 邮箱
    private String email;    

    // 异常种类（年报信息异常、即时信息异常）
    private String exType;
    
    // 异常信息类别
    private String exClass;
    
    // 异常项
    private String exItem;
    
    // 数据对比标准
    private String base;
    
    // 企业公示数据
    private String other;
    
    // 异常原因
    private String exReason;

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
    
    public String getExClass() {
        return exClass;
    }

    public void setExClass(String exClass) {
        this.exClass = exClass;
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
        return "ExDetailReportVo [exType=" + exType + ", companyName=" + companyName + ", regno=" + regno + ", adress=" + adress + ", phone=" + phone + ", email=" + email + ", exClass=" + exClass
               + ", exItem=" + exItem + ", exReason=" + exReason + ", base=" + base + ", other=" + other + "]";
    }      
    
}

