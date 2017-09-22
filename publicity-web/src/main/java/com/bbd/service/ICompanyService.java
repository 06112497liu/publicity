/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import com.bbd.domain.PubCompanyInfo;

/**
 * 企业服务
 *
 * @author tjwang
 * @version $Id: ICompanyService.java, v 0.1 2017/7/12 0012 15:25 tjwang Exp $
 */
public interface ICompanyService {

    /**
     * 根据nbxh查询企业信息
     * @param nbxh
     * @return
     */
    PubCompanyInfo getByNbxh(String nbxh);

    /**
     * 获取企业总数
     *
     * @return
     */
    int getTotalCompany();

}
