/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.param;

import com.bbd.common.util.PercentUtil;
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

    @ApiModelProperty(value = "年报信息异常数量占比", required = false)
    private String annualPer;

    @ApiModelProperty(value = "即时信息异常企业数量", required = false)
    private int    insNum;

    @ApiModelProperty(value = "即时信息异常数量占比", required = false)
    private String insPer;

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

    public String getAnnualPer() {
        String str = PercentUtil.calcIntPercent(insNum + annualNum, annualNum);
        return str;
    }

    public String getInsPer() {
        String str = PercentUtil.calcIntPercent(insNum + annualNum, insNum);
        return str;
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

    @Override
    public String toString() {
        return "CompareReportVo [item=" + item + ", itemDesc=" + itemDesc + ", annualNum=" + annualNum + ", insNum=" + insNum + ", total=" + total + "]";
    }

}
