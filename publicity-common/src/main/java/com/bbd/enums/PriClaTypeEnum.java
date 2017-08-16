
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.enums; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: PriClaTypeEnum.java, v 0.1 2017年8月16日 下午4:33:50 liuweibo Exp $ 
 */
public enum PriClaTypeEnum {
    
    HETONG(1, "合同"),
    QITA(2, "其他");
    
    private int code;

    private String desc;    
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    PriClaTypeEnum(int code, String desc) {
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
        return null;
    }   
    
}

