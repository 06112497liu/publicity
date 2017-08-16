/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.common.Constants;
import com.bbd.dao.InsStockholderCmpDao;
import com.bbd.dao.InsStockholderStdDao;
import com.bbd.domain.*;
import com.bbd.enums.InvestWayEnum;
import com.bbd.service.compare.*;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
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
        return true;
    }

    /**
     * 是否需要对比股东情况信息
     *
     * @param stdOpt
     * @return
     */
    private boolean needCompareStockHolder(Optional<InsStockholderStd> stdOpt) {
        if (!stdOpt.isPresent()) {
            return false;
        }
        InsStockholderStd std = stdOpt.get();
        Date createTime = std.getGmtCreate();
        if (createTime == null) {
            return true;
        }
        DateTime begin = new DateTime(createTime);
        DateTime now = new DateTime();
        int days = Days.daysBetween(begin, now).getDays();
        if (days > 20) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isSingle() {
        return false;
    }

    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<InsStockholderStd> stdOpt, Optional<InsStockholderCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();

        if (!needCompareStockHolder(stdOpt)) {
            return result;
        }

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
        String subStdCode = (std == null ? null : std.getSubCronFrom());
        String subCmpCode = (cmp == null ? null : cmp.getSubCronFrom());
        String subStdDesc = (subStdCode == null ? null : InvestWayEnum.getDescByCode(Integer.parseInt(subStdCode)));
        String subCmpDesc = (subCmpCode == null ? null : InvestWayEnum.getDescByCode(Integer.parseInt(subCmpCode)));
        StringCompareProperty subCronFromProp = StringCompareProperty.build(PropertyEnum.INS_SUB_CRON_FROM.getCode(), stockHolderModule, subStdDesc, cmp != null ? subCmpDesc : null);
        result.add(subCronFromProp);

        // 实缴出资额对比项
        NumberCompareProperty acCronCapProp = NumberCompareProperty.build(PropertyEnum.INS_AC_CRON_CAP.getCode(), stockHolderModule, std.getAcCronCap(), cmp != null ? cmp.getAcCronCap() : null);
        result.add(acCronCapProp);

        // 实缴出资方式对比项
        String acStdCode = (std == null ? null : std.getSubCronFrom());
        String acCmpCode = (cmp == null ? null : cmp.getSubCronFrom());
        String acStdDesc = (acStdCode == null ? null : InvestWayEnum.getDescByCode(Integer.parseInt(acStdCode)));
        String acCmpDesc = (acCmpCode == null ? null : InvestWayEnum.getDescByCode(Integer.parseInt(acCmpCode)));
        StringCompareProperty acCronFrom = StringCompareProperty.build(PropertyEnum.INS_AC_CRON_FROM.getCode(), stockHolderModule, acStdDesc, cmp != null ? acCmpDesc : null);
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
