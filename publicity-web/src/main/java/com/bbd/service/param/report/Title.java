
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: Title.java, v 0.1 2017年9月4日 下午3:56:05 liuweibo Exp $ 
 */
public class Title {
    public static final Object[] nameValueTitle = new Object[]{"item", "itemValue"};
    public static final Object[] nameValuePerTitle = new Object[]{"item", "num", "per"};
    public static final Object[] baseInfoTitle = 
            new Object[]{"code", "companyName", "addr", "postalCode", "phones", "emails", "empnum", "womenNum", "opstateDesc", 
                         "holdings", "haveInvest", "haveWeb", "haveGuarantee", "haveEqTrans", "opActivity"};
    public static final Object[] webInfoTitle = new Object[]{"line", "name", "type", "url"};
    public static final Object[] stockholderInfoTitle = 
            new Object[]{"line", "stockholder", "subCronCap", "subCronDate", "subCronFromDesc", "acCronCap", "acCronDate", "acCronFromDesc"};
    public static final Object[] investInfoTitle = new Object[]{"line", "companyName", "regno"};
    public static final Object[] assetsInfoTitle = 
            new Object[]{"assTotal", "ownEquity", "grossRevenue", "proTotal", "mainGrossRevenue", "proNet", "taxTotal", "liabTotal"};
    
    
    
    
}

