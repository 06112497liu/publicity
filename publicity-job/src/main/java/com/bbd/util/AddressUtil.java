/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 地址工具类
 *
 * @author tjwang
 * @version $Id: AddressUtil.java, v 0.1 2017/7/12 0012 12:33 tjwang Exp $
 */
public class AddressUtil {

    private static final List<String> ILLEGAL_ADDR_END = Lists.newArrayList("市", "区", "县", "乡", "镇", "村", "开发区", "园区", "路", "巷", "街道");

    /**
     * 是否为有效地址。
     * 1. 地址为空白的列为异常；
     * 2. 地址分别以市、区（市、县）、乡（镇、村、开发区/园区）、路（巷、街道）结尾的列为异常。
     * <p>
     * 公示地址异常类型
     */
    public static boolean validate(String addr) {
        if (StringUtils.isBlank(addr)) {
            return false;
        }
        for (String illegle : ILLEGAL_ADDR_END) {
            if (addr.endsWith(illegle)) {
                return false;
            }
        }
        return true;
    }

}
