/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.controller;

import com.bbd.service.IAnnualService;
import com.bbd.service.param.*;
import com.bbd.util.StringUtils;
import com.bean.RestResult;
import com.google.common.base.Preconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/** 
 * 年报查询接口
 * @author liuweibo 
 * @version $Id: AnnualController.java, v 0.1 2017年7月13日 下午5:40:28 liuweibo Exp $ 
 */
@RestController
@RequestMapping("/annual/info")
@Api(description = "年报查询")
public class AnnualController extends AbstractController {


    @Autowired
    private IAnnualService annualService;

    @ApiOperation(value = "根据企业名称（注册号）模糊（精确）查询企业年报列表信息", httpMethod = "GET", response = AnnualBaseInfoVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "企业名称或注册号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    public RestResult getAnnualInfoList(String param) {
        List<AnnualBaseInfoVo> rs = annualService.getAnnualInfoList(param, getPageBounds());
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据企业nbxh查询企业有年报的年份（以及流水号和企业性质）", httpMethod = "GET", response = Map.class)
    @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/years.do", method = RequestMethod.GET)
    public RestResult getAnnualYearInfoByNbxh(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(nbxh), "nbxh不能为空！");
        Map<String, Object> rs = annualService.getAnnualYearInfoByNbxh(nbxh);
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据企业nbxh和年份查询企业年报基本信息", httpMethod = "GET", response = AnnualBaseInfoVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "年报年度", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/base.do")
    public RestResult getAnnualBaseInfo(String nbxh, String year) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(nbxh), "企业nbxh不能为空！");
        Preconditions.checkArgument(StringUtils.isNotEmpty(year), "年报年度不能为空！");
        AnnualBaseInfoVo rs = annualService.getAnnualBaseInfo(nbxh, year);
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业网站网店信息", httpMethod = "GET", response = WebInfoVo.class)
    @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/web.do", method = RequestMethod.GET)
    public RestResult getWebInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<WebInfoVo> rs = annualService.getWebInfo(serialNo);
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询股东及出资列表信息", httpMethod = "GET", response = StockholderInfosVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/shareholders.do", method = RequestMethod.GET)
    public RestResult getStockholderInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<StockholderInfosVo> rs = annualService.getStockholderInfo(serialNo, getPageBounds());
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业对外投资信息", httpMethod = "GET", response = OutInvesInfoVo.class)
    @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/investment.do", method = RequestMethod.GET)
    public RestResult getOutInvesInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<OutInvesInfoVo> rs = annualService.getOutInvesInfo(serialNo);
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业资产状况信息", httpMethod = "GET", response = EnterpriseAssetVo.class)
    @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/assets.do", method = RequestMethod.GET)
    public RestResult getEnterpriAssetInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        EnterpriseAssetVo rs = annualService.queryEnterpriAssetInfo(serialNo);
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业对外提供担保保证列表信息", httpMethod = "GET", response = ProvGuarVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/guarantee.do", method = RequestMethod.GET)
    public RestResult getProvGuarInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<ProvGuarVo> rs = annualService.getProvGuarInfo(serialNo, getPageBounds());
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业股权变更列表信息", httpMethod = "GET", response = EquityChangeVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/equity.do", method = RequestMethod.GET)
    public RestResult getEquityChangeInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<EquityChangeVo> rs = annualService.getEquityChangeInfo(serialNo, getPageBounds());
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业行政许可情况列表信息", httpMethod = "GET", response = AdminLicVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/license.do", method = RequestMethod.GET)
    public RestResult getAdminLicInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<AdminLicVo> rs = annualService.getAdminLicInfo(serialNo, getPageBounds());
        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据年报流水号查询企业分支机构列表信息", httpMethod = "GET", response = BranchVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serialNo", value = "年报流水号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/branch.do", method = RequestMethod.GET)
    public RestResult getBranchInfo(String serialNo) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(serialNo), "年报流水号不能为空！");
        List<BranchVo> rs = annualService.getBranchInfo(serialNo, getPageBounds());
        return RestResult.ok(rs);
    }

}
