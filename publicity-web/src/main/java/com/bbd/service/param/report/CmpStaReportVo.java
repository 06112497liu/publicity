
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
public class CmpStaReportVo {
    
    // 名称
    private String item;
    
    // 值
    private Number itemvalue;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Number getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(Number itemvalue) {
        this.itemvalue = itemvalue;
    }

    @Override
    public String toString() {
        return "CmpStaReportVo [item=" + item + ", itemvalue=" + itemvalue + "]";
    }
    
    
}

