/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.dao.AnnualExtProvGuarInfoCmpDao;
import com.bbd.dao.AnnualExtProvGuarInfoStdDao;
import com.bbd.domain.*;
import com.bbd.enums.PriClaTypeEnum;
import com.bbd.service.compare.*;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 对外担保信息年报属性收集
 *
 * @author tjwang
 * @version $Id: AnnualExtProvGuarCollector.java, v 0.1 2017/7/27 0027 11:34 tjwang Exp $
 */
@Component
public class AnnualExtProvGuarCollector extends AnnualPropertyCollector<AnnualExtProvGuarInfoStd, AnnualExtProvGuarInfoCmp> {

    @Autowired
    private AnnualExtProvGuarInfoStdDao annualExtProvGuarInfoStdDao;

    @Autowired
    private AnnualExtProvGuarInfoCmpDao annualExtProvGuarInfoCmpDao;

    /**
     * 前置校验
     */
    @Override
    protected boolean precheck(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        if (cp == null) {
            return false;
        }
        return needCompareExtProvGuar(c);
    }

    /**
     * 判断是否需要对比对外提供担保保证信息
     * @return
     */
    private boolean needCompareExtProvGuar(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        Set<Integer> set = Sets.newHashSet(1, 2, 3);
        if (set.contains(cp)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否进行是单个对比
     */
    @Override
    protected boolean isSingle() {
        return false;
    }

    /**
     * 如果是多个对比，获取比对字段标准
     */
    @Override
    protected String getStdKey(AnnualExtProvGuarInfoStd std) {
        return std.getCreditor();
    }

    /**
     * 获取比对标准
     */
    @Override
    protected String getCmpKey(AnnualExtProvGuarInfoCmp cmp) {
        return cmp.getCreditor();
    }

    /**
     * 获取标准数据
     */
    @Override
    protected List<AnnualExtProvGuarInfoStd> getStds(String nbxh) {
        AnnualExtProvGuarInfoStdExample example = new AnnualExtProvGuarInfoStdExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualExtProvGuarInfoStd> result = annualExtProvGuarInfoStdDao.selectByExample(example);
        return result;
    }

    /**
     * 获取对比数据
     */
    @Override
    protected List<AnnualExtProvGuarInfoCmp> getCmps(String nbxh) {
        AnnualExtProvGuarInfoCmpExample example = new AnnualExtProvGuarInfoCmpExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualExtProvGuarInfoCmp> result = annualExtProvGuarInfoCmpDao.selectByExample(example);
        return result;
    }

    /**
     * 获取比对项
     */
    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<AnnualExtProvGuarInfoStd> stdOpt, Optional<AnnualExtProvGuarInfoCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();
        int extProvMoudle = AnnualModule.EXT_PROV.getCode();
        AnnualExtProvGuarInfoStd extProvStd = stdOpt.get();
        AnnualExtProvGuarInfoCmp extProvCmp = cmpOpt.isPresent() ? cmpOpt.get() : null;

        // 债务人对比项
        StringCompareProperty debitorProp = StringCompareProperty.build(PropertyEnum.ANNUAL_EXT_PROV_DEBITOR.getCode(), extProvMoudle, extProvStd.getDebitor(),
            extProvCmp != null ? extProvCmp.getDebitor() : null);
        result.add(debitorProp);

        // 主债权种类对比项
        String stdCode = (extProvStd == null ? null : extProvStd.getPriCalSecKind());
        String cmpCode = (extProvCmp == null ? null : extProvCmp.getPriCalSecKind());
        String stdDesc = (stdCode == null ? null : PriClaTypeEnum.getDescByCode(Integer.parseInt(stdCode)));
        String cmpDesc = (cmpCode == null ? null : PriClaTypeEnum.getDescByCode(Integer.parseInt(cmpCode)));
        StringCompareProperty priCalSecKindProp = StringCompareProperty.build(PropertyEnum.ANNUAL_EXT_PROV_PRI_CAL_SEC_KIND.getCode(), extProvMoudle, stdDesc,
            extProvCmp != null ? cmpDesc : null);
        result.add(priCalSecKindProp);

        // 主债权数额
        NumberCompareProperty priCalSecAmProp = NumberCompareProperty.build(PropertyEnum.ANNUAL_EXT_PROV_PRI_CAL_SEC_AM.getCode(), extProvMoudle, extProvStd.getPriCalSecAm(),
            extProvCmp != null ? extProvCmp.getPriCalSecAm() : null);
        result.add(priCalSecAmProp);

        // 履行债务的期限自
        DateCompareProperty pefPerFromProp = DateCompareProperty.build(PropertyEnum.ANNUAL_EXT_PROV_PEF_PER_FROM.getCode(), extProvMoudle, extProvStd.getPefPerFrom(),
            extProvCmp != null ? extProvCmp.getPefPerFrom() : null);
        result.add(pefPerFromProp);

        // 履行债务的期限至
        DateCompareProperty pefPerToProp = DateCompareProperty.build(PropertyEnum.ANNUAL_EXT_PROV_PEF_PER_TO.getCode(), extProvMoudle, extProvStd.getPefPerTo(),
            extProvCmp != null ? extProvCmp.getPefPerTo() : null);
        result.add(pefPerToProp);

        return result;
    }
}
