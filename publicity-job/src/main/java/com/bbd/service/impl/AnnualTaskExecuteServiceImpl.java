/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.CompanyExItemExtDao;
import com.bbd.service.ICompareService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 年报任务执行服务
 *
 * @author tjwang
 * @version $Id: TaskExecuteServiceImpl.java, v 0.1 2017/7/13 0013 17:54 tjwang Exp $
 */
@Service("annualTaskExecuteService")
public class AnnualTaskExecuteServiceImpl extends AbstractTaskExecuteService {

    @Resource(name = "annualCompareService")
    private ICompareService compareService;
    
    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    @Override
    protected void doCompare(long taskId, String nbxh) {
        compareService.compare(taskId, nbxh);
    }

    @Override
    protected void finishTask(long taskId) {
        companyExItemExtDao.insertCompanyExItemPreAnnual();
        companyExItemExtDao.updateCompanyExItemPreAnnual();
        compareTaskService.finishAnnualCompareTask(taskId);
    }

}
