package com.bbd.enums;

import com.google.common.base.Objects;

/**
 * @author liuweibo
 * @version $Id: DistrictEnum.java, v0.1 ${DATA} 17:42 liuweibo Exp $$
 */
public enum DistrictEnum {
    
    WHOLE_CITY("5201", "wholeCity"),
    ZHIGUAN("520100", "zhiGuan"),
    NAMING("520102", "nanMing"),
    YUNYAN("520103", "yunYan"),
    HUAXI("520111", "huaXi"),
    WUDANG("520112", "wuDang"),
    BAIYUN("520113", "baiYun"),
    JINGJI("520114", "jingJi"),
    GUANSHANHU("520115", "guanShanHu"),
    KAIYANG("520121", "kaiYang"),
    XIFENG("520122", "xiFeng"),
    XIUWEN("520123", "xiuWen"),
    QINGZHEN("520181", "qingZhen"),
    HANGKONGGANG("520191", "hangKongGang"),
    BAOSHUI("520192", "baoShui"),
    GAOXIN("520198", "gaoXin"),
    QITA("52019999", "qiTa"),;
    
    private String code;
    
    private String desc;
    
    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    
    public static String getDescByCode(String code) {
        DistrictEnum[] vals = DistrictEnum.values();
        for (int i = 0; i < vals.length; i++) {
            if(Objects.equal(vals[i].getCode(), code)) {
                return vals[i].getDesc();
            }
        }
        return null;
    }
    
    public static String getCodeByDesc(String desc) {
        DistrictEnum[] vals = DistrictEnum.values();
        for (int i = 0; i < vals.length; i++) {
            if(Objects.equal(vals[i].getDesc(), desc)) {
                return vals[i].getCode();
            }
        }
        return null;
    }
    
    /**
     * @param code
     * @param desc 
     */
    private DistrictEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    
}
