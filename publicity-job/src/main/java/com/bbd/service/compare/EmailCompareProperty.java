/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare;

import com.bbd.common.Constants;
import com.bbd.util.StringUtils;

/**
 * 不对比，判空和校验格式
 *
 * @author tjwang
 * @version $Id: EmailCompareProperty.java, v 0.1 2017/7/13 0013 17:22 tjwang Exp $
 */
public class EmailCompareProperty extends StringCompareProperty {

    private EmailCompareProperty() {

    }

    public static EmailCompareProperty build(String name, Integer submodule, String other) {
        EmailCompareProperty p = new EmailCompareProperty();
        p.setName(name);
        p.setSubmodule(submodule);
        p.setOther(other);
        return p;
    }

    @Override
    public int compare() {
        int r = super.compare();
        if (r != 0) {
            return r;
        }

        String email = getOther();
        if (!StringUtils.hasEmail(email)) {
            return Constants.EX_TYPE_INVALID_FORMAT;
        }
        return Constants.EX_TYPE_NORMAL;
    }

}
