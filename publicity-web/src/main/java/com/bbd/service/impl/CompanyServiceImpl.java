/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.domain.PubCompanyInfoExample;
import com.bbd.service.ICompanyService;
import com.bbd.util.StringUtils;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 企业服务实现
 *
 * @author tjwang
 * @version $Id: CompanyServiceImpl.java, v 0.1 2017/7/12 0012 15:29 tjwang Exp $
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private PubCompanyInfoDao pubCompanyInfoDao;

    @Override
    public PubCompanyInfo getByNbxh(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "内部序号不能为空");

        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);

        List<PubCompanyInfo> ds = pubCompanyInfoDao.selectByExample(exam);
        if (ds.size() == 0) {
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR, "找不到NBXH为" + nbxh + "的企业");
        }

        return ds.get(0);
    }

    @Override
    public int getTotalCompany() {
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        Long count = pubCompanyInfoDao.countByExample(exam);
        return count.intValue();
    }
}
