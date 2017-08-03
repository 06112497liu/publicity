/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.service.ICompareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    protected void doCompare(long taskId, List<String> nbxhs) {
        nbxhs.forEach(nbxh -> compareService.compare(taskId, nbxh));
    }

    @Override
    protected void finishTask(long taskId) {
        compareTaskService.finishAnnualCompareTask(taskId);
    }

}
