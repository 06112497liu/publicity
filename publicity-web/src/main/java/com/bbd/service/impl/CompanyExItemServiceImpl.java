/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.CompanyExItemDao;
import com.bbd.domain.CompanyExItem;
import com.bbd.domain.CompanyExItemExample;
import com.bbd.service.ICompanyExItemService;
import com.bbd.util.StringUtils;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.google.common.base.Preconditions;
import com.mybatis.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tjwang
 * @version $Id: CompanyExItemServiceImpl.java, v 0.1 2017/7/18 0018 17:52 tjwang Exp $
 */
@Service
public class CompanyExItemServiceImpl implements ICompanyExItemService {

    @Autowired
    private CompanyExItemDao companyExItemDao;

    @Override
    public CompanyExItem getByNbxh(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "内部序号不能为空");
        CompanyExItemExample exam = new CompanyExItemExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);

        PageBounds pb = new PageBounds(1, 1, false);
        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR, "数据不能为空");
        }

        return ds.get(0);
    }

}
