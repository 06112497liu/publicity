package com.bbd.service.compare;

/**
 * @author tjwang
 * @version $Id: PropertyEnum.java, v 0.1 2017/8/2 0002 11:24 tjwang Exp $
 */
public enum PropertyEnum {

    ANNUAL_REGNO("an_regno", "注册号"),
    ANNUAL_COMPANY_NAME("an_company_name", "企业名称"),
    ANNUAL_ADDR("an_addr", "地址"),
    ANNUAL_POSTAL_CODE("an_postal_code", "邮政编码"),
    ANNUAL_PHONES("an_phones", "联系电话"),
    ANNUAL_EMAILS("an_emails", "邮箱地址"),
    ANNUAL_EMPNO("an_empno", "从业人数"),
    ANNUAL_OPSTATE("an_opstate", "企业经营状态"),
    ANNUAL_OP_NAME("an_op_name", "经营者名称"),
    ANNUAL_AMOUNT_MON("an_amount_mon", "资金数额"),
    ANNUAL_OP_ACTIVITY("an_op_activity", "主营业务活动"),

    ANNUAL_STOCKHOLDER("an_stockholder", "股东名称"),
    ANNUAL_SUB_CRON_CAP("an_sub_cron_cap", "认缴出资额"),
    ANNUAL_SUB_CRON_DATE("an_sub_cron_date", "认缴出资时间"),
    ANNUAL_SUB_CRON_FROM("an_sub_cron_from", "认缴出资方式"),
    ANNUAL_AC_CRON_CAP("an_ac_cron_cap", "实缴出资额"),
    ANNUAL_AC_CRON_FROM("an_ac_cron_from", "实缴出资方式"),

    ANNUAL_INV_COMPANY_NAME("an_inv_company_name", "投资公司名称"),
    ANNUAL_INV_REGNO("an_inv_regno", "投资公司注册号"),

    ANNUAL_EXT_PROV_CREDITOR("an_ext_prov_creditor", "债权人"),
    ANNUAL_EXT_PROV_DEBITOR("an_ext_prov_debitor", "债务人"),
    ANNUAL_EXT_PROV_PRI_CAL_SEC_KIND("an_ext_prov_pri_cal_sec_kind", "主债权种类"),
    ANNUAL_EXT_PROV_PRI_CAL_SEC_AM("an_ext_prov_pri_cal_sec_am", "主债权数额"),
    ANNUAL_EXT_PROV_PEF_PER_FROM("an_ext_prov_pef_per_from", "履行债务的期限自"),
    ANNUAL_EXT_PROV_PEF_PER_TO("an_ext_prov_pef_pre_to", "履行债务的期限至"),

    ANNUAL_BRANCH_NAME("an_branch_name", "分支机构名称"),
    ANNUAL_BRANCH_REGNO("an_branch_regno", "分支机构注册号"),

    INS_STOCK_HOLDER("ins_stockholder", "股东名称"),
    INS_SUB_CRON_CAP("ins_sub_cron_cap", "认缴出资额"),
    INS_SUB_CRON_DATE("ins_sub_cron_date", "认缴出资时间"),
    INS_SUB_CRON_FROM("ins_sub_cron_from", "认缴出资方式"),
    INS_AC_CRON_CAP("ins_ac_cron_cap", "实缴出资额"),
    INS_AC_CRON_FROM("ins_ac_cron_from", "实缴出资方式"),;

    private String code;

    private String name;

    PropertyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code) {
        PropertyEnum[] vals = PropertyEnum.values();
        for (int i = 0; i < vals.length; i++) {
            if (vals[i].getCode().equals(code)) {
                return vals[i].getName();
            }
        }
        return "未知";
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
