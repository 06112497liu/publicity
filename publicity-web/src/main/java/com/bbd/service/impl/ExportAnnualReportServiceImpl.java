
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

import com.bbd.dao.PubCompanyInfoDao;
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
import com.bbd.service.param.report.BaseInfoQY;
import com.bbd.service.param.report.CmpStaReportVo;
import com.bbd.service.param.report.Title;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
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
    public void getAnnualQY(OutputStream out, String nbxh, String year) {
        
        // 报告元素集合
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = ArrayListMultimap.create();
        
        ReportElementModel baseModel = new ReportElementModel(); // 企业年报基本信息
        
        BaseInfoQY baseInfo = getAnnualBaseInfo(nbxh, year);
        Object[][] baseArr = buildTwoArray(Lists.newArrayList(baseInfo));
        TableDataModel baseDataModel = new TableDataModel(baseArr, Title.baseInfoTitle);
        
        baseModel.setName("BaseInfo");
        baseModel.setDataName("BaseData");
        baseModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        baseModel.setDataModel(baseDataModel);
        
        elements.put(StructureEnum.REPORT_HEADER, baseModel);
        ReportEngine re = new ReportEngine();
        re.generateReport(source, elements, null, ExportEnum.PDF, out);
        
    }
    
    // 获取年报基本信息
    private BaseInfoQY getAnnualBaseInfo(String nbxh, String year) {
        AnnualBaseInfoVo baseInfo = annualService.getAnnualBaseInfo(nbxh, year);
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> c = companyDao.selectByExample(exam);
        Integer property = null;
        if(!c.isEmpty()) {
            PubCompanyInfo v = c.get(0);
            property = v.getCompanyProperty();
            baseInfo.setCreditCode(v.getCreditCode());
            baseInfo.setRegno(v.getCreditCode());
        }
        BaseInfoQY info = new BaseInfoQY();
        Joiner joiner = Joiner.on("/").skipNulls();
        info.setCode(joiner.join(baseInfo.getRegno(), baseInfo.getCreditCode()));
        if(1 == property) {
            info = BeanMapperUtil.map(baseInfo, BaseInfoQY.class);
            boolean haveInvest = baseInfo.isHaveEqTrans();
            boolean haveWeb = baseInfo.isHaveEqTrans();
            boolean haveGuarantee = baseInfo.isHaveEqTrans();
            boolean haveEqTrans = baseInfo.isHaveEqTrans(); 
        }

        
        return info;
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






















