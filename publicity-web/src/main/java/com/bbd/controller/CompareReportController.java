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
        CompareReportVo whole = reportService.queryWholeCity();
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


}
