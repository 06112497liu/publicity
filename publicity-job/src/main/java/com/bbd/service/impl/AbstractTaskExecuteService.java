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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author tjwang
 * @version $Id: AbstractTaskExecuteService.java, v 0.1 2017/7/17 0017 15:31 tjwang Exp $
 */
public abstract class AbstractTaskExecuteService implements ITaskExecuteService {

    @Autowired
    protected ICompanyService companyService;

    @Autowired
    protected ICompareTaskService compareTaskService;


    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void excuteCompareTask(Long taskId) {
        CompareTask task = compareTaskService.getById(taskId);
        List<PubCompanyInfo> ds = companyService.getNextCompanys(task.getCurNbxh());
        if (ds.size() == 0) {
            finishTask(taskId);
            return;
        }
        List<String> nbxhs = Lists.newArrayList();
        ds.forEach(p -> nbxhs.add(p.getNbxh()));

        List<Future> fs = Lists.newArrayList();
        for (String nbxh : nbxhs) {
            Future<?> f = executorService.submit(() -> {
                doCompare(taskId, nbxh);
            });
            fs.add(f);
        }
        fs.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        CompareTask u = new CompareTask();
        u.setId(taskId);
        u.setCurNbxh(ds.get(ds.size() - 1).getNbxh());
        compareTaskService.updateCompareTask(u);
    }

    protected abstract void doCompare(long taskId, String nbxh);

    protected abstract void finishTask(long taskId);

}
