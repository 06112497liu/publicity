/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.*;
import com.bbd.domain.CompanyExItem;
import com.bbd.domain.CompanyExItemExample;
import com.bbd.domain.InstantlyExDetail;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.service.compare.CompareProperty;
import com.bbd.service.compare.collector.InstantlyPropertyCollector;
import com.bbd.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tjwang
 * @version $Id: InstantlyCompareServiceImpl.java, v 0.1 2017/7/17 0017 14:16 tjwang Exp $
 */
@Service("instantlyCompareService")
public class InstantlyCompareServiceImpl extends AbstractCompareService {

    @Autowired
    private InstantlyExDetailDao instantlyExDetailDao;

    @Autowired
    private CompanyExItemDao companyExItemDao;

    @Autowired
    private CompanyExItemExtDao companyExItemExtDao;

    @Autowired
    private CompareStatisticExtDao compareStatisticExtDao;

    @Autowired
    private ExDetailExtDao exDetailExtDao;

    @Autowired
    private List<InstantlyPropertyCollector> collectors;

    @Override
    protected List<CompareProperty> getCompareProperties(PubCompanyInfo c) {
        List<CompareProperty> props = Lists.newArrayList();

        collectors.forEach(p -> props.addAll(p.getCompareProperties(c)));

        return props;
    }


    @Override
    protected void addExDetail(PubCompanyInfo c, CompareProperty p, int r) {
        InstantlyExDetail detail = buildInstantlyExDetail(c, p);
        detail.setExType(r);
        instantlyExDetailDao.insert(detail);
    }

    private InstantlyExDetail buildInstantlyExDetail(PubCompanyInfo c, CompareProperty prop) {
        Date now = new Date();

        InstantlyExDetail ex = new InstantlyExDetail();
        ex.setNbxh(c.getNbxh());
        ex.setRegion(c.getRegion());
        ex.setPropName(prop.getName());
        ex.setSubmodule(prop.getSubmodule());
        ex.setCompanyName(c.getCompanyName());
        ex.setPrimaryIndustry(c.getPrimaryIndustry());
        ex.setExType(0);
        ex.setCompareTime(now);
        if(prop.getBase() instanceof Date) {
            String base = DateUtil.formatDateByPatten((Date)prop.getBase(), "yyyy-MM-dd HH:mm:ss");
            ex.setBase(base);
        } else {
            ex.setBase(String.valueOf(prop.getBase()));            
        }
        if(prop.getOther() instanceof Date) {
            String other = DateUtil.formatDateByPatten((Date)prop.getOther(), "yyyy-MM-dd HH:mm:ss");
            ex.setOther(other);
        } else {
            ex.setOther(String.valueOf(prop.getOther()));            
        }
        ex.setUnit(prop.getUnit());
        ex.setGmtCreate(now);

        return ex;
    }

    @Override
    protected void createOrUpdateCompanyExItem(PubCompanyInfo c, int num) {
        CompanyExItemExample exam = new CompanyExItemExample();
        exam.createCriteria().andNbxhEqualTo(c.getNbxh());

        int exTypes = getInstantlyExTypes(c);
        int exModules = getIntantlyExModules(c);
        int n = companyExItemExtDao.updateInstantlyInfo(c.getNbxh(), num, exTypes, exModules);
        if (n > 0) {
            return;
        }

        Date now = new Date();
        CompanyExItem item = new CompanyExItem();
        item.setNbxh(c.getNbxh());
        item.setRegion(c.getRegion());
        item.setPrimaryIndustry(c.getPrimaryIndustry());
        item.setCompanyName(c.getCompanyName());
        item.setInstantlyNum(num);
        item.setCompanyProperty(c.getCompanyProperty());
        item.setInstantlyCmpTime(now);
        item.setNum(num);
        item.setInsExTypes(exTypes);
        item.setInsExModules(exModules);
        item.setGmtCreate(now);
        companyExItemDao.insertSelective(item);
    }

    private int getInstantlyExTypes(PubCompanyInfo c) {
        String nbxh = c.getNbxh();
        List<Integer> ds = exDetailExtDao.selectInstantlyExTypes(nbxh);
        return ds.stream().collect(Collectors.summingInt(value -> value));
    }

    private int getIntantlyExModules(PubCompanyInfo c) {
        String nbxh = c.getNbxh();
        List<Integer> ds = exDetailExtDao.selectInstantlyExModules(nbxh);
        return ds.stream().collect(Collectors.summingInt(value -> value));
    }

    @Override
    protected void updateCompareStatisticsCount(int itemCount, boolean flag) {
        long id = 1L;
        compareStatisticExtDao.updateInstantlyCount(id, itemCount, flag);
    }

    @Override
    protected void updateExIncreasedAndDecreased(long taskId, String nbxh, boolean isException) {
        compareTaskService.updateExIncreasedAndDecreased(2, taskId, nbxh, isException);
    }

}
