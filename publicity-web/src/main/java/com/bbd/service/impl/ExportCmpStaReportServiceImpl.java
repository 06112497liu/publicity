
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.report.ReportEngine;
import com.bbd.report.enums.ElementEnum;
import com.bbd.report.enums.ExportEnum;
import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.service.IExportCmpStaReportService;
import com.bbd.service.IReportService;
import com.bbd.service.param.CompareReportVo;
import com.bbd.service.param.report.CmpStaReportPropVo;
import com.bbd.service.param.report.CmpStaReportVo;
import com.bbd.util.NumUtils;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/** 
 * 比对统计分析报告服务层
 * @author liuweibo 
 * @version $Id: ExportCmpStaReportService.java, v 0.1 2017年8月24日 下午4:13:32 liuweibo Exp $ 
 */
@Service
public class ExportCmpStaReportServiceImpl implements IExportCmpStaReportService {
    
    private static final Logger logger = LoggerFactory.getLogger(ExportReportExDetailServiceImpl.class);
    
    @Autowired
    private IReportService reportService;
    
    private static final Object[] title1 = new Object[]{"item", "itemValue"};
    
    private static final Object[] title2 = new Object[]{"item", "num", "per"};
    
    private static final Optional<String> source = Optional.of("report/StatisticalReport.prpt");

    /**
     * 对比统计分析报告
     */
    @Override
    public void cmpStaReport(OutputStream out) {
        
        // 报告元素集合
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = ArrayListMultimap.create();
        
        ReportElementModel eleModel1 = new ReportElementModel(); // 公示异常企业区域列表分布
        ReportElementModel eleModel2 = new ReportElementModel(); // 公示异常企业区域条形图
        Object[][] data1 = buildTwoArray(getDistrictReport(1));
        TableDataModel dataModel1 = new TableDataModel(data1, title1);
        
        eleModel1.setName("RegionDistribute");
        eleModel1.setDataName("RegionDistributionData");
        eleModel1.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel1.setDataModel(dataModel1);
        
        eleModel2.setName("RegionDistributeMap");
        eleModel2.setDataName("RegionDistributeMapData");
        eleModel2.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel2.setDataModel(dataModel1);
        
        // 分区域条形图
        Map<String, Object[][]> areaData = getArea();
        List<ReportElementModel> areaReportModel = Lists.newArrayList();
        for(Map.Entry<String, Object[][]> entry : areaData.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            Object[][] o = entry.getValue();
            ReportElementModel rm = new ReportElementModel();
            TableDataModel tm = new TableDataModel(o, title1);
            rm.setName(key);
            rm.setDataName(key);
            rm.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
            rm.setDataModel(tm);
            areaReportModel.add(rm);
        }
        
        // 分区占比排行
        ReportElementModel eleModel3 = new ReportElementModel();
        Object[][] data3 = buildTwoArray(getDistrictReport(2));
        TableDataModel model3 = new TableDataModel(data3, title1);
        eleModel3.setName("DistrictRatio");
        eleModel3.setDataName("DistrictRatio");
        eleModel3.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel3.setDataModel(model3);
        
        // 行业占比排行
        ReportElementModel eleModel4 = new ReportElementModel();
        Object[][] data4 = buildTwoArray(getIndustryReport());
        TableDataModel model4 = new TableDataModel(data4, title1);
        eleModel4.setName("IndustryRatio");
        eleModel4.setDataName("IndustryRatio");
        eleModel4.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel4.setDataModel(model4);
        
        // 企业性质饼状图
        ReportElementModel eleModel5 = new ReportElementModel();
        Object[][] data5 = buildTwoArray(getCompanyPropertyReport());
        TableDataModel model5 = new TableDataModel(data5, title2);
        eleModel5.setName("CompanyProp");
        eleModel5.setDataName("CompanyProp");
        eleModel5.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel5.setDataModel(model5);
        
        
        elements.put(StructureEnum.REPORT_HEADER, eleModel1);
        elements.put(StructureEnum.REPORT_HEADER, eleModel2);
        for(ReportElementModel e : areaReportModel) {
            elements.put(StructureEnum.REPORT_HEADER, e);
        }
        elements.put(StructureEnum.REPORT_HEADER, eleModel3);
        elements.put(StructureEnum.REPORT_HEADER, eleModel4);
        elements.put(StructureEnum.REPORT_HEADER, eleModel5);
        
        ReportEngine re = new ReportEngine();
        re.generateReport(source, elements, null, ExportEnum.PDF, out);
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
            if(type == 1) vo.setItemvalue(p.getTotal());
            if(type ==2 ) vo.setItemvalue(NumUtils.trimPer(p.getPercent()));
            rs.add(vo);
        });
        return rs;
    }
    
    // 区域分组
    private Map<String, Object[][]> getArea() {
        String[] strs = new String[]{"annual", "ins", "both", "total"};
        Map<String, Object[][]> rs = Maps.newHashMap();
        List<CompareReportVo> list = reportService.queryDistrictExInfos();
        CompareReportVo whole = reportService.queryWholeCity();
        list.add(whole);
        Map<String, List<CompareReportVo>> temp = list.stream().collect(Collectors.groupingBy(CompareReportVo::getItem));
        for(Map.Entry<String, List<CompareReportVo>> entry : temp.entrySet()) {
            List<CmpStaReportVo> areaList = Lists.newArrayList();
            String key = entry.getKey();
            CompareReportVo v = entry.getValue().get(0);
            for (String s : strs) {
                CmpStaReportVo info = new CmpStaReportVo();
                if(s.equals("annual")) {
                    info.setItem("年报异常企业" + v.getAnnualNum() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getAnnualPer()));
                } else if(s.equals("ins")) {
                    info.setItem("及时信息异常企业" + v.getInsNum() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getInsPer()));
                } else if(s.equals("both")) {
                    info.setItem("两者均异常企业" + v.getBothNum() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getBothPer()));
                } else if(s.equals("total")) {
                    info.setItem("异常企业总量" + v.getTotal() + "户");
                    info.setItemvalue(NumUtils.trimPer(v.getPercent()));
                }
                areaList.add(info);
            }
            rs.put(key, buildTwoArray(areaList));
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
            vo.setItem(p.getItemDesc() + "" + p.getTotal() + "户，占比所有公示异常企业" + NumUtils.trimPer(p.getPercent()) + "%");
            vo.setNum(p.getTotal());
            vo.setPer(NumUtils.trimPer(p.getPercent()));
            rs.add(vo);
        });
        return rs;
    }
    
    // 结果按百分比排序
    private void sortList(List<CompareReportVo> data, Integer sortType) {
        if(1 == sortType) {
            data.sort((x, y) -> {
                return Integer.compare(y.getTotal(), x.getTotal());
            });
        }
        if(2 == sortType) {
            data.sort((x, y) -> {
                Double v1 = Double.parseDouble(x.getPercent().replace("%", ""));
                Double v2 = Double.parseDouble(y.getPercent().replace("%", ""));
                return v2.compareTo(v1);
            });
        }
    }
    
    // 构建二维数组
    private <T> Object[][] buildTwoArray(List<T> datas) {
        
        Integer rows = datas.size();
        if(rows == 0) {
            return null;
        }
        
        Field[] declaredFields = datas.get(0).getClass().getDeclaredFields();
        Integer columns = declaredFields.length;
        
        Object[][] rs = new Object[rows][columns];
        
        for (int i = 0; i < rows; i++) {            
            for (int j = 0; j < columns; j++) {
                declaredFields[j].setAccessible(true);
                try {
                    rs[i][j] = declaredFields[j].get(datas.get(i));
                } catch (IllegalArgumentException e) {
                    logger.error("", e);
                } catch (IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }
        return rs;
    }

}

