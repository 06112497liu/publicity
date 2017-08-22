/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.*;
import com.bbd.domain.AnnualExDetail;
import com.bbd.domain.CompanyExItem;
import com.bbd.domain.CompanyExItemExample;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.service.compare.CompareProperty;
import com.bbd.service.compare.collector.AnnualPropertyCollector;
import com.bbd.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对比服务实现
 *
 * @author tjwang
 * @version $Id: CompareServiceImpl.java, v 0.1 2017/7/10 0010 17:14 tjwang Exp $
 */
@Service("annualCompareService")
public class AnnualCompareServiceImpl extends AbstractCompareService {

    @Autowired
    private AnnualExDetailDao annualExDetailDao;

    @Autowired
    private CompanyExItemDao companyExItemDao;

    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    @Autowired
    private CompareStatisticExtDao compareStatisticExtDao;

    @Autowired
    private ExDetailExtDao exDetailExtDao;

    @Autowired
    private List<AnnualPropertyCollector> collectors;

    protected List<CompareProperty> getCompareProperties(PubCompanyInfo c) {
        List<CompareProperty> props = Lists.newArrayList();

        collectors.forEach(p -> props.addAll(p.getCompareProperties(c)));

        return props;
    }

    @Override
    protected void addExDetail(PubCompanyInfo c, CompareProperty p, int r) {
        AnnualExDetail detail = buildAnnualExDetail(c, p);
        detail.setExType(r);
        annualExDetailDao.insert(detail);
    }

    /**
     * 统计总信息
     *
     * @param itemCount
     */
    @Override
    protected void updateCompareStatisticsCount(int itemCount, boolean flag) {
        long id = 1L;
        compareStatisticExtDao.updateAnnualCount(id, itemCount, flag);
    }

    /**
     * 创建或更新企业年报异常项统计信息
     */
    @Override
    protected void createOrUpdateCompanyExItem(PubCompanyInfo c, int num) {
        CompanyExItemExample exam = new CompanyExItemExample();
        exam.createCriteria().andNbxhEqualTo(c.getNbxh());

        int exTypes = getAnnualExTypes(c);
        int exModules = getAnnualExModules(c);
        List<Integer> ds = exDetailExtDao.selectAnnualExModules(c.getNbxh());
        int exModulesNum = ds.size();
        int n = companyExItemExtDao.updateAnnualInfo(c.getNbxh(), num, exTypes, exModules, exModulesNum);
        if (n > 0) {
            return;
        }

        Date now = new Date();
        CompanyExItem item = new CompanyExItem();
        item.setNbxh(c.getNbxh());
        item.setRegion(c.getRegion());
        item.setPrimaryIndustry(c.getPrimaryIndustry());
        item.setCompanyName(c.getCompanyName());
        item.setCompanyProperty(c.getCompanyProperty());
        item.setAnnualNum(num);
        item.setAnnualCmpTime(now);
        item.setNum(num);
        item.setAnnualExTypes(exTypes);
        item.setAnnualExModules(exModules);
        item.setGmtCreate(now);
        companyExItemDao.insertSelective(item);
    }

    private int getAnnualExTypes(PubCompanyInfo c) {
        String nbxh = c.getNbxh();
        List<Integer> ds = exDetailExtDao.selectAnnualExTypes(nbxh);
        return ds.stream().collect(Collectors.summingInt(value -> value));
    }

    private int getAnnualExModules(PubCompanyInfo c) {
        String nbxh = c.getNbxh();
        List<Integer> ds = exDetailExtDao.selectAnnualExModules(nbxh);
        return ds.stream().collect(Collectors.summingInt(value -> value));
    }

    private AnnualExDetail buildAnnualExDetail(PubCompanyInfo c, CompareProperty prop) {
        Date now = new Date();

        AnnualExDetail annualExDetail = new AnnualExDetail();
        annualExDetail.setNbxh(c.getNbxh());
        annualExDetail.setRegion(c.getRegion());
        annualExDetail.setPropName(prop.getName());
        annualExDetail.setSubmodule(prop.getSubmodule());
        annualExDetail.setCompanyName(c.getCompanyName());
        annualExDetail.setPrimaryIndustry(c.getPrimaryIndustry());
        annualExDetail.setExType(0);
        annualExDetail.setCompareTime(now);
        if(prop.getBase() instanceof Date) {
            String base = DateUtil.formatDateByPatten((Date)prop.getBase(), "yyyy-MM-dd HH:mm:ss");
            annualExDetail.setBase(base);
        } else {
            annualExDetail.setBase(String.valueOf(prop.getBase()));            
        }
        if(prop.getOther() instanceof Date) {
            String other = DateUtil.formatDateByPatten((Date)prop.getOther(), "yyyy-MM-dd HH:mm:ss");
            annualExDetail.setOther(other);
        } else {
            annualExDetail.setOther(String.valueOf(prop.getOther()));            
        }
        annualExDetail.setUnit(prop.getUnit());
        annualExDetail.setGmtCreate(now);

        return annualExDetail;
    }


    @Override
    protected void updateExIncreasedAndDecreased(long taskId, String nbxh, boolean isException) {
        compareTaskService.updateExIncreasedAndDecreased(1, taskId, nbxh, isException);
    }

       

}
