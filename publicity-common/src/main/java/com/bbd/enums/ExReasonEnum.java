
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.enums; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: ExReasonEnum.java, v 0.1 2017年8月18日 下午3:11:31 liuweibo Exp $ 
 */
public enum ExReasonEnum {
    WU(0, "无"),
    YMWB(1, "隐瞒未报"),
    DJBYZ(2, "登记不一致"),
    GSCW(4, "格式错误");
    
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
    
    public static String getDescByCode(int code) {
        ExReasonEnum[] vals = ExReasonEnum.values();
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].getCode() == code) {
                return vals[i].getDesc();
            }
        }
        return null;
    } 

    /**
     * @param code
     * @param desc 
     */
    private ExReasonEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }   
    
    
}

