/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.dao.AnnualBranchCmpDao;
import com.bbd.dao.AnnualBranchStdDao;
import com.bbd.domain.*;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.CompareProperty;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.compare.StringCompareProperty;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分支机构年报属性收集
 *
 * @author tjwang
 * @version $Id: AnnualBranchCollector.java, v 0.1 2017/7/27 0027 11:35 tjwang Exp $
 */
@Component
public class AnnualBranchCollector extends AnnualPropertyCollector<AnnualBranchStd, AnnualBranchCmp> {

    @Autowired
    private AnnualBranchStdDao annualBranchStdDao;

    @Autowired
    private AnnualBranchCmpDao annualBranchCmpDao;

    /**
    * 前置校验
    */
    @Override
    protected boolean precheck(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        if (cp == null) {
            return false;
        }
        return needCompareBranch(c);
    }

    /**
     * 判断知否要进行分之机构的对比
     * @return
     */
    private boolean needCompareBranch(PubCompanyInfo c) {
        return c.getCompanyProperty() == 4;
    }

    /**
    * 判断是否是单个对比
    */
    @Override
    protected boolean isSingle() {
        return false;
    }

    /**
     * 如果不是单个对比，获取比对标准字段
     */
    @Override
    protected String getStdKey(AnnualBranchStd std) {
        return std.getRegno();
    }

    /**
     * 获取比对标准字段
     */
    @Override
    protected String getCmpKey(AnnualBranchCmp cmp) {
        return cmp.getRegno();
    }

    /**
    * 获取标准数据
    */
    @Override
    protected List<AnnualBranchStd> getStds(String nbxh) {
        AnnualBranchStdExample example = new AnnualBranchStdExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualBranchStd> result = annualBranchStdDao.selectByExample(example);
        return result;
    }

    /**
    * 获取比对数据
    */
    @Override
    protected List<AnnualBranchCmp> getCmps(String nbxh) {
        AnnualBranchCmpExample example = new AnnualBranchCmpExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualBranchCmp> result = annualBranchCmpDao.selectByExample(example);
        return result;
    }

    /**
    * 获取对比项
    */
    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<AnnualBranchStd> stdOpt, Optional<AnnualBranchCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();
        int branchModule = AnnualModule.BRANCH.getCode();
        AnnualBranchStd branchStd = stdOpt.get();
        AnnualBranchCmp branchCmp = cmpOpt.isPresent() ? cmpOpt.get() : null;

        // 分支机构名称对比项
        StringCompareProperty branchProp = StringCompareProperty.build(PropertyEnum.ANNUAL_BRANCH_NAME.getCode(), branchModule, branchStd.getName(), branchCmp != null ? branchCmp.getName() : null);
        result.add(branchProp);
        return result;
    }

}
