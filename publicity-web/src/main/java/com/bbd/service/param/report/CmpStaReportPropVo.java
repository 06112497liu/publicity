
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 * 比对统计分析报告对象
 * @author liuweibo 
 * @version $Id: CmpStaReportVo.java, v 0.1 2017年8月25日 下午1:55:14 liuweibo Exp $ 
 */
public class CmpStaReportPropVo {
    
    private String item;
    
    private Number num;
    
    private Double per;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Number getNum() {
        return num;
    }

    public void setNum(Number num) {
        this.num = num;
    }

    public Double getPer() {
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }

    @Override
    public String toString() {
        return "CmpStaReportPropVo [item=" + item + ", num=" + num + ", per=" + per + "]";
    }
    
}

