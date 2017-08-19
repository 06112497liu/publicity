/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare;

import com.bbd.common.Constants;

/**
 * 数字对比
 *
 * @author tjwang
 * @version $Id: NumberCompareProperty.java, v 0.1 2017/7/10 0010 18:10 tjwang Exp $
 */
public class NumberCompareProperty extends CompareProperty<Number> {

    protected NumberCompareProperty() {
    }

    public static NumberCompareProperty build(String name, Integer submodule, Number base, Number other) {
        NumberCompareProperty property = new NumberCompareProperty();
        property.setName(name);
        property.setSubmodule(submodule);
        property.setBase(base);
        property.setOther(other);
        return property;
    }
    
    public static NumberCompareProperty build(String name, Integer submodule, Number base, Number other, String unit) {
        NumberCompareProperty property = new NumberCompareProperty();
        property.setName(name);
        property.setSubmodule(submodule);
        property.setBase(base);
        property.setOther(other);
        property.setUnit(unit);
        return property;
    }


    @Override
    public int compare() {
        Number base = getBase();
        Number other = getOther();

        if (base == null) {
            return Constants.EX_TYPE_NORMAL;
        }

        if (other == null) {
            return Constants.EX_TYPE_HIDE;
        }
        if (!other.equals(base)) {
            return Constants.EX_TYPE_NOT_IDENTICAL;
        }

        return Constants.EX_TYPE_NORMAL;
    }

}
