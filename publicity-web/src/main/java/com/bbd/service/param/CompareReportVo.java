/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tjwang
 * @version $Id: CompareReportVo.java, v 0.1 2017/7/19 0019 16:35 tjwang Exp $
 */
@ApiModel("对比统计分析返回对象")
public class CompareReportVo {

    @ApiModelProperty(value = "编码", required = false)
    private String item;

    @ApiModelProperty(value = "编码描述", required = false)
    private String itemDesc;

    @ApiModelProperty(value = "年报异常企业数量", required = false)
    private int    annualNum;
    
    @ApiModelProperty(value = "年报异常企业数量占比", required = false)
    private String annualPer;

    @ApiModelProperty(value = "即时信息异常企业数量", required = false)
    private int    insNum;
    
    @ApiModelProperty(value = "即时信息异常企业数量占比", required = false)
    private String insPer;
    
    @ApiModelProperty(value = "两者都有的异常企业数量", required = false)
    private int    bothNum;
    
    @ApiModelProperty(value = "两者都有的异常企业数量占比", required = false)
    private String bothPer;

    @ApiModelProperty(value = "异常总量", required = false)
    private int    total;

    @ApiModelProperty(value = "占比排名", required = false)
    private String percent;

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getAnnualNum() {
        return annualNum;
    }

    public void setAnnualNum(int annualNum) {
        this.annualNum = annualNum;
    }

    public int getInsNum() {
        return insNum;
    }

    public void setInsNum(int insNum) {
        this.insNum = insNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public String getAnnualPer() {
        return annualPer;
    }

    public void setAnnualPer(String annualPer) {
        this.annualPer = annualPer;
    }

    public String getInsPer() {
        return insPer;
    }

    public void setInsPer(String insPer) {
        this.insPer = insPer;
    }

    public int getBothNum() {
        return bothNum;
    }

    public void setBothNum(int bothNum) {
        this.bothNum = bothNum;
    }

    public String getBothPer() {
        return bothPer;
    }

    public void setBothPer(String bothPer) {
        this.bothPer = bothPer;
    }

    @Override
    public String toString() {
        return "CompareReportVo [item=" + item + ", itemDesc=" + itemDesc + ", annualNum=" + annualNum + ", annualPer=" + annualPer + ", insNum=" + insNum + ", insPer=" + insPer + ", bothNum="
               + bothNum + ", bothPer=" + bothPer + ", total=" + total + ", percent=" + percent + "]";
    }

}
