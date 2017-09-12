
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
 * @version $Id: BranchVo.java, v 0.1 2017年7月14日 下午3:52:40 liuweibo Exp $ 
 */
@ApiModel("年报分支机构情况返回对象")
public class BranchVo {

    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "机构名称", required = false)
    private String name;

    @ApiModelProperty(value = "分支机构注册号", required = false)
    private String regno;
    
    @ApiModelProperty(value = "分支机构社会信用代码", required = false)
    private String creditCode;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "BranchVo [serialNo=" + serialNo + ", nbxh=" + nbxh + ", name=" + name + ", regno=" + regno + ", creditCode=" + creditCode + "]";
    }

}

