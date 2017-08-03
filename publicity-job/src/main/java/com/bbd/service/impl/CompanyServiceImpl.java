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
import com.google.common.base.Optional;
import com.mybatis.domain.PageBounds;
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
    public Optional<PubCompanyInfo> queryByNbxh(String nbxh) {
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);

        List<PubCompanyInfo> ds = pubCompanyInfoDao.selectByExample(exam);
        if (ds.size() == 0) {
            return Optional.absent();
        }
        return Optional.of(ds.get(0));
    }

    @Override
    public List<PubCompanyInfo> getNextCompanys(String nbxh) {
        PubCompanyInfoExample exam = new PubCompanyInfoExample();

        if (StringUtils.isBlank(nbxh)) {
            exam.createCriteria();
        } else {
            exam.createCriteria().andNbxhGreaterThan(nbxh);
        }
        exam.setOrderByClause("nbxh asc");

        PageBounds pb = new PageBounds(1, 50, false);

        return pubCompanyInfoDao.selectByExampleWithPageBounds(exam, pb);
    }

}
