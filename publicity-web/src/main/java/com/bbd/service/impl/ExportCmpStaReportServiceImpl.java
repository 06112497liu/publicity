
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

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
import com.bbd.service.param.CmpStaReportVo;
import com.bbd.service.param.CompareReportVo;
import com.bbd.util.NumUtils;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

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
    
    private static final Optional source = Optional.of("report/StatisticalReport.prpt");

    /**
     * 对比统计分析报告
     */
    @Override
    public void cmpStaReport(OutputStream out) {

        ReportElementModel eleModel1 = new ReportElementModel(); // 公示异常企业区域列表分布
        ReportElementModel eleModel2 = new ReportElementModel(); // 公示异常企业区域条形图
        List<CmpStaReportVo> list1 = getDistrictReport();
        Object[][] data1 = buildTwoArray(list1);
        TableDataModel dataModel1 = new TableDataModel(data1, title1);
        
        eleModel1.setName("RegionDistribute");
        eleModel1.setDataName("RegionDistributionData");
        eleModel1.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel1.setDataModel(dataModel1);
        
        eleModel2.setName("RegionDistributeMap");
        eleModel2.setDataName("RegionDistributeMapData");
        eleModel2.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        eleModel2.setDataModel(dataModel1);
        
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = ArrayListMultimap.create();
        elements.put(StructureEnum.REPORT_HEADER, eleModel1);
        elements.put(StructureEnum.REPORT_HEADER, eleModel2);
        
        ReportEngine re = new ReportEngine();
        re.generateReport(source, elements, null, ExportEnum.PDF, out);
    }
    
    // 获取贵阳市所有区域的公示异常企业数量
    private List<CmpStaReportVo> getDistrictReport() {
        List<CmpStaReportVo> rs = Lists.newArrayList();
        List<CompareReportVo> ds = reportService.queryDistrictExInfos();
        sortList(ds, 1);
        CompareReportVo whole = reportService.queryWholeCity();
        ds.add(0, whole);
        ds.forEach(p -> {
            CmpStaReportVo vo = new CmpStaReportVo();
            vo.setItem(p.getItemDesc());
            vo.setItemvalue(p.getTotal());
            rs.add(vo);
        });
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
    private List<CmpStaReportVo> getCompanyPropertyReport() {
        List<CmpStaReportVo> rs = Lists.newArrayList();
        List<CompareReportVo> ds = reportService.queryCompanyPropertyExInfos();
        sortList(ds, 2);
        ds.forEach(p -> {
            CmpStaReportVo vo = new CmpStaReportVo();
            vo.setItem(p.getItemDesc());
            vo.setItemvalue(NumUtils.trimPer(p.getPercent()));
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

