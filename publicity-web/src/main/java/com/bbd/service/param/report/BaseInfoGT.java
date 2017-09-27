
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: BaseInfoGT.java, v 0.1 2017年9月5日 上午9:36:46 liuweibo Exp $ 
 */
public class BaseInfoGT extends BaseInfo {
    
    /** 公司名称   */
    private String companyName;
    
    /** 经营者姓名   */
    private String opName;
    
    /** 注册号和信用代码   */
    private String code;
    
    /** 电话   */
    private String phones;
    
    /** 资金数额   */
    private Double amountMon;
    
    /** 从业人数   */
    private String empnum;
    
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getOpName() {
        return opName;
    }
    public void setOpName(String opName) {
        this.opName = opName;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getPhones() {
        return phones;
    }
    public void setPhones(String phones) {
        this.phones = phones;
    }
    public Double getAmountMon() {
        return amountMon;
    }
    public void setAmountMon(Double amountMon) {
        this.amountMon = amountMon;
    }

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum;
    }
}

