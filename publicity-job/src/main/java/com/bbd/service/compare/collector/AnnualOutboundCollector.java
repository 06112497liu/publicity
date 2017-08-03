/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.dao.AnnualOutboundInvestmentCmpDao;
import com.bbd.dao.AnnualOutboundInvestmentStdDao;
import com.bbd.domain.*;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.CompareProperty;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.compare.StringCompareProperty;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 对外投资年报属性收集
 *
 * @author tjwang
 * @version $Id: AnnualOutboundCollector.java, v 0.1 2017/7/27 0027 11:31 tjwang Exp $
 */
@Component
public class AnnualOutboundCollector extends AnnualPropertyCollector<AnnualOutboundInvestmentStd, AnnualOutboundInvestmentCmp> {

    @Autowired
    private AnnualOutboundInvestmentStdDao annualOutboundInvestmentStdDao;

    @Autowired
    private AnnualOutboundInvestmentCmpDao annualOutboundInvestmentCmpDao;

    /**
    * 前置校验
    */
    @Override
    protected boolean precheck(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        if (cp == null) {
            return false;
        }
        return needCompareOutbound(c);
    }

    /**
     * 是否需要对比对外投资信息
     *
     * @return
     */
    private boolean needCompareOutbound(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        if (set.contains(cp)) {
            return true;
        }
        return false;
    }

    /**
     *
     */
    @Override
    protected boolean isSingle() {
        return false;
    }

    /**
     * 如果是多个对比的话，获取比对标准字段
     */
    @Override
    protected String getStdKey(AnnualOutboundInvestmentStd std) {
        return std.getRegno();
    }

    /**
     * 获取需要对比的字段
     */
    @Override
    protected String getCmpKey(AnnualOutboundInvestmentCmp cmp) {
        return cmp.getRegno();
    }

    /**
     * 获取标准数据
     */
    @Override
    protected List<AnnualOutboundInvestmentStd> getStds(String nbxh) {
        AnnualOutboundInvestmentStdExample example = new AnnualOutboundInvestmentStdExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualOutboundInvestmentStd> result = annualOutboundInvestmentStdDao.selectByExample(example);
        return result;
    }

    /**
     * 获取对比数据
     */
    @Override
    protected List<AnnualOutboundInvestmentCmp> getCmps(String nbxh) {
        AnnualOutboundInvestmentCmpExample example = new AnnualOutboundInvestmentCmpExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualOutboundInvestmentCmp> result = annualOutboundInvestmentCmpDao.selectByExample(example);
        return result;
    }

    /**
     * 构建对比属性
     */
    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<AnnualOutboundInvestmentStd> stdOpt, Optional<AnnualOutboundInvestmentCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();
        int outInvestModule = AnnualModule.OUT_INVEST.getCode();
        AnnualOutboundInvestmentStd outInvestStd = stdOpt.get();
        AnnualOutboundInvestmentCmp outInvestCmp = cmpOpt.isPresent() ? cmpOpt.get() : null;

        // 投资公司名称对比项
        StringCompareProperty companyNameProp = StringCompareProperty.build(PropertyEnum.ANNUAL_INV_COMPANY_NAME.getCode(), outInvestModule, outInvestStd.getCompanyName(),
            outInvestCmp != null ? outInvestCmp.getCompanyName() : null);
        result.add(companyNameProp);

        return result;
    }
}
