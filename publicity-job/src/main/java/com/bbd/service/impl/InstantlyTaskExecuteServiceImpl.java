/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.CompanyExItemExtDao;
import com.bbd.service.ICompareService;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 即时信息任务执行服务
 *
 * @author tjwang
 * @version $Id: InstantlyTaskExecuteServiceImpl.java, v 0.1 2017/7/17 0017 15:35 tjwang Exp $
 */
@Service("instantlyTaskExecuteService")
public class InstantlyTaskExecuteServiceImpl extends AbstractTaskExecuteService {

    @Resource(name = "instantlyCompareService")
    private ICompareService compareService;
    
    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void doCompare(long taskId, List<String> nbxhs) {
        List<Future> fs = Lists.newArrayList();
        for (String nbxh : nbxhs) {
            Future<?> f = executorService.submit(() -> {
                compareService.compare(taskId, nbxh);
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

    }

    @Override
    protected void finishTask(long taskId) {
        companyExItemExtDao.insertCompanyExItemPreIns();
        companyExItemExtDao.updateCompanyExItemPreIns();
        compareTaskService.finishInstantlyCompareTask(taskId);
    }
}
