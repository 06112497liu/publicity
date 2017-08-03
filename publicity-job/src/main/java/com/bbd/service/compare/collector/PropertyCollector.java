/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.domain.PubCompanyInfo;
import com.bbd.service.compare.CompareProperty;

import java.util.List;

/**
 * 属性收集
 *
 * @author tjwang
 * @version $Id: PropertyCollector.java, v 0.1 2017/7/27 0027 11:18 tjwang Exp $
 */
public interface PropertyCollector {

    List<CompareProperty> getCompareProperties(PubCompanyInfo c);

}
