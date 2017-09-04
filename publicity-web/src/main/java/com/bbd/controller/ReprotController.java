
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.service.IExportAnnualReportService;
import com.bbd.service.IExportCmpStaReportService;
import com.bbd.service.IExportExDetailReportService;
import com.bbd.util.SessionContext;
import com.bbd.util.ValidateUtil;
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
     
     @ApiOperation(value = "企业信息比对详情报告导出", httpMethod = "GET")
     @ApiImplicitParams({ @ApiImplicitParam(name = "nbxh", value = "企业nbxh", required = true, paramType = "query", dataType = "String") })
     @RequestMapping(value = "/exception/detail/download.do")
     public void exportExDetailByNbxh(String nbxh) throws IOException {
         ValidateUtil.checkNull(nbxh, CommonErrorCode.PARAM_NULL);
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "企业信息对比详情报告.xlsx";
         OutputStream out = buildResponse(fileName, request, response);
         exDetailreportService.exDetailByNbxh(nbxh, out);
     }
     
     @ApiOperation(value = "企业信息比对详情报告批量导出", httpMethod = "GET")
     @ApiImplicitParams({ 
         @ApiImplicitParam(name = "nbxhs", value = "企业nbxh数组", required = true, paramType = "query", dataType = "String"),
         @ApiImplicitParam(name = "exType", value = "异常类型（1-年报信息公示异常，2-即时信息公示异常，3-完整异常）", required = true, paramType = "query", dataType = "String")
     })
     @RequestMapping(value = "/exception/detail/batch/download.do")
     public void exportExDetailByNbhxs(String[] nbxhs, Integer exType) throws IOException {
         ValidateUtil.checkAllNull(CommonErrorCode.PARAM_NULL, exType, nbxhs);
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "企业信息对比详情报告.xlsx";
         OutputStream out = buildResponse(fileName, request, response);
         exDetailreportService.exDetailByNbxhs(nbxhs, out, exType);
     }
     
     @ApiOperation(value = "企业信息比对详情报告全量导出", httpMethod = "GET")
     @ApiImplicitParams({ 
         @ApiImplicitParam(name = "nbxhs", value = "企业nbxh数组", required = true, paramType = "query", dataType = "String"),
         @ApiImplicitParam(name = "exType", value = "异常类型（1-年报信息公示异常，2-即时信息公示异常，3-完整异常）", required = true, paramType = "query", dataType = "String")
     })
     @RequestMapping(value = "/exception/detail/all/download.do")
     public void ExportExDetailByAll() throws IOException {
         
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
         @ApiImplicitParam(name = "annualYear", value = "年报年度", required = true, paramType = "query", dataType = "String")
     })
     @RequestMapping(value = "/annual/download.do")    
     public void ExportAnnual(String nbxh, String annualYear) throws IOException {
         HttpServletRequest request = SessionContext.getRequest();
         HttpServletResponse response = SessionContext.getResponse();
         String fileName = "企业年报报告.pdf";
         OutputStream out = buildResponse(fileName, request, response);
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

