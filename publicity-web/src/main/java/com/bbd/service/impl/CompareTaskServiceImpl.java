/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.CompareTaskDao;
import com.bbd.domain.CompareTask;
import com.bbd.domain.CompareTaskExample;
import com.bbd.service.ICompareTaskService;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mybatis.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 对比任务接口，实现
 *
 * @author tjwang
 * @version $Id: CompareTaskServiceImpl.java, v 0.1 2017/7/12 0012 14:44 tjwang Exp $
 */
@Service
public class CompareTaskServiceImpl implements ICompareTaskService {

    @Autowired
    private CompareTaskDao compareTaskDao;

    @Override
    public Optional<CompareTask> getCurrentRunningTask(int type) {
        Preconditions.checkArgument(Lists.newArrayList(1, 2).contains(type), "非法任务类型 : " + type);

        CompareTaskExample exam = new CompareTaskExample();
        exam.createCriteria().andTypeEqualTo(type).andBeginTimeIsNotNull().andEndTimeIsNull();
        PageBounds pb = new PageBounds(1, 1, false);
        List<CompareTask> ds = compareTaskDao.selectByExampleWithPageBounds(exam, pb);

        CompareTask task = null;
        if (ds.size() > 0) {
            task = ds.get(0);
        }
        return Optional.fromNullable(task);
    }

    /**
     * 获取上一次比对任务统计
     */
    @Override
    public Optional<CompareTask> getLastTask(int type, int last) {
        Preconditions.checkArgument(Lists.newArrayList(1, 2).contains(type), "非法任务类型 : " + type);
        
        CompareTaskExample exam = new CompareTaskExample();
        exam.createCriteria().andTypeEqualTo(type).andNumEqualTo(last);
        PageBounds pb = new PageBounds(1, 1, false);
        List<CompareTask> ds = compareTaskDao.selectByExampleWithPageBounds(exam, pb);

        CompareTask task = null;
        if (ds.size() > 0) {
            task = ds.get(0);
        }
        return Optional.fromNullable(task);
    }

}
