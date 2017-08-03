/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller;

import com.bbd.service.IDictionaryService;
import com.bean.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/** 
 * 字典服务控制层
 * @author liuweibo 
 * @version $Id: DictionaryController.java, v 0.1 2017年7月20日 上午10:15:54 liuweibo Exp $ 
 */
@RestController
@RequestMapping("/dictionary")
@Api(description = "数据字典")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @ApiOperation(value = "行业数据字典", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/industry.do", method = RequestMethod.GET)
    public RestResult getIndustry() {
        Map<String, String> rs = dictionaryService.getIndustry();
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "区域数据字典", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/district.do", method = RequestMethod.GET)
    public RestResult getDistrict() {
        Map<String, String> rs = dictionaryService.getDistrict();
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "年报信息对比项数据字典", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/annual/item.do", method = RequestMethod.GET)
    public RestResult getAnnualItem() {
        Map<String, String> rs = dictionaryService.getAnnualItem();
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "即时信息对比项数据字典", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/ins/item.do", method = RequestMethod.GET)
    public RestResult getInsItem() {
        Map<String, String> rs = dictionaryService.getInsItem();
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "企业性质数据字典", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/company/property.do", method = RequestMethod.GET)
    public RestResult getPropertyItem() {
        Map<String, String> rs = dictionaryService.getCompanyPropertyItem();
        return RestResult.ok(rs);
    }

}
