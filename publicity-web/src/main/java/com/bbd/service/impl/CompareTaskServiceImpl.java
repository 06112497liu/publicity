/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.common.Constants;
import com.bbd.dao.CompanyExItemExtDao;
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
    
    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    /**
     * 获取正在运行的任务
     */
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
     * 获取上一次对比任务
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

    /**
     * 获取即时信息异常企业数量
     */
    @Override
    public int getInsExNum() {
        int insExLast = 0;
        int insExIncreaseCurr = 0;
        int insExDecreaseCurr = 0;
        Optional<CompareTask> insOptCurr = getCurrentRunningTask(Constants.TASK_INSTANTLY_TYPE); //当次
        int insNum = 1;
        if(insOptCurr.isPresent()) {
            CompareTask insTask = insOptCurr.get();
            insNum = insTask.getNum();
            insExIncreaseCurr = insTask.getExIncreased();
            insExDecreaseCurr = insTask.getExDecrease();
        }
        Optional<CompareTask> insOptLast = null;
        if(insNum != 1) {
            insOptLast = getLastTask(Constants.TASK_INSTANTLY_TYPE, insNum - 1); 
            if(insOptLast.isPresent()) insExLast = insOptLast.get().getExNum();
        }
        if(!insOptCurr.isPresent()) {
            insOptLast = getLastTask(Constants.TASK_INSTANTLY_TYPE, insNum);
            if(insOptLast.isPresent()) insExLast = insOptLast.get().getExNum();
        }
        int insExNum = insExLast + insExIncreaseCurr - insExDecreaseCurr;
        return insExNum;
    }

    /**
     * 获取年报信息异常企业数量
     */
    @Override
    public int getAnnualExNum() {
        int annualExLast = 0;
        int annualExIncreaseCurr = 0;
        int annualExDecreaseCurr = 0;
        Optional<CompareTask> annualOptCurr = getCurrentRunningTask(Constants.TASK_ANNUAL_TYPE); //当次
        int annualNum = 1;
        if(annualOptCurr.isPresent()) {
            CompareTask annualTask = annualOptCurr.get();
            annualNum = annualTask.getNum();
            annualExIncreaseCurr = annualTask.getExIncreased();
            annualExDecreaseCurr = annualTask.getExDecrease();
        }        
        Optional<CompareTask> annualOptLast = null;
        if(annualNum != 1) {
            annualOptLast = getLastTask(Constants.TASK_ANNUAL_TYPE, annualNum - 1);
            if(annualOptLast.isPresent()) annualExLast = annualOptLast.get().getExNum();
        }
        if(!annualOptCurr.isPresent()) {
            annualOptLast = getLastTask(Constants.TASK_ANNUAL_TYPE, annualNum);
            if(annualOptLast.isPresent()) annualExLast = annualOptLast.get().getExNum();
        }        
        int annualExNum = annualExLast + annualExIncreaseCurr - annualExDecreaseCurr;
        return annualExNum;
    }

    /**
     * 获取异常企业总量
     */
    @Override
    public int getExNum() {
        return companyExItemExtDao.queryExNum();
    }

}
