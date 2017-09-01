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
 * @version $Id: PostalCodeCompareProperty.java, v 0.1 2017/7/13 0013 17:24 tjwang Exp $
 */
public class PostalCodeCompareProperty extends StringCompareProperty {

    private PostalCodeCompareProperty() {

    }

    public static PostalCodeCompareProperty build(String name, Integer submodule, String other) {
        PostalCodeCompareProperty p = new PostalCodeCompareProperty();
        p.setName(name);
        p.setSubmodule(submodule);
        p.setOther(other);
        return p;
    }

    public static PostalCodeCompareProperty build(String name, Integer submodule, String other, String unit) {
        PostalCodeCompareProperty p = new PostalCodeCompareProperty();
        p.setName(name);
        p.setSubmodule(submodule);
        p.setOther(other);
        p.setUnit(unit);
        return p;
    }
    
    @Override
    public int compare() {
        String base = getBase();
        String other = getOther();
        
        if(StringUtils.isBlank(base)) {
            return Constants.EX_TYPE_NORMAL;
        }
        if(StringUtils.isBlank(other)) {
            return Constants.EX_TYPE_HIDE;
        }
        if (!StringUtils.isPostalCode(other)) {
            return Constants.EX_TYPE_INVALID_FORMAT;
        }
        return Constants.EX_TYPE_NORMAL;
    }

}
