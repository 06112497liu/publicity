
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

import com.bbd.dao.AnnualWebInfoDao;
import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.domain.AnnualWebInfo;
import com.bbd.domain.AnnualWebInfoExample;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.domain.PubCompanyInfoExample;
import com.bbd.report.ReportEngine;
import com.bbd.report.enums.ElementEnum;
import com.bbd.report.enums.ExportEnum;
import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.service.IAnnualService;
import com.bbd.service.IExportAnnualReportService;
import com.bbd.service.param.AnnualBaseInfoVo;
import com.bbd.service.param.WebInfoVo;
import com.bbd.service.param.report.BaseInfo;
import com.bbd.service.param.report.BaseInfoGT;
import com.bbd.service.param.report.BaseInfoNZ;
import com.bbd.service.param.report.BaseInfoQY;
import com.bbd.service.param.report.Title;
import com.bbd.service.param.report.WebInfo;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.utils.BeanMapperUtil;

/** 
 * 年报报告导出服务层
 * @author liuweibo 
 * @version $Id: ExportAnnualReportServiceImpl.java, v 0.1 2017年9月4日 上午9:52:53 liuweibo Exp $ 
 */
@Service
public class ExportAnnualReportServiceImpl implements IExportAnnualReportService {

    private static final Logger logger = LoggerFactory.getLogger(ExportReportExDetailServiceImpl.class);
    
    @Autowired
    private IAnnualService annualService;
    
    @Autowired
    private PubCompanyInfoDao companyDao;
    
    private static final Optional<String> source = Optional.of("report/AnnualReport_QY.prpt");
    
    
    /**
     * 企业年报报告
     */
    @Override
    public void getAnnualQY(OutputStream out, String nbxh, String year, String serialNo) {
        
        // 报告元素集合
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = ArrayListMultimap.create();
        
        ReportElementModel baseModel = new ReportElementModel(); // 企业年报基本信息        
        BaseInfo baseInfo = getAnnualBaseInfo(nbxh, year);
        Object[][] baseArr = buildTwoArray(Lists.newArrayList(baseInfo));
        TableDataModel baseDataModel = new TableDataModel(baseArr, Title.baseInfoTitle);        
        baseModel.setName("BaseInfo");
        baseModel.setDataName("BaseData");
        baseModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        baseModel.setDataModel(baseDataModel);
        
        ReportElementModel webModel = new ReportElementModel(); // 网站网店信息
        List<WebInfo> webInfo = getWebInfo(serialNo);
        Object[][] webArr = buildTwoArray(webInfo);
        TableDataModel webDataModel = new TableDataModel(webArr, Title.webInfoTitle);
        webModel.setName("WebInfo");
        webModel.setDataName("WebData");
        webModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        webModel.setDataModel(webDataModel);
        
        elements.put(StructureEnum.REPORT_HEADER, baseModel);
        elements.put(StructureEnum.REPORT_HEADER, webModel);
        ReportEngine re = new ReportEngine();
        re.generateReport(source, elements, null, ExportEnum.PDF, out);
        
    }
    
    // 获取年报基本信息
    private BaseInfo getAnnualBaseInfo(String nbxh, String year) {
        AnnualBaseInfoVo baseInfo = annualService.getAnnualBaseInfo(nbxh, year);
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> c = companyDao.selectByExample(exam);
        Integer property = null;
        if(!c.isEmpty()) {
            PubCompanyInfo v = c.get(0);
            property = v.getCompanyProperty();
            baseInfo.setCreditCode(v.getCreditCode());
            baseInfo.setRegno(v.getRegno());
        }       
        
        Joiner joiner = Joiner.on(" / ").skipNulls();
        
        if(Sets.newHashSet(1, 2, 3).contains(property)) {
            BaseInfoQY info = new BaseInfoQY();
            info = BeanMapperUtil.map(baseInfo, BaseInfoQY.class);
            info.setCode(joiner.join(baseInfo.getRegno(), baseInfo.getCreditCode()));
            boolean haveInvest = baseInfo.isHaveEqTrans();
            info.setHaveInvest(haveInvest == true ? "是" : "否");
            boolean haveWeb = baseInfo.isHaveEqTrans();
            info.setHaveWeb(haveWeb == true ? "是" : "否");
            boolean haveGuarantee = baseInfo.isHaveEqTrans();
            info.setHaveGuarantee(haveGuarantee == true ? "是" : "否");
            boolean haveEqTrans = baseInfo.isHaveEqTrans(); 
            info.setHaveEqTrans(haveEqTrans == true ? "是" : "否");
            return info;
        } else if(4 == property) {
            BaseInfoNZ info = new BaseInfoNZ();
            info = BeanMapperUtil.map(baseInfo, BaseInfoNZ.class);
            info.setCode(joiner.join(baseInfo.getRegno(), baseInfo.getCreditCode()));
        } else if(5 == property) {
            BaseInfoGT info = new BaseInfoGT();
            info = BeanMapperUtil.map(baseInfo, BaseInfoGT.class);
            info.setCode(joiner.join(baseInfo.getRegno(), baseInfo.getCreditCode()));
        }

        return null;
    }
    
    // 获取网站网店信息
    private List<WebInfo> getWebInfo(String serialNo) {
        int count = 0;
        List<WebInfoVo> dbList = annualService.getWebInfo(serialNo);
        List<WebInfo> rs = BeanMapperUtil.mapList(dbList, WebInfo.class);
        for (WebInfo info : rs) {
            info.setLine(++count);
        }
        return rs;
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






















