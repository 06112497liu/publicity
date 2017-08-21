/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller;

import com.bbd.service.IReportService;
import com.bbd.service.param.CompareReportVo;
import com.bbd.util.BigDecimalUtil;
import com.bean.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tjwang
 * @version $Id: CompareReportController.java, v 0.1 2017/7/19 0019 16:31 tjwang Exp $
 */
@RestController
@RequestMapping("/cmp/report")
@Api(description = "对比统计分析")
public class CompareReportController {

    @Autowired
    private IReportService reportService;

    @ApiOperation(value = "查询公示异常企业地图分布、异常分类地区占比、分区占比排行", httpMethod = "GET", response = CompareReportVo.class)
    @RequestMapping(value = "/distict.do", method = RequestMethod.GET)
    public RestResult getDistrictReport() {
        List<CompareReportVo> ds = reportService.queryDistrictExInfos();
        sortList(ds);
        CompareReportVo whole = getWholeCityStatistics(ds);
        ds.add(0, whole);
        return RestResult.ok(ds);
    }

    @ApiOperation(value = "查询公示异常企业一级行业分布", httpMethod = "GET", response = CompareReportVo.class)
    @RequestMapping(value = "/industry.do", method = RequestMethod.GET)
    public RestResult getIndustryReport() {
        List<CompareReportVo> ds = reportService.queryIndustryExInfos();
        sortList(ds);
        return RestResult.ok(ds);
    }

    @ApiOperation(value = "查询公示异常企业分类", httpMethod = "GET", response = CompareReportVo.class)
    @RequestMapping(value = "/compro.do", method = RequestMethod.GET)
    public RestResult getCompanyPropertyReport() {
        List<CompareReportVo> ds = reportService.queryCompanyPropertyExInfos();
        sortList(ds);
        return RestResult.ok(ds);
    }

    public RestResult exportCompareReport() {
        String result = "";
        return RestResult.ok(result);
    }

    // 结果按百分比排序
    private void sortList(List<CompareReportVo> data) {
        data.sort((x, y) -> {
            Double v1 = Double.parseDouble(x.getPercent().replace("%", ""));
            Double v2 = Double.parseDouble(y.getPercent().replace("%", ""));
            return v2.compareTo(v1);
        });
    }

    // 补全贵阳市的数据
    private CompareReportVo getWholeCityStatistics(List<CompareReportVo> data) {
        CompareReportVo vo = new CompareReportVo();
        int total = 0;
        int annualNum = 0;
        int insNum = 0;
        int bothNum = 0;
        double insPer = 0.0;
        double annualPer = 0.0;
        double bothPer = 0.0;
        double percent = 0.0;
        for (CompareReportVo info : data) {
            total += info.getTotal();
            annualNum += info.getAnnualNum();
            insNum += info.getInsNum();
            bothNum += info.getBothNum();
            //百分比计算
            String insPerStr = info.getInsPer().replace("%", "");
            insPer = BigDecimalUtil.add(insPer, Double.parseDouble(insPerStr));            
            String annualPerStr = info.getAnnualPer().replace("%", "");
            annualPer = BigDecimalUtil.add(annualPer, Double.parseDouble(annualPerStr));
            String bothPerStr = info.getBothPer().replace("%", "");
            bothPer = BigDecimalUtil.add(bothPer, Double.parseDouble(bothPerStr));
            String percentStr = info.getPercent().replace("%", "");
            percent = BigDecimalUtil.add(percent, Double.parseDouble(percentStr));
        }
        vo.setItem("5201");
        vo.setItemDesc("全市");
        vo.setTotal(total);
        vo.setAnnualNum(annualNum);
        vo.setAnnualPer(BigDecimalUtil.transDoubleToPercent(annualPer));
        vo.setInsNum(insNum);
        vo.setInsPer(BigDecimalUtil.transDoubleToPercent(insPer));
        vo.setBothNum(bothNum);
        vo.setBothPer(BigDecimalUtil.transDoubleToPercent(bothPer));
        vo.setPercent(BigDecimalUtil.transDoubleToPercent(percent));
        return vo;
    }

}
