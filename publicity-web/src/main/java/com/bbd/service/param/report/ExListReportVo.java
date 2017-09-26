package com.bbd.service.param.report;

/**
 * @author Liuweibo
 * @version Id: ExListReportVo.java, v0.1 2017/9/26 Liuweibo Exp $$
 */
public class ExListReportVo {
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

    // 异常项数量
    private int num;

    // 异常信息类别
    private String exClass;

    public ExListReportVo() {}

    public ExListReportVo(String companyName, String regno, String adress, String phone, String email) {
        this.companyName = companyName;
        this.regno = regno;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
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

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getExClass() {
        return exClass;
    }

    public void setExClass(String exClass) {
        this.exClass = exClass;
    }

    @Override
    public String toString() {
        return "ExListReportVo{" +
                "companyName='" + companyName + '\'' +
                ", regno='" + regno + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", exType='" + exType + '\'' +
                ", exClass='" + exClass + '\'' +
                '}';
    }
}
    
    