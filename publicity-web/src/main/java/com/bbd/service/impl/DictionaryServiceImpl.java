
/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.dao.CompanyIndustryInfoDao;
import com.bbd.dao.CompanyTypeMappingInfoDao;
import com.bbd.dao.DistrictInfoDao;
import com.bbd.dao.LicenseFileTypeInfoDao;
import com.bbd.domain.CompanyIndustryInfo;
import com.bbd.domain.CompanyIndustryInfoExample;
import com.bbd.domain.CompanyTypeMappingInfo;
import com.bbd.domain.DistrictInfo;
import com.bbd.domain.DistrictInfoExample;
import com.bbd.domain.LicenseFileTypeInfo;
import com.bbd.service.IDictionaryService;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.InstantlyModule;
import com.google.common.collect.Maps;

/**
 * @author liuweibo
 * @version $Id: DictionaryServiceImpl.java, v 0.1 2017年7月20日 上午10:22:30 liuweibo Exp $
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Autowired
    private CompanyIndustryInfoDao industryInfoDao;

    @Autowired
    private DistrictInfoDao districtInfoDao;
    
    @Autowired
    private CompanyTypeMappingInfoDao typeMappingInfoDao;
    
    @Autowired
    private LicenseFileTypeInfoDao fileTypeInfoDao;

    /**
     * 获取一级行业字典
     *
     * @see com.bbd.service.IDictionaryService#getIndustry()
     */
    @Override
    public Map<String, String> getIndustry() {
        CompanyIndustryInfoExample example = new CompanyIndustryInfoExample();
        List<CompanyIndustryInfo> ds = industryInfoDao.selectByExample(example);
        Map<String, String> rs = ds.stream().collect(Collectors.toMap(CompanyIndustryInfo::getCode, CompanyIndustryInfo::getName));
        return rs;
    }

    /**
     * 获取区域字典
     *
     * @see com.bbd.service.IDictionaryService#getDistrict()
     */
    @Override
    public Map<String, String> getDistrict() {
        Map<String, String> rs = Maps.newHashMap();
        DistrictInfoExample example = new DistrictInfoExample();
        example.createCriteria().andUpCodeEqualTo("5201");
        List<DistrictInfo> ds = districtInfoDao.selectByExample(example);
        ds.forEach(
            p -> {
                String k = String.valueOf(p.getCode());
                String v = p.getName();
                rs.put(k, v);
            }
        );
        return rs;
    }

    /**
     * 获取年报信息对比项数据字典
     *
     * @see com.bbd.service.IDictionaryService#getAnnualItem()
     */
    @Override
    public Map<String, String> getAnnualItem() {
        Map<String, String> rs = Maps.newHashMap();
        AnnualModule[] ds = AnnualModule.values();
        for (AnnualModule info : ds) {
            rs.put(String.valueOf(info.getCode()), info.getDesc());
        }
        return rs;
    }

    /**
     * 即时信息对比项数据字典
     *
     * @see com.bbd.service.IDictionaryService#getInsItem()
     */
    @Override
    public Map<String, String> getInsItem() {
        Map<String, String> rs = Maps.newHashMap();
        InstantlyModule[] ds = InstantlyModule.values();
        for (InstantlyModule info : ds) {
            rs.put(String.valueOf(info.getCode()), info.getDesc());
        }
        return rs;
    }

    /**
     * 企业类型数据字典
     * @see com.bbd.service.IDictionaryService#getCompanyItem() 
     */
    @Override
    public Map<String, String> getCompanyPropertyItem() {      
        Map<String, String> rs = Maps.newHashMap();
        List<CompanyTypeMappingInfo> ds = typeMappingInfoDao.selectByExample(null);      
        ds.forEach(
            p -> {
                String k = String.valueOf(p.getCompanyType());
                String v = p.getDescription();
                rs.put(k, v);
            }
        );
        return rs;
    }

    /**
     * 行政许可文件名称类型字典表
     * @see com.bbd.service.IDictionaryService#getFileTypeItem() 
     */
    @Override
    public Map<String, String> getFileTypeItem() {
        Map<String, String> rs = Maps.newHashMap();
        List<LicenseFileTypeInfo> ds = fileTypeInfoDao.selectByExample(null);
        rs = ds.stream().collect(Collectors.toMap(LicenseFileTypeInfo::getCode, LicenseFileTypeInfo::getName));
        return rs;
    }
}

