/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller;

import com.bbd.controller.vo.ExceptionCompanyVo;
import com.bbd.domain.CompanyExItem;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.pagin.PageListHelper;
import com.bbd.service.ICompanyExItemService;
import com.bbd.service.ICompanyService;
import com.bbd.service.ICompareExceptionService;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.InstantlyModule;
import com.bbd.service.compare.PropertyEnum;
import com.bbd.service.param.ExDetailVo;
import com.bbd.service.param.ExceptionSearchParam;
import com.bbd.util.DateUtil;
import com.bbd.util.NumUtils;
import com.bbd.util.ValidateUtil;
import com.bean.RestResult;
import com.exception.CommonErrorCode;
import com.google.common.collect.Lists;
import com.mybatis.domain.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 对比异常控制器
 *
 * @author tjwang
 * @version $Id: CompareExceptionController.java, v 0.1 2017/7/18 0018 16:35 tjwang Exp $
 */
@RestController
@RequestMapping("/cmp/ex")
@Api(description = "公示信息异常企业名单查询")
public class CompareExceptionController extends AbstractController {

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private ICompareExceptionService compareExceptionService;

    @Autowired
    private ICompanyExItemService companyExItemService;

    @ApiOperation(value = "根据区域、行业类型、对比项、异常原因查询年报信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "region", value = "区域编码（如：520100代表直管区）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属行业（如：A、B）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "moduleType", value = "年报对比项（1-基本信息，2-股东及出资信息，4-对外投资信息，8-对外提供保证担保信息。。。。）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "exType", value = "异常原因（1.隐瞒未报；2.登记不一致；4.格式错误）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/annual/search.do", method = RequestMethod.GET)
    public RestResult searchAnnual(ExceptionSearchParam param) {
        List<String> ds = compareExceptionService.searchAnnualByParam(param, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 1);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据异常项数量查询年报信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "count", value = "异常项数量", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/annual/excount/search.do", method = RequestMethod.GET)
    public RestResult searchAnnualByExCount(Integer count, Integer sortType, String sort) {
        int num = (count == null ? 0 : count);
        int type = (sortType == null ? 1 : sortType);
        List<String> ds = compareExceptionService.searchAnnualByExCount(num, sort, type, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 1);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据企业名称查询年报信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "companyName", value = "企业名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/annual/name/search.do", method = RequestMethod.GET)
    public RestResult searchAnnualByCompanyName(String companyName, String sort, Integer sortType) {
        int type = (sortType == null ? 1 : sortType);
        List<String> ds = compareExceptionService.searchAnnualByCompanyName(companyName, sort, type, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 1);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据区域、行业类型、对比项、异常原因查询即时信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "region", value = "区域编码（如：520102代表南明区）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属行业（如：A、B）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "moduleType", value = "即时信息对比项（1-股东及出资信息，2-行政许可信息，4-行政处罚信息）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "exType", value = "异常原因（1.隐瞒未报；2.登记不一致）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/ins/search.do", method = RequestMethod.GET)
    public RestResult searchInstantly(ExceptionSearchParam param) {
        List<String> ds = compareExceptionService.searchInstantlyByParam(param, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 2);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据异常项数量查询即时信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "count", value = "异常项数量", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/ins/excount/search.do", method = RequestMethod.GET)
    public RestResult searchInstantlyByExCount(Integer count, String sort, Integer sortType) {
        int param = count == null ? 0 : count;
        int type = (sortType == null ? 1 : sortType);
        List<String> ds = compareExceptionService.searchInstantlyByExCount(param, sort, type, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 2);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据企业名称查询即时信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "companyName", value = "企业名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/ins/name/search.do", method = RequestMethod.GET)
    public RestResult searchInstantlyByCompanyName(String companyName, String sort, Integer sortType) {
        int type = (sortType == null ? 1 : sortType);
        List<String> ds = compareExceptionService.searchInstantlyByCompanyName(companyName, sort, type, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 2);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据区域、行业类型、对比项、异常原因查询完整异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "region", value = "区域编码（如：520102代表南明区）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属行业（如：A、B）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "exType", value = "异常原因（1.隐瞒未报；2.登记不一致；4.格式错误）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/all/search.do", method = RequestMethod.GET)
    public RestResult searchAll(ExceptionSearchParam param) {
        List<String> ds = compareExceptionService.searchAllByParam(param, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 3);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据异常项数量查询完整异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "count", value = "异常项数量", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/all/excount/search.do", method = RequestMethod.GET)
    public RestResult searchAllByExCount(Integer count, String sort, Integer sortType) {
        int param = (count == null ? 0 : count);
        int type = (sortType == null ? 1 : sortType);
        List<String> ds = compareExceptionService.searchAllByExCount(param, sort, type, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 3);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据企业名称查询完整信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "companyName", value = "企业名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/all/name/search.do", method = RequestMethod.GET)
    public RestResult searchAllByCompanyName(String companyName, String sort, Integer sortType) {
        int type = (sortType == null ? 1 : sortType);
        List<String> ds = compareExceptionService.searchAllByCompanyName(companyName, sort, type, getPageBounds());
        if (ds.size() == 0) {
            return RestResult.ok(ds);
        }
        List<ExceptionCompanyVo> temp = build(ds, 3);
        PageList<ExceptionCompanyVo> rs = PageListHelper.create(temp, PageListHelper.getPaginator(ds));

        return RestResult.ok(rs);
    }

    @ApiOperation(value = "根据企业nbxh查询企业年报信息异常详情", httpMethod = "GET", response = ExDetailVo.class)
    @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/annual/detail.do", method = RequestMethod.GET)
    public RestResult searchAnnualExDetails(String nbxh) {
        ValidateUtil.checkBlank(nbxh, CommonErrorCode.PARAM_ERROR);
        List<ExDetailVo> ds = compareExceptionService.getCompanyAnnualExDetails(nbxh);
        ds.forEach(p -> {
            p.setPropNameDesc(PropertyEnum.getNameByCode(p.getPropName()));
        });
        return RestResult.ok(ds);
    }

    @ApiOperation(value = "根据企业nbxh查询企业即时信息异常详情", httpMethod = "GET", response = ExDetailVo.class)
    @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/ins/detail.do", method = RequestMethod.GET)
    public RestResult searchInstantlyExDetails(String nbxh) {
        ValidateUtil.checkBlank(nbxh, CommonErrorCode.PARAM_ERROR);
        List<ExDetailVo> ds = compareExceptionService.getCompanyInstantlyExDetails(nbxh);
        ds.forEach(p -> {
            p.setPropNameDesc(PropertyEnum.getNameByCode(p.getPropName()));
        });
        return RestResult.ok(ds);
    }

    @ApiOperation(value = "根据企业nbxh查询企业异常详情头部信息", httpMethod = "GET")
    @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/detail/head.do", method = RequestMethod.GET)
    public RestResult searchCompanyInfo(String nbxh) {
        ValidateUtil.checkBlank(nbxh, CommonErrorCode.PARAM_ERROR);
        Map<String, Object> rs = compareExceptionService.getCompanyInfo(nbxh);
        return RestResult.ok(rs);
    }

    private List<ExceptionCompanyVo> build(List<String> ds, Integer type) {
        List<ExceptionCompanyVo> result = Lists.newArrayList();
        ds.forEach(p -> result.add(build(p, type)));
        return result;
    }

    private ExceptionCompanyVo build(String nbxh, Integer type) {
        
        ExceptionCompanyVo vo = new ExceptionCompanyVo();
        CompanyExItem ex = companyExItemService.getByNbxh(nbxh);
        vo.setCompanyName(ex.getCompanyName());
        vo.setNbxh(ex.getNbxh());
        
        if (type == 1) {
            vo.setCount(ex.getAnnualNum());
            vo.setCompareTime(ex.getAnnualCmpTime());
        } else if (type == 2) {
            vo.setCount(ex.getInstantlyNum());
            vo.setCompareTime(ex.getInstantlyCmpTime());
        } else if (type == 3) {

            LocalDateTime annualCmpTime = DateUtil.convertDateToLocalDateTime(ex.getAnnualCmpTime());
            LocalDateTime instantlyCmpTime = DateUtil.convertDateToLocalDateTime(ex.getInstantlyCmpTime());
            vo.setCount(ex.getNum());

            if (annualCmpTime != null && instantlyCmpTime != null) {
                LocalDateTime allCmpTime = DateUtil.getMaxDate(annualCmpTime, instantlyCmpTime);
                vo.setCompareTime(DateUtil.convertLocalDateTimeToDate(allCmpTime));
            } else if (annualCmpTime == null && instantlyCmpTime != null) {
                vo.setCompareTime(DateUtil.convertLocalDateTimeToDate(instantlyCmpTime));
            } else if (annualCmpTime != null && instantlyCmpTime == null) {
                vo.setCompareTime(DateUtil.convertLocalDateTimeToDate(annualCmpTime));
            } else {
                vo.setCompareTime(null);
            }
        }
        buildModuleStr(vo, ex);
        return vo;
    }

    // 构造异常模块字符串
    private void buildModuleStr(ExceptionCompanyVo vo, CompanyExItem ex) {
        List<Integer> l = Arrays.asList(1, 2, 4, 8, 16);
        //年报模块
        List<Integer> annualList = NumUtils.getExistNum(ex.getAnnualExModules(), l);
        List<String> annualStrList = annualList.stream().map(p -> AnnualModule.getDescByCode(p)).collect(Collectors.toList());
        String annualStr = StringUtils.join(annualStrList, "、");
        vo.setAnnualExModules(annualStr);
        //即时信息模块
        List<Integer> insList = NumUtils.getExistNum(ex.getInsExModules(), l);
        List<String> insStrList = insList.stream().map(p -> InstantlyModule.getDescByCode(p)).collect(Collectors.toList());
        String insStr = StringUtils.join(insStrList, "、");
        vo.setInsExModules(insStr);
    }

}
























