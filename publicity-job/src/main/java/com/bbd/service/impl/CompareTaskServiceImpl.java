/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.common.Constants;
import com.bbd.dao.*;
import com.bbd.domain.AnnualExPrevDetailExample;
import com.bbd.domain.CompareTask;
import com.bbd.domain.CompareTaskExample;
import com.bbd.domain.InstantlyExPrevDetailExample;
import com.bbd.service.ICompareTaskService;
import com.bbd.util.StringUtils;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mybatis.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    private CompareTaskDao           compareTaskDao;

    @Autowired
    private CompareTaskExtDao        compareTaskExtDao;

    @Autowired
    private ExDetailExtDao           exDetailExtDao;

    @Autowired
    private CompareStatisticExtDao   compareStatisticExtDao;

    @Autowired
    private InstantlyExPrevDetailDao instantlyExPrevDetailDao;
    
    @Autowired
    private AnnualExPrevDetailDao annualExPrevDetailDao;

    @Override
    public CompareTask getById(Long id) {
        Preconditions.checkNotNull(id, "id不能为空");
        CompareTask task = compareTaskDao.selectByPrimaryKey(id);
        if (task == null) {
            throw new ApplicationException(CommonErrorCode.BIZ_ERROR, "找不到ID为[" + id + "]的对比任务");
        }
        return task;
    }

    @Override
    public Long createNextCompareTask(int type) {
        Preconditions.checkArgument(Lists.newArrayList(1, 2).contains(type), "非法任务类型 : " + type);

        CompareTaskExample exam = new CompareTaskExample();
        exam.createCriteria().andTypeEqualTo(type);
        exam.setOrderByClause("num desc");
        PageBounds pb = new PageBounds(1, 1, false);
        List<CompareTask> ds = compareTaskDao.selectByExampleWithPageBounds(exam, pb);

        Date now = new Date();

        CompareTask task = new CompareTask();
        if (ds.size() == 0) {
            task.setNum(1);
        } else {
            task.setNum(ds.get(0).getNum() + 1);
        }
        task.setType(type);
        task.setBeginTime(now);
        task.setGmtCreate(now);
        compareTaskDao.insertSelective(task);

        return task.getId();
    }

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

    @Override
    public Optional<CompareTask> getLastAnnualTask() {
        CompareTaskExample exam = new CompareTaskExample();
        exam.createCriteria().andTypeEqualTo(Constants.TASK_ANNUAL_TYPE);
        exam.setOrderByClause("begin_time desc");

        PageBounds pb = new PageBounds(1, 1, false);

        List<CompareTask> ds = compareTaskDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return Optional.absent();
        }

        return Optional.of(ds.get(0));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void finishAnnualCompareTask(long taskId) {
        int exNum = exDetailExtDao.countAnnualExNum();
        exDetailExtDao.deleteAnnualExDetailPrev();
        exDetailExtDao.copyAnnualExToPre();
        exDetailExtDao.deleteAnnualExDetail();
        finishTask(taskId, exNum, 1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void finishInstantlyCompareTask(long taskId) {
        int exNum = exDetailExtDao.countAnnualExNum();
        exDetailExtDao.deleteInstantlyExDetailPrev();
        exDetailExtDao.copyInstantlyExToPre();
        exDetailExtDao.deleteInstantlyExDetail();
        finishTask(taskId, exNum, 2);
    }

    private void finishTask(long taskId, int exNum, Integer taskType) {
        Date now = new Date();
        CompareTask updateTask = new CompareTask();
        updateTask.setExNum(exNum);
        updateTask.setId(taskId);
        updateTask.setEndTime(now);
        updateTask.setGmtModified(now);
        compareTaskDao.updateByPrimaryKeySelective(updateTask);
        if(2 == taskType) compareStatisticExtDao.updateFullTaskNum();
    }

    @Override
    public void updateCompareTaskInfo(long taskId, String nbxh, int count) {
        CompareTask u = new CompareTask();
        u.setId(taskId);
        u.setCurNbxh(nbxh);
        compareTaskDao.updateByPrimaryKeySelective(u);
        compareTaskExtDao.updateCount(taskId, 1, count);
    }

    @Override
    public void updateExIncreasedAndDecreased(int taskType, long taskId, String nbxh, boolean isException) {
        
        Preconditions.checkArgument(StringUtils.isNotBlank("nbxh"), "内部序号不能为空");
        Long count = 0L;
        if(taskType == 2) {
            InstantlyExPrevDetailExample inExam = new InstantlyExPrevDetailExample();
            inExam.createCriteria().andNbxhEqualTo(nbxh);
            count = instantlyExPrevDetailDao.countByExample(inExam);
        } else if(taskType == 1) {
            AnnualExPrevDetailExample anExam = new AnnualExPrevDetailExample();
            anExam.createCriteria().andNbxhEqualTo(nbxh);
            count = annualExPrevDetailDao.countByExample(anExam);
        }

        if(count == 0 && isException){
            compareTaskExtDao.updateExIncreased(taskId);
        } else if(count > 0 && !isException) {
            compareTaskExtDao.updateExDecreased(taskId);
        } else {
            return;
        }        
    }
}
