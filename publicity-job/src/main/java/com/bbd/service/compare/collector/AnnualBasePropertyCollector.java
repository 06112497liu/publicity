/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.common.Constants;
import com.bbd.dao.AnnualBaseCmpDao;
import com.bbd.dao.AnnualBaseStdDao;
import com.bbd.domain.*;
import com.bbd.enums.OpStateEnum;
import com.bbd.service.compare.*;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 年报基本信息属性收集
 *
 * @author tjwang
 * @version $Id: AnnualBasePropertyCollector.java, v 0.1 2017/7/27 0027 11:21 tjwang Exp $
 */
@Component
public class AnnualBasePropertyCollector extends AnnualPropertyCollector<AnnualBaseStd, AnnualBaseCmp> {

    @Autowired
    private AnnualBaseStdDao annualBaseStdDao;

    @Autowired
    private AnnualBaseCmpDao annualBaseCmpDao;

    @Override
    protected boolean precheck(PubCompanyInfo c) {
        Integer cp = c.getCompanyProperty();
        if (cp == null) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean isSingle() {
        return true;
    }

    @Override
    protected List<CompareProperty> getProperties(PubCompanyInfo c, Optional<AnnualBaseStd> stdOpt, Optional<AnnualBaseCmp> cmpOpt) {
        List<CompareProperty> result = Lists.newArrayList();
        if (!stdOpt.isPresent()) {
            return result;
        }
        int baseModule = AnnualModule.BASE.getCode();
        Integer cp = c.getCompanyProperty();
        AnnualBaseStd std = stdOpt.get();
        AnnualBaseCmp cmp = cmpOpt.isPresent() ? cmpOpt.get() : null;

        // 注册号对比项
        StringCompareProperty regnoProp = StringCompareProperty.build(PropertyEnum.ANNUAL_REGNO.getCode(), baseModule, std.getRegno(), cmp != null ? cmp.getRegno() : null, "");
        result.add(regnoProp);

        // 企业名称对比项
        StringCompareProperty companyNameProp = StringCompareProperty.build(PropertyEnum.ANNUAL_COMPANY_NAME.getCode(), baseModule, std.getCompanyName(), cmp != null ? cmp.getCompanyName() : null);
        result.add(companyNameProp);

        // 联系电话对比项
        PhoneCompareProperty phonesProp = PhoneCompareProperty.build(PropertyEnum.ANNUAL_PHONES.getCode(), baseModule, cmp != null ? cmp.getPhones() : null, "");
        result.add(phonesProp);

        // 从业人数对比项
        NumberCompareProperty empnumProp = NumberCompareProperty.build(PropertyEnum.ANNUAL_EMPNO.getCode(), baseModule, std.getEmpnum(), cmp != null ? cmp.getEmpnum() : null, "人");
        result.add(empnumProp);

        // 地址对比项
        if (cp == Constants.COMPANY_PROPERTY_ENTERPISE || cp == Constants.COMPANY_PROPERTY_NZ) {
            AddressCompareProperty addrProp = AddressCompareProperty.build(PropertyEnum.ANNUAL_ADDR.getCode(), baseModule, cmp != null ? cmp.getAddr() : null);
            result.add(addrProp);
        }

        // 邮箱地址、邮编对比项、企业经营状态对比项
        if (cp == Constants.COMPANY_PROPERTY_ENTERPISE) {
            EmailCompareProperty emailsProp = EmailCompareProperty.build(PropertyEnum.ANNUAL_EMAILS.getCode(), baseModule, cmp != null ? cmp.getEmails() : null, "");
            result.add(emailsProp);

            PostalCodeCompareProperty postalCodeProp = PostalCodeCompareProperty.build(PropertyEnum.ANNUAL_POSTAL_CODE.getCode(), baseModule, cmp != null ? cmp.getPostalCode() : null, "");
            result.add(postalCodeProp);

            //将经营状态编码转换成中文
            String stdState = std.getOpstate();
            String cmpState = (cmp == null ? null : cmp.getOpstate());
            String stdStateDesc = (stdState == null ? null : OpStateEnum.getDescByCode(Integer.parseInt(stdState)));
            String cmpStateDesc = (cmpState == null ? null : OpStateEnum.getDescByCode(Integer.parseInt(cmpState)));;
            StringCompareProperty opstateProp = StringCompareProperty.build(PropertyEnum.ANNUAL_OPSTATE.getCode(), baseModule, stdStateDesc, cmp != null ? cmpStateDesc : null);
            result.add(opstateProp);
        }

        // 经营者名称、资金数额、主页经营活动对比项
        if (cp == Constants.COMPANY_PROPERTY_PERSONAL) {
            StringCompareProperty opName = StringCompareProperty.build(PropertyEnum.ANNUAL_OP_NAME.getCode(), baseModule, std.getOpstate(), cmp != null ? cmp.getOpName() : null);
            result.add(opName);

            NumberCompareProperty amountMon = NumberCompareProperty.build(PropertyEnum.ANNUAL_AMOUNT_MON.getCode(), baseModule, std.getAmountMon(), cmp != null ? cmp.getAmountMon() : null, "万元");
            result.add(amountMon);
        }

        if (cp == Constants.COMPANY_PROPERTY_NZ) {
            StringCompareProperty opActivity = StringCompareProperty.build(PropertyEnum.ANNUAL_OP_ACTIVITY.getCode(), baseModule, std.getOpActivity(), cmp != null ? cmp.getOpActivity() : null);
            result.add(opActivity);
        }

        return result;
    }

    @Override
    protected List<AnnualBaseStd> getStds(String nbxh) {
        AnnualBaseStdExample exam = new AnnualBaseStdExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return annualBaseStdDao.selectByExample(exam);
    }

    @Override
    protected List<AnnualBaseCmp> getCmps(String nbxh) {
        AnnualBaseCmpExample exam = new AnnualBaseCmpExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return annualBaseCmpDao.selectByExample(exam);
    }

}
