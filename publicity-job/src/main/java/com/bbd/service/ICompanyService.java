/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

import com.bbd.domain.PubCompanyInfo;
import com.google.common.base.Optional;

import java.util.List;

/**
 * 企业服务
 *
 * @author tjwang
 * @version $Id: ICompanyService.java, v 0.1 2017/7/12 0012 15:25 tjwang Exp $
 */
public interface ICompanyService {

    Optional<PubCompanyInfo> queryByNbxh(String nbxh);

    /**
     * 通过NBXH排序，获取指定NBXH的后一些企业信息
     *
     * @param nbxh
     * @return
     */
    List<PubCompanyInfo> getNextCompanys(String nbxh);

}
