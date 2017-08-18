/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 对比异常详细信息
 *
 * @author tjwang
 * @version $Id: ExDetailVo.java, v 0.1 2017/7/19 0019 13:44 tjwang Exp $
 */
@ApiModel("公示信息异常详情返回对象")
public class ExDetailVo {

    private Long id;

    @ApiModelProperty(value = "企业nbxh", required = false)
    private String nbxh;

    @ApiModelProperty(value = "对比属性名称", required = false)
    private String propName;

    @ApiModelProperty(value = "对比属性名称描述", required = false)
    private String propNameDesc;

    @ApiModelProperty(value = "所属模块", required = false)
    private Integer submodule;

    @ApiModelProperty(value = "异常原因（1. 隐瞒未报；2. 登记不一致；4. 格式错误）", required = false)
    private Integer exType;

    @ApiModelProperty(value = "对比时间", required = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date compareTime;

    @ApiModelProperty(value = "对比标准", required = false)
    private String base;

    @ApiModelProperty(value = "年报数据", required = false)
    private String other;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNbxh() {
        return nbxh;
    }

    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropNameDesc() {
        return propNameDesc;
    }

    public void setPropNameDesc(String propNameDesc) {
        this.propNameDesc = propNameDesc;
    }

    public Integer getSubmodule() {
        return submodule;
    }

    public void setSubmodule(Integer submodule) {
        this.submodule = submodule;
    }

    public Integer getExType() {
        return exType;
    }

    public void setExType(Integer exType) {
        this.exType = exType;
    }

    public Date getCompareTime() {
        return compareTime;
    }

    public void setCompareTime(Date compareTime) {
        this.compareTime = compareTime;
    }

    public String getBase() {
        if("null".equals(base)) {
            return "无数据";
        }
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getOther() {
        if("null".equals(other)) {
            return "无数据";
        }
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
