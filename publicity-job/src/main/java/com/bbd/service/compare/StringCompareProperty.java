/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare;

import com.bbd.common.Constants;
import com.bbd.util.StringUtils;

/**
 * 字符串对比
 *
 * @author tjwang
 * @version $Id: StringCompareProperty.java, v 0.1 2017/7/10 0010 17:55 tjwang Exp $
 */
public class StringCompareProperty extends CompareProperty<String> {

    protected StringCompareProperty() {

    }

    public static StringCompareProperty build(String name, Integer submodule, String base, String other) {
        StringCompareProperty p = new StringCompareProperty();
        p.setName(name);
        p.setSubmodule(submodule);
        p.setBase(base);
        p.setOther(other);
        return p;
    }
    
    public static StringCompareProperty build(String name, Integer submodule, String base, String other, String unit) {
        StringCompareProperty p = new StringCompareProperty();
        p.setName(name);
        p.setSubmodule(submodule);
        p.setBase(base);
        p.setOther(other);
        p.setUnit(unit);
        return p;
    }

    @Override
    public int compare() {
        String base = getBase();
        String other = getOther();

        if (StringUtils.isBlank(base)) {
            return Constants.EX_TYPE_NORMAL;
        }

        if (StringUtils.isBlank(other)) {
            return Constants.EX_TYPE_HIDE;
        }

        if (!other.equals(base)) {
            return Constants.EX_TYPE_NOT_IDENTICAL;
        }

        return Constants.EX_TYPE_NORMAL;
    }

}
