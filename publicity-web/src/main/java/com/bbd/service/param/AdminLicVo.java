
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 *  
 * @author liuweibo 
 * @version $Id: AdminLicVo.java, v 0.1 2017年7月14日 下午3:36:45 liuweibo Exp $ 
 */
@ApiModel("年报行政许可信息返回对象")
public class AdminLicVo {
    
    @ApiModelProperty(value = "年报流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "许可文件名称", required = false)
    private String licenseName;
    
    @ApiModelProperty(value = "许可文件名称描述", required = false)
    private String licenseNameDesc;

    @ApiModelProperty(value = "有效期至", required = false)
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date validityTo;

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

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }    

    public String getLicenseNameDesc() {
        return licenseNameDesc;
    }

    public void setLicenseNameDesc(String licenseNameDesc) {
        this.licenseNameDesc = licenseNameDesc;
    }

    public Date getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(Date validityTo) {
        this.validityTo = validityTo;
    }

    @Override
    public String toString() {
        return "AdminLicVo [serialNo=" + serialNo + ", nbxh=" + nbxh + ", licenseName=" + licenseName + ", validityTo=" + validityTo + "]";
    }    
    
}

