/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.common.util.PercentUtil;
import com.bbd.dao.ReportDao;
import com.bbd.service.IDictionaryService;
import com.bbd.service.IReportService;
import com.bbd.service.param.CompareReportVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 报表服务
 *
 * @author tjwang
 * @version $Id: ReportServiceImpl.java, v 0.1 2017/7/19 0019 16:33 tjwang Exp $
 */
@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportDao          reportDao;

    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 按地区分组统计
     * @see com.bbd.service.IReportService#queryDistrictExInfos()
     */
    @Override
    public List<CompareReportVo> queryDistrictExInfos() {
        Map<String, String> districtMap = dictionaryService.getDistrict();

        // 1.各区域异常企业总量
        List<Map<String, Object>> totalList = reportDao.queryDistrictExStatistics();
        Map<String, Integer> totalMap = getItemMap(totalList);
        // 2.各区域年报异常企业数量 
        List<Map<String, Object>> annualList = reportDao.queryDistrictAnnualExStatistics();
        Map<String, Integer> annualMap = getItemMap(annualList);
        // 3.各区域即时信息异常企业数量
        List<Map<String, Object>> insList = reportDao.queryDistrictInsExStatistics();
        Map<String, Integer> insMap = getItemMap(insList);        
        // 4.各区域两者都异常的企业数量
        List<Map<String, Object>> bothList = reportDao.queryDistrictBothExStatistics();
        Map<String, Integer> bothMap = getItemMap(bothList);
        // 5.各区域企业总量
        Map<String, Integer> percentMap = getDistrictCount();
        // 5.构建返回对象
        List<CompareReportVo> rs = getReportVos(districtMap, totalMap, annualMap, insMap, bothMap, percentMap);

        return rs;
    }

    /**
     * 按行业分组统计
     * @see com.bbd.service.IReportService#queryIndustryExInfos()
     */
    @Override
    public List<CompareReportVo> queryIndustryExInfos() {
        Map<String, String> industryMap = dictionaryService.getIndustry();

        List<Map<String, Object>> totalList = reportDao.queryIndustryExStatistics();
        Map<String, Integer> totalMap = getItemMap(totalList);
        List<Map<String, Object>> annualList = reportDao.queryIndustryAnnualExStatistics();
        Map<String, Integer> annualMap = getItemMap(annualList);
        List<Map<String, Object>> insList = reportDao.queryIndustryInsExStatistics();
        Map<String, Integer> insMap = getItemMap(insList);
        List<Map<String, Object>> bothList = reportDao.queryIndustryBothExStatistics();
        Map<String, Integer> bothMap = getItemMap(bothList);

        Map<String, Integer> percentMap = getIndustryCount();

        return getReportVos(industryMap, totalMap, annualMap, insMap, bothMap, percentMap);
    }

    /**
     * 按企业性质分组统计
     * @see com.bbd.service.IReportService#queryCompanyPropertyExInfos()
     */
    @Override
    public List<CompareReportVo> queryCompanyPropertyExInfos() {
        Map<String, String> propertyMap = dictionaryService.getCompanyPropertyItem();

        List<Map<String, Object>> totalList = reportDao.queryCompanyPropertyExStatistics();
        Map<String, Integer> totalMap = getItemMap(totalList);
        List<Map<String, Object>> annualList = reportDao.queryCompanyPropertyAnnualExStatistics();
        Map<String, Integer> annualMap = getItemMap(annualList);
        List<Map<String, Object>> insList = reportDao.queryCompanyPropertyInsExStatistics();
        Map<String, Integer> insMap = getItemMap(insList);
        List<Map<String, Object>> bothList = reportDao.queryCompanyPropertyBothExStatistics();
        Map<String, Integer> bothMap = getItemMap(bothList);

        // 计算占比
        List<CompareReportVo> rs = getReportVos(propertyMap, totalMap, annualMap, insMap, bothMap, null);
        calcPercentCompanyProperty(rs);
        return rs;
    }

    // 将list<Map> 转化为单个Map
    private Map<String, Integer> getItemMap(List<Map<String, Object>> params) {
        Map<String, Integer> map = Maps.newHashMap();
        params.forEach(p -> {
            String key = String.valueOf(p.get("item"));
            Long val = (Long) p.get("total");
            map.put(key, val.intValue());
        });
        return map;
    }

    // 将map转化为页面对象
    private List<CompareReportVo> getReportVos(Map<String, String> dicMap, 
                                               Map<String, Integer> totalMap, 
                                               Map<String, Integer> annualMap, 
                                               Map<String, Integer> insMap, 
                                               Map<String, Integer> bothMap,
                                               Map<String, Integer> percentMap) {
        List<CompareReportVo> result = Lists.newLinkedList();

        for (Map.Entry<String, String> entry : dicMap.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            CompareReportVo vo = new CompareReportVo();
            Integer total = totalMap.get(k);
            if (total == null) {
                total = 0;
            }
            Integer annual = annualMap.get(k);
            if (annual == null) {
                annual = 0;
            }
            Integer ins = insMap.get(k);
            if (ins == null) {
                ins = 0;
            }
            Integer both = bothMap.get(k);
            if(both == null) {
                both = 0;
            }
            String perc = null;
            String insPer = null;
            String annualPer = null;
            String bothPer = null;
            if (percentMap != null) {
                int value = percentMap.get(k) == null ? 0 : percentMap.get(k);
                perc = PercentUtil.calcIntPercent(value, total);
                insPer = PercentUtil.calcIntPercent(value, ins);
                annualPer = PercentUtil.calcIntPercent(value, annual);
                bothPer = PercentUtil.calcIntPercent(value, both);
            }
            vo.setItem(k);
            vo.setItemDesc(v);
            vo.setTotal(total);
            vo.setAnnualNum(annual);
            vo.setAnnualPer(annualPer);
            vo.setInsNum(ins);
            vo.setInsPer(insPer);
            vo.setBothNum(both);
            vo.setBothPer(bothPer);
            vo.setPercent(perc);
            result.add(vo);
        }

        return result;
    }

    // 计算按企业性质统计百分比占比
    private void calcPercentCompanyProperty(List<CompareReportVo> data) {
        if (data.size() > 0) {
            int[] values = new int[data.size()];
            int i = 0;
            for (CompareReportVo info : data) {
                values[i] = (int) info.getTotal();
                i++;
            }
            String[] percents = PercentUtil.calcPercents(values);
            i = 0;
            for (CompareReportVo info : data) {
                info.setPercent(percents[i]);
                i++;
            }
        }
    }

    // 查询各个区域企业数量
    private Map<String, Integer> getDistrictCount() {
        List<Map<String, Object>> disCount = reportDao.queryCompanyCountGroupDistrict();
        Map<String, Integer> rs = getItemMap(disCount);
        return rs;
    }

    // 查询各个行业企业数量
    private Map<String, Integer> getIndustryCount() {
        List<Map<String, Object>> disCount = reportDao.queryCompanyCountGroupIndustry();
        Map<String, Integer> rs = getItemMap(disCount);
        return rs;
    }

}
