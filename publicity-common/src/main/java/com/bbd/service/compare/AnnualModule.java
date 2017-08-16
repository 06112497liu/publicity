package com.bbd.service.compare;

/**
 * @author tjwang
 * @version $Id: AnnualModule.java, v 0.1 2017/7/11 0011 14:50 tjwang Exp $
 */
public enum AnnualModule {
    BASE(1, "基本信息"),
    STOCKHOLDER(2, "股东及出资信息"),
    OUT_INVEST(4, "对外投资信息"),
    EXT_PROV(8, "对外提供保证担保信息"),
    BRANCH(16, "分支机构信息");
/*    WEB(32, "网站或网店信息"),
    ASSET_STATUS(64, "资产状况信息"),
    EQUITY_CHANGE(128, "股权变更信息"),
    SOCIAL_SECURITY(256, "社保信息"),;*/

    private int code;

    private String desc;

    AnnualModule(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
    
    public String getDesc() {
        return desc;
    }
}
