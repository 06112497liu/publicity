/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.common.util.PercentUtil;
import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.dao.ReportDao;
import com.bbd.service.IDictionaryService;
import com.bbd.service.IReportService;
import com.bbd.service.param.CompareReportVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
    
    @Autowired
    private PubCompanyInfoDao companyInfoDao;

    /**
     * 按地区分组统计
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
    
    @Override
    public CompareReportVo queryWholeCity() {
        CompareReportVo rs = new CompareReportVo();
        int total = reportDao.queryWholeCount();
        int annual = reportDao.queryWholeAnnualExNum();
        int ins = reportDao.queryWholeInsExNum();
        int both = reportDao.queryWholeBothExNum();
        int exTotal = reportDao.queryWholeExNum();
        rs.setItem("5201");
        rs.setItemDesc("全市");
        rs.setAnnualNum(annual);
        rs.setAnnualPer(PercentUtil.calcIntPercent(total, annual));
        rs.setInsNum(ins);
        rs.setInsPer(PercentUtil.calcIntPercent(total, ins));
        rs.setBothNum(both);
        rs.setBothPer(PercentUtil.calcIntPercent(total, both));
        rs.setTotal(exTotal);
        rs.setPercent(PercentUtil.calcIntPercent(total, exTotal));
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

            Integer total = totalMap.get(k) == null ? 0 : totalMap.get(k);
            Integer annual = annualMap.get(k) == null ? 0 : annualMap.get(k);
            Integer ins = insMap.get(k) == null ? 0 : insMap.get(k);
            Integer both = bothMap.get(k) == null ? 0 : bothMap.get(k);

            String perc = null, insPer = null, annualPer = null, bothPer = null;
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
