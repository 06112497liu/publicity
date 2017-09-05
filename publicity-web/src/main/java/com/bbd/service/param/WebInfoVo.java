
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
 * @version $Id: WebInfoVo.java, v 0.1 2017年7月14日 上午11:23:27 liuweibo Exp $ 
 */
@ApiModel("年报网站、网店信息返回对象")
public class WebInfoVo {
    
    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "流水号", required = false)
    private String serialNo;

    @ApiModelProperty(value = "网店名称", required = false)
    private String name;

    @ApiModelProperty(value = "网店类型（1.网站、2.网店）", required = false)
    private String type;

    @ApiModelProperty(value = "网址", required = false)
    private String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if("1".equals(type)) this.type = "网站";
        else this.type = "网店";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WebInfoVo [nbxh=" + nbxh + ", serialNo=" + serialNo + ", name=" + name + ", type=" + type + ", url=" + url + "]";
    }
}

