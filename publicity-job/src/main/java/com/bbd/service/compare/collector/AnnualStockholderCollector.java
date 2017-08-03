/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.dao.AnnualStockholderCmpDao;
import com.bbd.dao.AnnualStockholderStdDao;
import com.bbd.domain.*;
import com.bbd.service.compare.*;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 股东及出资信息年报属性收集
 *
 * @author tjwang
 * @version $Id: AnnualStockholderPropertyCollector.java, v 0.1 2017/7/27 0027 11:23 tjwang Exp $
 */
@Component
public class AnnualStockholderCollector extends AnnualPropertyCollector<AnnualStockholderStd, AnnualStockholderCmp> {

    @Autowired
    private AnnualStockholderStdDao annualStockholderStdDao;

    @Autowired
    private AnnualStockholderCmpDao annualStockholderCmpDao;

    /**
     * 前置校验 
     */
    @Override
    protected boolean precheck(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        if (cp == null) {
            return false;
        }
        return needCompareStockHolder(c);
    }

    /**
     * 是否需要对比股东及出资信息
     *
     * @return
     */
    private boolean needCompareStockHolder(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        if (set.contains(cp)) {
            return true;
        }
        return false;
    }

    /**
     * 判断该对比是不是单个对比
     */
    @Override
    protected boolean isSingle() {
        return false;
    }

    /**
     * 如果是多个对比的话，获取比对标准字段
     */
    @Override
    protected String getStdKey(AnnualStockholderStd std) {
        return std.getShareholder();
    }

    /**
     * 获取需要对比的字段
     */
    @Override
    protected String getCmpKey(AnnualStockholderCmp cmp) {
        return cmp.getShareholder();
    }

    /**
     * 获取标准数据
     */
    @Override
    protected List<AnnualStockholderStd> getStds(String nbxh) {
        AnnualStockholderStdExample example = new AnnualStockholderStdExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualStockholderStd> result = annualStockholderStdDao.selectByExample(example);
        return result;
    }

    /**
     * 获取比对数据
     */
    @Override
    protected List<AnnualStockholderCmp> getCmps(String nbxh) {
        AnnualStockholderCmpExample example = new AnnualStockholderCmpExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualStockholderCmp> result = annualStockholderCmpDao.selectByExample(example);
        return result;
    }

    /**
     * 获取比对项
     */
    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<AnnualStockholderStd> stdOpt, Optional<AnnualStockholderCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();
        int stockHolderModule = AnnualModule.STOCKHOLDER.getCode();
        AnnualStockholderStd stockholderStd = stdOpt.get();
        AnnualStockholderCmp stockholderCmp = cmpOpt.isPresent() ? cmpOpt.get() : null;

        // 认缴出资额对比项
        NumberCompareProperty subCronCapProp = NumberCompareProperty.build(PropertyEnum.ANNUAL_SUB_CRON_CAP.getCode(), stockHolderModule, stockholderStd.getSubCronCap(),
            stockholderCmp != null ? stockholderCmp.getSubCronCap() : null);
        result.add(subCronCapProp);

        // 认缴出资时间对比项
        DateCompareProperty subCronDateProp = DateCompareProperty.build(PropertyEnum.ANNUAL_SUB_CRON_DATE.getCode(), stockHolderModule, stockholderStd.getSubCronDate(),
            stockholderCmp != null ? stockholderCmp.getSubCronDate() : null);
        result.add(subCronDateProp);

        // 认缴出资方式对比项
        StringCompareProperty subCronFromProp = StringCompareProperty.build(PropertyEnum.ANNUAL_SUB_CRON_FROM.getCode(), stockHolderModule, stockholderStd.getSubCronFrom(),
            stockholderCmp != null ? stockholderCmp.getSubCronFrom() : null);
        result.add(subCronFromProp);

        // 实缴出资额对比项
        NumberCompareProperty acCronCapProp = NumberCompareProperty.build(PropertyEnum.ANNUAL_AC_CRON_CAP.getCode(), stockHolderModule, stockholderStd.getAcCronCap(),
            stockholderCmp != null ? stockholderCmp.getAcCronCap() : null);
        result.add(acCronCapProp);

        // 实缴出资方式对比项
        StringCompareProperty acCronFromProp = StringCompareProperty.build(PropertyEnum.ANNUAL_AC_CRON_FROM.getCode(), stockHolderModule, stockholderStd.getAcCronFrom(),
            stockholderCmp != null ? stockholderCmp.getAcCronFrom() : null);
        result.add(acCronFromProp);

        return result;
    }

}
