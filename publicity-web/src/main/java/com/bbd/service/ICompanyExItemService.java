/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import com.bbd.domain.CompanyExItem;

/**
 * @author tjwang
 * @version $Id: ICompanyExItemService.java, v 0.1 2017/7/18 0018 17:52 tjwang Exp $
 */
public interface ICompanyExItemService {

    CompanyExItem getByNbxh(String nbxh);

}
