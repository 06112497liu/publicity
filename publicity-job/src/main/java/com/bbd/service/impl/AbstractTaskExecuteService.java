/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.domain.CompareTask;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.service.ICompanyService;
import com.bbd.service.ICompareTaskService;
import com.bbd.service.ITaskExecuteService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tjwang
 * @version $Id: AbstractTaskExecuteService.java, v 0.1 2017/7/17 0017 15:31 tjwang Exp $
 */
public abstract class AbstractTaskExecuteService implements ITaskExecuteService {

    @Autowired
    protected ICompanyService companyService;
    @Autowired
    protected ICompareTaskService compareTaskService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void excuteCompareTask(Long taskId) {
        CompareTask task = compareTaskService.getById(taskId);
        List<PubCompanyInfo> ds = companyService.getNextCompanys(task.getCurNbxh());
        if (ds.size() == 0) {
            finishTask(taskId);
        }
        List<String> nbxhs = Lists.newArrayList();
        ds.forEach(p -> nbxhs.add(p.getNbxh()));
        doCompare(taskId, nbxhs);
    }

    protected abstract void doCompare(long taskId, List<String> nbxhs);

    protected abstract void finishTask(long taskId);

}
