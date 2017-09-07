
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report;

/** 
 *  
 * @author liuweibo 
 * @version $Id: AdminLicInfo.java, v 0.1 2017年9月7日 下午4:09:58 liuweibo Exp $ 
 */
public class AdminLicInfo {
    
    /** 行政许可文件名称   */
    private String licenseNameDesc;
    
    /** 有效期至 */
    private String validityTo;

    public String getLicenseNameDesc() {
        return licenseNameDesc;
    }

    public void setLicenseNameDesc(String licenseNameDesc) {
        this.licenseNameDesc = licenseNameDesc;
    }

    public String getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(String validityTo) {
        this.validityTo = validityTo;
    }
    
}

