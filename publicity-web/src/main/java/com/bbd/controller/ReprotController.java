
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbd.controller.vo.ExceptionCompanyVo;
import com.bbd.service.param.ExceptionSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.exception.PubErrorCode;
import com.bbd.service.IAnnualService;
import com.bbd.service.IExportAnnualReportService;
import com.bbd.service.IExportCmpStaReportService;
import com.bbd.service.IExportExDetailReportService;
import com.bbd.util.SessionContext;
import com.bbd.util.ValidateUtil;
import com.exception.ApplicationException;
import com.exception.CommonErrorCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/** 
 *  
 * @author liuweibo 
 * @version $Id: ReprotController.java, v 0.1 2017年8月17日 下午3:01:20 liuweibo Exp $ 
 */
 @RestController
 @RequestMapping("/report")
 @Api(description = "报告导出接口") 
public class ReprotController extends AbstractController {
     
     @Autowired
     private IExportExDetailReportService exDetailreportService;
     
     @Autowired
     private IExportCmpStaReportService cmpStaReportService;
     
     @Autowired
     private IExportAnnualReportService annualReportService;
     
     @Autowired
     private IAnnualService annualService;
     
     @ApiOperation(value = "企业信息比对详情报告导出", httpMethod = "GET")
     @ApiImplicitParams({ @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, paramType = "query", dataType = "String") })
     @RequestMapping(value = "/exception/detail/download.do")
     public void exportExDetailByNbxh(String nbxh) throws IOException {
         ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "企业信息对比详情报告（单个）.xlsx";
         OutputStream out = buildResponse(fileName, request, response);
         exDetailreportService.exDetailByNbxh(nbxh, out);
     }
     
     @ApiOperation(value = "企业信息比对详情报告批量导出", httpMethod = "GET")
     @ApiImplicitParams({ 
         @ApiImplicitParam(name = "nbxhs", value = "企业nbxh数组", required = true, paramType = "query", dataType = "String"),
         @ApiImplicitParam(name = "type", value = "异常类型（1-年报信息公示异常，2-即时信息公示异常，3-完整异常）", required = true, paramType = "query", dataType = "String")
     })
     @RequestMapping(value = "/exception/detail/batch/download.do")
     public void exportExDetailByNbhxs(String[] nbxhs, Integer type) throws IOException {
         ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, type, nbxhs);
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "企业信息对比详情报告（批量）.xlsx";
         OutputStream out = buildResponse(fileName, request, response);
         exDetailreportService.exDetailByNbxhs(nbxhs, out, type);
     }

    @ApiOperation(value = "企业信息比对详情报告全量导出（多条件）", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "异常类型（1-年报信息公示异常，2-即时信息公示异常，3-完整异常）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "region", value = "区域编码（如：520100代表直管区）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "primaryIndustry", value = "所属行业（如：A、B）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "moduleType", value = "对比项（年报和即时信息有，完整名单没有）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "exType", value = "异常原因", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/exception/detail/all/excount/download.do")
    public void exportExDetailAll(Integer type, ExceptionSearchParam param) throws IOException {
        ValidateUtil.checkNull(type, CommonErrorCode.PARAM_NULL);
        HttpServletRequest request = SessionContext.getRequest();
        HttpServletResponse response = SessionContext.getResponse();
        String fileName = "企业信息对比详情报告（全量）.xlsx";
        OutputStream out = buildResponse(fileName, request, response);
        exDetailreportService.exDetailAll(type, out, param);
    }

    @ApiOperation(value = "根据异常项数量查询年报信息公示异常企业列表", httpMethod = "GET", response = ExceptionCompanyVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "异常类型（1-年报信息公示异常，2-即时信息公示异常，3-完整异常）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "count", value = "异常项数量", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sortType", value = "排序类别（1-异常项数，2-异常模块数）", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "对比项排序（desc-倒序，asc-正序）", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/annual/excount/search.do", method = RequestMethod.GET)
    public void exportExDetailAll(Integer type, Integer count, Integer sortType, String sort) throws IOException {
        ValidateUtil.checkNull(type, CommonErrorCode.PARAM_NULL);
        int num = (count == null ? 0 : count);
        int sType = (sortType == null ? 1 : sortType);
        HttpServletRequest request = SessionContext.getRequest();
        HttpServletResponse response = SessionContext.getResponse();
        String fileName = "企业信息对比详情报告（全量）.xlsx";
        OutputStream out = buildResponse(fileName, request, response);
        exDetailreportService.exDetailAll(type, num, sType, sort, out);
    }


     @ApiOperation(value = "比对分析报告导出", httpMethod = "GET")
     @RequestMapping(value = "/statistics/download.do")    
     public void ExportCompareStatistics() throws IOException {
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "比对统计分析报告.pdf";
         OutputStream out = buildResponse(fileName, request, response);
         cmpStaReportService.cmpStaReport(out);
     }
     
     @ApiOperation(value = "年报导出", httpMethod = "GET")
     @ApiImplicitParams({ 
         @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, paramType = "query", dataType = "String"),
         @ApiImplicitParam(name = "annualYear", value = "年报年度", required = true, paramType = "query", dataType = "String"),
         @ApiImplicitParam(name = "companyProperty", value = "企业性质（企业性质：1-民营企业 2-国有企业 3-外资企业 4-农专社 5-个体户）", required = true, paramType = "query", dataType = "int")
     })
     @RequestMapping(value = "/annual/download.do")    
     public void ExportAnnual(String nbxh, String annualYear, Integer companyProperty) throws IOException {
         ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, nbxh, annualYear, companyProperty);
         Integer pro = annualService.getCompanyProperty(nbxh);
         if(Integer.compare(companyProperty, pro) != 0) {
             throw new ApplicationException(PubErrorCode.COMPANY_PROPERTY_DONT_MATCH);
         }
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "企业年报报告.pdf";
         OutputStream out = buildResponse(fileName, request, response);
         if(4 == companyProperty)
             annualReportService.getAnnualNZ(out, nbxh, annualYear);
         if(5 == companyProperty)
             annualReportService.getAnnualGT(out, nbxh, annualYear);
         else
             annualReportService.getAnnualQY(out, nbxh, annualYear);
     }
     
     // 处理下载文件问题
     private OutputStream buildResponse(String fileName, 
                                        HttpServletRequest request, 
                                        HttpServletResponse response) throws IOException {
         String agent = request.getHeader("USER-AGENT"); //处理IE乱码的问题
         if(agent != null && agent.indexOf("MSIE") != -1) {
             fileName = URLEncoder.encode(fileName, "UTF-8");
             fileName = fileName.replaceAll("\\+", "%20");
         } else {
             fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
         }
         response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
         response.setContentType("application/x-msdownload;");
         return response.getOutputStream();
     }
     
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

