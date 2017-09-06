
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: OutInvesInfoVo.java, v 0.1 2017年7月14日 下午2:02:42 liuweibo Exp $ 
 */
@ApiModel("年报对外投资信息返回对象")
public class OutInvesInfoVo {
    
    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "投资公司名称", required = false)
    private String companyName;

    @ApiModelProperty(value = "投资公司注册号", required = false)
    private String regno;
    
    @ApiModelProperty(value = "投资公司社会信用代码", required = false)
    private String creditCode;

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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
    
    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    @Override
    public String toString() {
        return "OutInvesInfoVo [nbxh=" + nbxh + ", serialNo=" + serialNo + ", companyName=" + companyName + ", regno=" + regno + "]";
    }
    
    
}

