
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.enums;

/** 
 *  
 * @author liuweibo 
 * @version $Id: InvestWayEnum.java, v 0.1 2017年8月15日 下午7:03:15 liuweibo Exp $ 
 */
public enum InvestWayEnum {
    
    CURRENCY(1, "货币"),
    PHYSICAL(2, "实物"),
    INTELLECTUAL_PROPERTY(3, "知识产权"),
    CREDITOR_RIGHTS(4, "债权"),
    HIGH_TECH_ACHIEVEMENTS(5, "高新技术成果"),
    LAND_USE_RIGHT(6, "土地使用权"),
    EQUITY(7, "股权"),
    LABOR(8, "劳务"),
    OTHERS(9, "其他");
    
    private int code;

    private String desc;
    
    InvestWayEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    public static String getDescByCode(int code) {
        InvestWayEnum[] vals = InvestWayEnum.values();
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].getCode() == code) {
                return vals[i].getDesc();
            }
        }
        return "--";
    }
    
    public void setCode(int code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
    
    public String getDesc() {
        return desc;
    }
}

