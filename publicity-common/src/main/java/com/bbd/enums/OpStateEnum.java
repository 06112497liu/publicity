
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.enums; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: OpStateEnum.java, v 0.1 2017年8月16日 下午3:05:54 liuweibo Exp $ 
 */
public enum OpStateEnum {
    KAIYE(1, "开业"),
    CHOUJIAN(2, "筹建"),
    TINGYE(3, "停业"),
    XIEYE(4, "歇业"),
    QINGSUAN(5, "清算"),
    QITA(9, "其他");
    
    private int code;

    private String desc;

    OpStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

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
    
    public static String getDescByCode(int code) {
        OpStateEnum[] vals = OpStateEnum.values();
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].getCode() == code) {
                return vals[i].getDesc();
            }
        }
        return null;
    }   
    
}

