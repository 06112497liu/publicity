/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.common.Constants;
import com.bbd.dao.InsStockholderCmpDao;
import com.bbd.dao.InsStockholderStdDao;
import com.bbd.domain.*;
import com.bbd.service.compare.*;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 股东信息即时信息收集器
 *
 * @author tjwang
 * @version $Id: InstantlyStockholderCollector.java, v 0.1 2017/7/27 0027 11:39 tjwang Exp $
 */
@Component
public class InstantlyStockholderCollector extends InstantlyPropertyCollector<InsStockholderStd, InsStockholderCmp> {

    @Autowired
    private InsStockholderStdDao insStockholderStdDao;

    @Autowired
    private InsStockholderCmpDao insStockholderCmpDao;

    /**
     * 前置校验
     */
    @Override
    protected boolean precheck(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        if (cp == null || !cp.equals(Constants.COMPANY_PROPERTY_ENTERPISE)) {
            return false;
        }
        return needCompareStockHolder(c.getNbxh());
    }

    /**
     * 是否需要对比股东情况信息
     *
     * @param nbxh
     * @return
     */
    private boolean needCompareStockHolder(String nbxh) {
        return true;
    }

    @Override
    protected boolean isSingle() {
        return false;
    }

    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<InsStockholderStd> stdOpt, Optional<InsStockholderCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();
        int stockHolderModule = InstantlyModule.STOCKHOLDER.getCode();
        InsStockholderStd std = stdOpt.get();
        InsStockholderCmp cmp = cmpOpt.isPresent() ? cmpOpt.get() : null;

        // 股东名称对比项
        StringCompareProperty shareholderProp = StringCompareProperty
            .build(PropertyEnum.INS_STOCK_HOLDER.getCode(), stockHolderModule, std.getShareholder(), cmp != null ? cmp.getShareholder() : null);
        result.add(shareholderProp);

        // 认缴出资额对比项
        NumberCompareProperty subCronCapProp = NumberCompareProperty.build(PropertyEnum.INS_SUB_CRON_CAP.getCode(), stockHolderModule, std.getSubCronCap(), cmp != null ? cmp.getSubCronCap() : null);
        result.add(subCronCapProp);

        // 认缴出资时间对比项
        DateCompareProperty subCronDateProp = DateCompareProperty.build(PropertyEnum.INS_SUB_CRON_DATE.getCode(), stockHolderModule, std.getSubCronDate(), cmp != null ? cmp.getSubCronDate() : null);
        result.add(subCronDateProp);

        // 认缴出资方式对比项
        StringCompareProperty subCronFromProp = StringCompareProperty.build(PropertyEnum.INS_SUB_CRON_FROM.getCode(), stockHolderModule, std.getSubCronFrom(), cmp != null ? cmp.getSubCronFrom()
            : null);
        result.add(subCronFromProp);

        // 实缴出资额对比项
        NumberCompareProperty acCronCapProp = NumberCompareProperty.build(PropertyEnum.INS_AC_CRON_CAP.getCode(), stockHolderModule, std.getAcCronCap(), cmp != null ? cmp.getAcCronCap() : null);
        result.add(acCronCapProp);

        // 实缴出资方式对比项
        StringCompareProperty acCronFrom = StringCompareProperty.build(PropertyEnum.INS_AC_CRON_FROM.getCode(), stockHolderModule, std.getAcCronFrom(), cmp != null ? cmp.getAcCronFrom() : null);
        result.add(acCronFrom);

        return result;
    }

    @Override
    protected List<InsStockholderCmp> getCmps(String nbxh) {
        InsStockholderCmpExample exam = new InsStockholderCmpExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return insStockholderCmpDao.selectByExample(exam);
    }

    @Override
    protected List<InsStockholderStd> getStds(String nbxh) {
        InsStockholderStdExample exam = new InsStockholderStdExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return insStockholderStdDao.selectByExample(exam);
    }

    @Override
    protected String getStdKey(InsStockholderStd std) {
        return std.getShareholder();
    }

    @Override
    protected String getCmpKey(InsStockholderCmp cmp) {
        return cmp.getShareholder();
    }

}
