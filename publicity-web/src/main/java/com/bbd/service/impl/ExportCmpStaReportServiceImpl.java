
/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.impl;

import com.bbd.common.properties.ReportProperties;
import com.bbd.enums.DistrictEnum;
import com.bbd.report.ReportEngine;
import com.bbd.report.enums.ElementEnum;
import com.bbd.report.enums.ExportEnum;
import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.report.model.TextDataModel;
import com.bbd.report.util.TextUtil;
import com.bbd.service.IExportCmpStaReportService;
import com.bbd.service.IReportService;
import com.bbd.service.param.CompareReportVo;
import com.bbd.service.param.report.CmpStaReportPropVo;
import com.bbd.service.param.report.CmpStaReportVo;
import com.bbd.service.param.report.Title;
import com.bbd.util.NumUtils;
import com.bbd.util.ReportUtils;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 比对统计分析报告服务层
 *
 * @author liuweibo
 * @version $Id: ExportCmpStaReportService.java, v 0.1 2017年8月24日 下午4:13:32 liuweibo Exp $
 */
@Service
public class ExportCmpStaReportServiceImpl implements IExportCmpStaReportService {

    private static final Logger           logger = LoggerFactory.getLogger(ExportReportExDetailServiceImpl.class);
    private static final Optional<String> source = Optional.of("report/StatisticalReport.prpt");
    @Autowired
    private IReportService   reportService;
    @Autowired
    private ReportProperties properties;


    /**
     * 对比统计分析报告
     */
    @Override
    public void cmpStaReport(OutputStream out) {

        Object[][] data1 = ReportUtils.buildTwoArray(getDistrictReport(1));
        // 公示异常企业区域列表分布
        ReportElementModel eleModel1 = buildReportElementModel("RegionDistribute", "RegionDistributionData", data1, Title.nameValueTitle);
        // 公示异常企业区域条形图
        ReportElementModel eleModel2 = buildReportElementModel("RegionDistributeMap", "RegionDistributeMapData", data1, Title.nameValueTitle);
        // 分区域条形图
        Map<String, Object[][]> areaData = getArea();
        List<ReportElementModel> areaReportModel = Lists.newArrayList();
        for (Map.Entry<String, Object[][]> entry : areaData.entrySet()) {
            String key = entry.getKey();
            Object[][] o = entry.getValue();
            ReportElementModel rm = buildReportElementModel(key, key, o, Title.nameValueTitle);
            areaReportModel.add(rm);
        }
        // 分区占比排行
        Object[][] data3 = ReportUtils.buildTwoArray(getDistrictReport(2));
        ReportElementModel eleModel3 = buildReportElementModel("DistrictRatio", "DistrictRatio", data3, Title.nameValueTitle);

        // 行业占比排行
        Object[][] data4 = ReportUtils.buildTwoArray(getIndustryReport());
        ReportElementModel eleModel4 = buildReportElementModel("IndustryRatio", "IndustryRatio", data4, Title.nameValueTitle);

        // 企业性质饼状图
        Object[][] data5 = ReportUtils.buildTwoArray(getCompanyPropertyReport());
        ReportElementModel eleModel5 = buildReportElementModel("CompanyProp", "CompanyProp", data5, Title.nameValuePerTitle);

        ArrayListMultimap<StructureEnum, ReportElementModel> elements = buildArrayListMultimap(eleModel1, eleModel2, eleModel3, eleModel4, eleModel5);
        List<ReportElementModel> lists = buildReportElementString(properties);
        areaReportModel.addAll(lists);
        for (ReportElementModel e : areaReportModel) {
            elements.put(StructureEnum.REPORT_HEADER, e);
        }
        ReportEngine re = new ReportEngine();
        re.generateReport(source, elements, null, ExportEnum.PDF, out);
    }

    private ArrayListMultimap<StructureEnum, ReportElementModel> buildArrayListMultimap(ReportElementModel... params) {
        ArrayListMultimap<StructureEnum, ReportElementModel> list = ArrayListMultimap.create();
        for (ReportElementModel model : params) {
            list.put(StructureEnum.REPORT_HEADER, model);
        }
        return list;
    }

    // TableDataModel --> ReportElementModel
    private <T> ReportElementModel buildReportElementModel(String name, String dataName, Object[][] arrays, Object[] title) {
        ReportElementModel model = new ReportElementModel();
        TableDataModel dataModel = new TableDataModel(arrays, title);
        model.setName(name);
        model.setDataName(dataName);
        model.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        model.setDataModel(dataModel);
        return model;
    }

    // TextDataModel --> ReportElementModel
    private ReportElementModel buildReportElemtModel(String name, Optional<String> source) {
        ReportElementModel model = new ReportElementModel();
        TextDataModel dataModel = new TextDataModel(source);
        model.setName(name);
        model.setDataName("value");
        model.setElementEnum(ElementEnum.LABEL);
        model.setDataModel(dataModel);
        return model;
    }

    // 获取贵阳市所有区域的公示异常企业数量
    private List<CmpStaReportVo> getDistrictReport(int type) {
        List<CmpStaReportVo> rs = Lists.newArrayList();
        List<CompareReportVo> ds = reportService.queryDistrictExInfos();
        sortList(ds, 1);
        CompareReportVo whole = reportService.queryWholeCity();
        ds.add(0, whole);
        ds.forEach(p -> {
            CmpStaReportVo vo = new CmpStaReportVo();
            vo.setItem(p.getItemDesc());
            if (type == 1)
                vo.setItemvalue(p.getTotal());
            if (type == 2)
                vo.setItemvalue(NumUtils.trimPer(p.getPercent()));
            rs.add(vo);
        });
        return rs;
    }

    // 区域分组
    private Map<String, Object[][]> getArea() {
        String[] strs = new String[]{"annual", "ins", "both", "total"};
        Map<String, Object[][]> rs = Maps.newHashMap();
        Map<String, List<CompareReportVo>> temp = buildArea();
        for (Map.Entry<String, List<CompareReportVo>> entry : temp.entrySet()) {
            List<CmpStaReportVo> areaList = Lists.newArrayList();
            String key = entry.getKey();
            CompareReportVo v = entry.getValue().get(0);
            for (String s : strs) {
                CmpStaReportVo info = new CmpStaReportVo();
                if (s.equals("annual")) {
                    info.setItem("年报异常企业" + v.getAnnualNum() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getAnnualPer()));
                } else if (s.equals("ins")) {
                    info.setItem("及时信息异常企业" + v.getInsNum() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getInsPer()));
                } else if (s.equals("both")) {
                    info.setItem("两者均异常企业" + v.getBothNum() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getBothPer()));
                } else if (s.equals("total")) {
                    info.setItem("异常企业总量" + v.getTotal() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getPercent()));
                }
                areaList.add(info);
            }
            rs.put(key, ReportUtils.buildTwoArray(areaList));
        }
        return rs;
    }

    private Map<String, List<CompareReportVo>> buildArea() {
        List<CompareReportVo> list = reportService.queryDistrictExInfos();
        CompareReportVo whole = reportService.queryWholeCity();
        list.add(whole);
        Map<String, List<CompareReportVo>> map = list.stream().collect(Collectors.groupingBy(CompareReportVo::getItem));
        return map;
    }

    private List<ReportElementModel> buildReportElementString(ReportProperties properties) {
        List<ReportElementModel> rs = Lists.newArrayList();
        Map<String, String> beanMap = Maps.newHashMap();
        try {
            beanMap = BeanUtils.describe(properties);
        } catch (Exception e) {
            logger.info("对象转map失败", e.getMessage());
        }
        Map<String, List<CompareReportVo>> map = buildArea();
        for (Map.Entry<String, List<CompareReportVo>> entry : map.entrySet()) {
            String key = entry.getKey();
            CompareReportVo vo = entry.getValue().get(0);
            String value = DistrictEnum.getDescByCode(key);
            String resource = beanMap.get(value);
            List<Object> replace = Lists.newArrayList(
                    String.valueOf(vo.getTotal()),
                    vo.getPercent(),
                    String.valueOf(vo.getAnnualNum()),
                    vo.getAnnualPer(),
                    String.valueOf(vo.getInsNum()),
                    vo.getInsPer(),
                    String.valueOf(vo.getBothNum()),
                    vo.getBothPer());
            String result = TextUtil.replaceParams(resource, replace);
            ReportElementModel reportModel = buildReportElemtModel(value, Optional.fromNullable(result));
            rs.add(reportModel);
        }
        return rs;
    }


    // 获取贵阳市公示异常企业行业分布
    private List<CmpStaReportVo> getIndustryReport() {
        List<CmpStaReportVo> rs = Lists.newArrayList();
        List<CompareReportVo> ds = reportService.queryIndustryExInfos();
        sortList(ds, 2);
        ds.forEach(p -> {
            CmpStaReportVo vo = new CmpStaReportVo();
            vo.setItem(p.getItemDesc());
            vo.setItemvalue(NumUtils.trimPer(p.getPercent()));
            rs.add(vo);
        });
        return rs;
    }

    // 获取贵阳市公示异常企业企业性质分布
    private List<CmpStaReportPropVo> getCompanyPropertyReport() {
        List<CmpStaReportPropVo> rs = Lists.newArrayList();
        List<CompareReportVo> ds = reportService.queryCompanyPropertyExInfos();
        sortList(ds, 2);
        ds.forEach(p -> {
            CmpStaReportPropVo vo = new CmpStaReportPropVo();
            vo.setItem(p.getItemDesc() + "" + p.getTotal() + "户，占公示异常企业" + NumUtils.trimPer(p.getPercent()) + "%");
            vo.setNum(p.getTotal());
            vo.setPer(NumUtils.trimPer(p.getPercent()));
            rs.add(vo);
        });
        return rs;
    }

    // 结果按百分比排序
    private void sortList(List<CompareReportVo> data, Integer sortType) {
        if (1 == sortType) {
            data.sort((x, y) -> {
                return Integer.compare(y.getTotal(), x.getTotal());
            });
        }
        if (2 == sortType) {
            data.sort((x, y) -> {
                Double v1 = Double.parseDouble(x.getPercent().replace("%", ""));
                Double v2 = Double.parseDouble(y.getPercent().replace("%", ""));
                return v2.compareTo(v1);
            });
        }
    }

}
