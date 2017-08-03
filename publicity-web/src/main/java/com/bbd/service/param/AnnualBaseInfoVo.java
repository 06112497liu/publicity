
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: AnnualBaseInfoResp.java, v 0.1 2017年7月13日 下午6:19:14 liuweibo Exp $ 
 */
@ApiModel("年报基本信息返回对象")
public class AnnualBaseInfoVo {
    
    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;
    
    @ApiModelProperty(value = "注册号", required = false)
    private String regno;
    
    @ApiModelProperty(value = "流水号", required = false)
    private String serialNo;
    
    @ApiModelProperty(value = "法人代表", required = false)
    private String legalPerson;
    
    @ApiModelProperty(value = "年报时间", required = false)
    @JsonFormat(pattern = "yyyy年MM月", timezone = "GMT+8")
    private Date annualDate;

    @ApiModelProperty(value = "年报年度", required = false)
    private String annualYear;
    
    @ApiModelProperty(value = "企业名称", required = false)
    private String companyName;
    
    @ApiModelProperty(value = "企业性质（1.企业；2.个体；3.农专社）", required = false)
    private Integer companyProperty;
    
    @ApiModelProperty(value = "地址", required = false)
    private String addr;
    
    @ApiModelProperty(value = "邮政编码", required = false)
    private String postalCode;
    
    @ApiModelProperty(value = "电话", required = false)
    private String phones;
    
    @ApiModelProperty(value = "邮箱", required = false)
    private String emails;
    
    @ApiModelProperty(value = "从业人数", required = false)
    private Long empnum;
    
    @ApiModelProperty(value = "成员人数", required = false)
    private Long memnum;
    
    @ApiModelProperty(value = "女性从业人数", required = false)
    private Integer womenNum;
    
    @ApiModelProperty(value = "经营状态", required = false)
    private String opstate;
    
    @ApiModelProperty(value = "经营者姓名", required = false)
    private String opName;
    
    @ApiModelProperty(value = "资金数额", required = false)
    private Double amountMon;
    
    @ApiModelProperty(value = "控股情况", required = false)
    private String holdings;
    
    @ApiModelProperty(value = "是否有投资信息或购买其它公司股权（false ：否， true ：是 ）", required = false)
    private boolean haveInvest;
    
    @ApiModelProperty(value = "是否有网站或网店", required = false)
    private boolean haveWeb;
    
    @ApiModelProperty(value = "是否有对外提供担保信息", required = false)
    private boolean haveGuarantee;
    
    @ApiModelProperty(value = "是否发生股权转让", required = false)
    private boolean haveEqTrans;
    
    @ApiModelProperty(value = "企业主营业务活动", required = false)
    private String opActivity;
    
    @ApiModelProperty(value = "当期年报状态（1.当期已公示，2.当期未公示）", required = false)
    private Integer annualState;    
    
    public Integer getAnnualState() {
        LocalDate date = LocalDate.now();
        String currentYear = String.valueOf(date.getYear());
        if(currentYear.equals(currentYear)) {
            return 1;
        }
        return 2;
    }    
    
    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public void setAnnualState(Integer annualState) {
        this.annualState = annualState;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(Date annualDate) {
        this.annualDate = annualDate;
    }

    public String getAnnualYear() {
        return annualYear;
    }

    public Integer getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(Integer companyProperty) {
        this.companyProperty = companyProperty;
    }

    public void setAnnualYear(String annualYear) {
        this.annualYear = annualYear;
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

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Double getAmountMon() {
        return amountMon;
    }

    public void setAmountMon(Double amountMon) {
        this.amountMon = amountMon;
    }

    public void setEmpnum(Long empnum) {
        this.empnum = empnum;
    }    
    
    public Long getMemnum() {
        return memnum;
    }

    public void setMemnum(Long memnum) {
        this.memnum = memnum;
    }

    public boolean isHaveInvest() {
        return haveInvest;
    }

    public void setHaveInvest(boolean haveInvest) {
        this.haveInvest = haveInvest;
    }

    public boolean isHaveWeb() {
        return haveWeb;
    }

    public void setHaveWeb(boolean haveWeb) {
        this.haveWeb = haveWeb;
    }

    public boolean isHaveGuarantee() {
        return haveGuarantee;
    }

    public void setHaveGuarantee(boolean haveGuarantee) {
        this.haveGuarantee = haveGuarantee;
    }

    public boolean isHaveEqTrans() {
        return haveEqTrans;
    }

    public void setHaveEqTrans(boolean haveEqTrans) {
        this.haveEqTrans = haveEqTrans;
    }

    public Integer getWomenNum() {
        return womenNum;
    }

    public void setWomenNum(Integer womenNum) {
        this.womenNum = womenNum;
    }

    public String getOpstate() {
        return opstate;
    }

    public void setOpstate(String opstate) {
        this.opstate = opstate;
    }

    public String getHoldings() {
        return holdings;
    }

    public void setHoldings(String holdings) {
        this.holdings = holdings;
    }
    
    

    public String getOpActivity() {
        return opActivity;
    }

    public void setOpActivity(String opActivity) {
        this.opActivity = opActivity;
    }

    @Override
    public String toString() {
        return "AnnualBaseInfoVo [nbxh=" + nbxh + ", regno=" + regno + ", serialNo=" + serialNo + ", legalPerson=" + legalPerson + ", annualDate=" + annualDate + ", annualYear=" + annualYear
               + ", companyName=" + companyName + ", companyProperty=" + companyProperty + ", addr=" + addr + ", postalCode=" + postalCode + ", phones=" + phones + ", emails=" + emails + ", empnum="
               + empnum + ", womenNum=" + womenNum + ", opstate=" + opstate + ", opName=" + opName + ", amountMon=" + amountMon + ", holdings=" + holdings + ", haveInvest=" + haveInvest + ", haveWeb="
               + haveWeb + ", haveGuarantee=" + haveGuarantee + ", haveEqTrans=" + haveEqTrans + ", opActivity=" + opActivity + ", annualState=" + annualState + "]";
    }
    
}

