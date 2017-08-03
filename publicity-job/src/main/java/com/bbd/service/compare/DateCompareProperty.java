/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare;

import com.bbd.common.Constants;

import java.util.Date;

/**
 * @author tjwang
 * @version $Id: DateCompareProperty.java, v 0.1 2017/7/14 0014 14:13 tjwang Exp $
 */
public class DateCompareProperty extends CompareProperty<Date> {

    protected DateCompareProperty() {

    }

    public static DateCompareProperty build(String name, Integer submodule, Date base, Date other) {
        DateCompareProperty p = new DateCompareProperty();
        p.setName(name);
        p.setSubmodule(submodule);
        p.setBase(base);
        p.setOther(other);
        return p;
    }

    @Override
    public int compare() {
        Date base = getBase();
        Date other = getOther();

        if (base == null) {
            return Constants.EX_TYPE_NORMAL;
        }

        if (other == null) {
            return Constants.EX_TYPE_HIDE;
        }

        if (!base.equals(other)) {
            return Constants.EX_TYPE_NOT_IDENTICAL;
        }
        return Constants.EX_TYPE_NORMAL;
    }
}
