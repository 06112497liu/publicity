
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.impl;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.dao.AnnualAdminLicenseDao;
import com.bbd.dao.AnnualBaseDao;
import com.bbd.dao.AnnualBranchDao;
import com.bbd.dao.AnnualEquityChangeDao;
import com.bbd.dao.AnnualExtProvGuarInfoDao;
import com.bbd.dao.AnnualStockholderDao;
import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.domain.AnnualAdminLicense;
import com.bbd.domain.AnnualAdminLicenseExample;
import com.bbd.domain.AnnualBase;
import com.bbd.domain.AnnualBaseExample;
import com.bbd.domain.AnnualBranch;
import com.bbd.domain.AnnualBranchExample;
import com.bbd.domain.AnnualEquityChange;
import com.bbd.domain.AnnualEquityChangeExample;
import com.bbd.domain.AnnualExtProvGuarInfo;
import com.bbd.domain.AnnualExtProvGuarInfoExample;
import com.bbd.domain.AnnualStockholder;
import com.bbd.domain.AnnualStockholderExample;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.domain.PubCompanyInfoExample;
import com.bbd.report.ReportEngine;
import com.bbd.report.enums.ElementEnum;
import com.bbd.report.enums.ExportEnum;
import com.bbd.report.enums.StructureEnum;
import com.bbd.report.model.ReportElementModel;
import com.bbd.report.model.TableDataModel;
import com.bbd.service.IAnnualService;
import com.bbd.service.IDictionaryService;
import com.bbd.service.IExportAnnualReportService;
import com.bbd.service.param.AnnualBaseInfoVo;
import com.bbd.service.param.EnterpriseAssetVo;
import com.bbd.service.param.OutInvesInfoVo;
import com.bbd.service.param.StockholderInfosVo;
import com.bbd.service.param.WebInfoVo;
import com.bbd.service.param.report.AdminLicInfo;
import com.bbd.service.param.report.AssetsInfo;
import com.bbd.service.param.report.AssetsInfoGT;
import com.bbd.service.param.report.AssetsInfoNZ;
import com.bbd.service.param.report.AssetsInfoQY;
import com.bbd.service.param.report.BaseInfo;
import com.bbd.service.param.report.BaseInfoGT;
import com.bbd.service.param.report.BaseInfoNZ;
import com.bbd.service.param.report.BaseInfoQY;
import com.bbd.service.param.report.BranchInfo;
import com.bbd.service.param.report.ChangeInfo;
import com.bbd.service.param.report.GuaranteeInfo;
import com.bbd.service.param.report.InvestInfo;
import com.bbd.service.param.report.StockholderInfo;
import com.bbd.service.param.report.Title;
import com.bbd.service.param.report.WebInfo;
import com.bbd.util.DateUtil;
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
    private AnnualBaseDao baseDao;
    
    @Autowired
    private PubCompanyInfoDao companyDao;
    
    @Autowired
    private AnnualStockholderDao stockholderDao;
    
    @Autowired
    private AnnualExtProvGuarInfoDao extProvGuarInfoDao;
    
    @Autowired
    private AnnualEquityChangeDao equityChangeDao;
    
    @Autowired
    private AnnualAdminLicenseDao adminLicenseDao;
    
    @Autowired
    private IDictionaryService dictionaryService;
    
    @Autowired
    private AnnualBranchDao branchDao;
    
    private static final Optional<String> source = Optional.of("report/AnnualReport_QY.prpt");
    
    
    /**
     * 企业年报报告
     */
    @Override
    public void getAnnualQY(OutputStream out, String nbxh, String year) {
        
        AnnualBaseExample exam = new AnnualBaseExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andAnnualYearEqualTo(year);
        List<AnnualBase> list = baseDao.selectByExample(exam);
        String serialNo = null;
        if(!list.isEmpty()) {
            AnnualBase base = list.get(0);
            serialNo = base.getSerialNo();
        }
        
        // 报告元素集合
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = ArrayListMultimap.create();
        
        ReportElementModel baseModel = new ReportElementModel(); // 企业年报基本信息        
        List<BaseInfo> baseInfo = getAnnualBaseInfo(nbxh, year);
        Object[][] baseArr = buildTwoArray(baseInfo);
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
        
        ReportElementModel stockholderModel = new ReportElementModel(); // 股东及出资信息
        List<StockholderInfo> stockholderInfo = getStockholderInfo(serialNo);
        Object[][] stockholderArr = buildTwoArray(stockholderInfo);
        TableDataModel stockholderDataModel = new TableDataModel(stockholderArr, Title.stockholderInfoTitle);
        stockholderModel.setName("StockholderInfo");
        stockholderModel.setDataName("StockholderData");
        stockholderModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        stockholderModel.setDataModel(stockholderDataModel);
        
        ReportElementModel investModel = new ReportElementModel(); // 对外投资信息
        List<InvestInfo> investInfo = getInvestInfo(serialNo, nbxh);
        Object[][] investArr = buildTwoArray(investInfo);
        TableDataModel investDataModel = new TableDataModel(investArr, Title.investInfoTitle);
        investModel.setName("InvestmentInfo");
        investModel.setDataName("InvestmentData");
        investModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        investModel.setDataModel(investDataModel);
        
        ReportElementModel assetsModel = new ReportElementModel(); // 资产状况信息
        List<AssetsInfo> assetsInfo = getAssetsInfo(nbxh, serialNo);
        Object[][] assetsArr = buildTwoArray(assetsInfo);
        TableDataModel assetsDataModel = new TableDataModel(assetsArr, Title.assetsInfoTitle);
        assetsModel.setName("AssetsInfo");
        assetsModel.setDataName("AssetsData");
        assetsModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        assetsModel.setDataModel(assetsDataModel);  
        
        ReportElementModel guaranteeModel = new ReportElementModel(); // 对外提供担保保证信息
        List<GuaranteeInfo> guaranteeInfo = getGuaranteeInfo(serialNo);
        Object[][] guaranteeArr = buildTwoArray(guaranteeInfo);
        TableDataModel guaranteeDataModel = new TableDataModel(guaranteeArr, Title.guaranteeInfoTitle);
        guaranteeModel.setName("ProvGuarInfo");
        guaranteeModel.setDataName("ProvGuarData");
        guaranteeModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        guaranteeModel.setDataModel(guaranteeDataModel);  
        
        ReportElementModel changeModel = new ReportElementModel(); // 股权变更信息
        List<ChangeInfo> changeInfo = getChangeInfo(serialNo);
        Object[][] changeArr = buildTwoArray(changeInfo);
        TableDataModel changeDataModel = new TableDataModel(changeArr, Title.changeInfoTitle);
        changeModel.setName("EquityChangeInfo");
        changeModel.setDataName("EquityChangeData");
        changeModel.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        changeModel.setDataModel(changeDataModel);
        
        elements.put(StructureEnum.REPORT_HEADER, baseModel);
        elements.put(StructureEnum.REPORT_HEADER, webModel);
        elements.put(StructureEnum.REPORT_HEADER, stockholderModel);
        elements.put(StructureEnum.REPORT_HEADER, investModel);
        elements.put(StructureEnum.REPORT_HEADER, assetsModel);
        elements.put(StructureEnum.REPORT_HEADER, guaranteeModel);
        elements.put(StructureEnum.REPORT_HEADER, changeModel);
        
        ReportEngine re = new ReportEngine();
        re.generateReport(source, elements, null, ExportEnum.PDF, out);
        
    }
    
    // 获取年报基本信息
    private List<BaseInfo> getAnnualBaseInfo(String nbxh, String year) {
        
        List<BaseInfo> list = Lists.newArrayList();        
        AnnualBaseInfoVo baseInfo = annualService.getAnnualBaseInfo(nbxh, year);
        Integer property = annualService.getCompanyProperty(nbxh);     
        
        if(Sets.newHashSet(1, 2, 3).contains(property)) {
            BaseInfoQY info = new BaseInfoQY();
            info = BeanMapperUtil.map(baseInfo, BaseInfoQY.class);
            info.setCode(getRegnoCode(nbxh));
            boolean haveInvest = baseInfo.isHaveEqTrans();
            info.setHaveInvest(haveInvest == true ? "是" : "否");
            boolean haveWeb = baseInfo.isHaveEqTrans();
            info.setHaveWeb(haveWeb == true ? "是" : "否");
            boolean haveGuarantee = baseInfo.isHaveEqTrans();
            info.setHaveGuarantee(haveGuarantee == true ? "是" : "否");
            boolean haveEqTrans = baseInfo.isHaveEqTrans(); 
            info.setHaveEqTrans(haveEqTrans == true ? "是" : "否");
            list.add(info);
            return list;
        } else if(4 == property) {
            BaseInfoNZ info = new BaseInfoNZ();
            info = BeanMapperUtil.map(baseInfo, BaseInfoNZ.class);
            info.setCode(getRegnoCode(nbxh));
            list.add(info);
            return list;
        } else if(5 == property) {
            BaseInfoGT info = new BaseInfoGT();
            info = BeanMapperUtil.map(baseInfo, BaseInfoGT.class);
            info.setCode(getRegnoCode(nbxh));
            list.add(info);
            return list;
        }

        return list;
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
    
    // 股东及出资信息
    private List<StockholderInfo> getStockholderInfo(String serialNo) {
        int count = 0;
        AnnualStockholderExample exam = new AnnualStockholderExample();
        exam.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualStockholder> dbList = stockholderDao.selectByExample(exam);
        List<StockholderInfosVo> temp = BeanMapperUtil.mapList(dbList, StockholderInfosVo.class);
        List<StockholderInfo> rs = BeanMapperUtil.mapList(temp, StockholderInfo.class);
        for (int i = 0; i < rs.size(); i++) {
            StockholderInfo info = rs.get(i);
            info.setLine(++count);
            Date sub = temp.get(i).getSubCronDate();
            Date ac = temp.get(i).getAcCronDate();
            info.setSubCronDate(DateUtil.formatDateByPatten(sub, "yyyy/MM/dd"));
            info.setAcCronDate(DateUtil.formatDateByPatten(ac, DateUtil.formatDateByPatten(ac, "yyyy/MM/dd")));
        }
        return rs;
    }
    
    // 企业资产状况信息
    private List<AssetsInfo> getAssetsInfo(String nbxh, String serialNo) {
        
        List<AssetsInfo> rs = Lists.newArrayList();
        Integer property = annualService.getCompanyProperty(nbxh);
        
        EnterpriseAssetVo vo = annualService.queryEnterpriAssetInfo(serialNo);
        if(Sets.newHashSet(1, 2, 3).contains(property)) {            
            AssetsInfoQY info = BeanMapperUtil.map(vo, AssetsInfoQY.class);
            rs.add(info);
            return rs;
        } else if(4 == property) {
            AssetsInfoNZ info = BeanMapperUtil.map(vo, AssetsInfoNZ.class);
            rs.add(info);
            return rs;
        } else if(5 == property) {
            AssetsInfoGT info = BeanMapperUtil.map(vo, AssetsInfoGT.class);
            rs.add(info);
            return rs;
        }
        return rs;
    }
    
    // 对外投资信息
    private List<InvestInfo> getInvestInfo(String serialNo, String nbxh) {
        int count = 0;
        List<OutInvesInfoVo> dbList = annualService.getOutInvesInfo(serialNo);
        List<InvestInfo> rs = BeanMapperUtil.mapList(dbList, InvestInfo.class);
        for (int i = 0; i < rs.size(); i++) {
            InvestInfo info = rs.get(i);
            info.setLine(++count);
            info.setCode(getRegnoCode(nbxh));
        } 
        return rs;
    }
    
    // 对外提供担保保证信息
    private List<GuaranteeInfo> getGuaranteeInfo(String serialNo) {
        int count = 0;
        Joiner joiner = Joiner.on(" 至 ").skipNulls();
        List<GuaranteeInfo> list = Lists.newArrayList();
        AnnualExtProvGuarInfoExample exam = new AnnualExtProvGuarInfoExample();
        exam.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualExtProvGuarInfo> dbList = extProvGuarInfoDao.selectByExample(exam);
        list = BeanMapperUtil.mapList(dbList, GuaranteeInfo.class);
        for (int i = 0; i < list.size(); i++) {
            AnnualExtProvGuarInfo info = dbList.get(i);
            String from = DateUtil.formatDateByPatten(info.getPefPerFrom(), "yyyy/MM/dd");
            String to = DateUtil.formatDateByPatten(info.getPefPerTo(), "yyyy/MM/dd");
            GuaranteeInfo vo = list.get(i);
            vo.setPefPerLimit(joiner.join(from, to));
            vo.setLine(++count);
        }
        return list;
    }
    
    // 股权变更信息
    private List<ChangeInfo> getChangeInfo(String serialNo) {
        int count = 0;
        List<ChangeInfo> list = Lists.newArrayList();
        AnnualEquityChangeExample exam = new AnnualEquityChangeExample();
        exam.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualEquityChange> dbList = equityChangeDao.selectByExample(exam);
        for (int i = 0; i < dbList.size(); i++) {
            AnnualEquityChange vo = dbList.get(i);
            ChangeInfo info = new ChangeInfo();
            info.setLine(++count);
            info.setPreEquityRatio(vo.getPreEquityRatio() + "%");
            info.setAftEquityRatio(vo.getAftEquityRatio() + "%");
            info.setChangeDate(DateUtil.formatDateByPatten(vo.getChangeDate(), "yyyy/MM/dd"));
            list.add(info);
        }
        return list;
    }
    
    // 行政许可信息
    private List<AdminLicInfo> getadminLicInfo(String serialNO) {
        Map<String, String> typeMap = dictionaryService.getFileTypeItem();
        List<AdminLicInfo> list = Lists.newArrayList();
        AnnualAdminLicenseExample exam = new AnnualAdminLicenseExample();
        exam.createCriteria().andSerialNoEqualTo(serialNO);
        List<AnnualAdminLicense> dbList = adminLicenseDao.selectByExample(exam);
        for (int i = 0; i < dbList.size(); i++) {
            AdminLicInfo info = new AdminLicInfo();
            AnnualAdminLicense vo = dbList.get(0);
            info.setValidityTo(DateUtil.formatDateByPatten(vo.getValidityTo(), "yyyy/MM/dd"));
            String name = vo.getLicenseName();
            info.setLicenseNameDesc(typeMap.get(name));
            list.add(info);
        }
        return list;
    }
    
    // 分之机构情况
    private List<BranchInfo> getBranchInfo(String serialNo) {
        AnnualBranchExample example = new AnnualBranchExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualBranch> dbList = branchDao.selectByExample(example);
        List<BranchInfo> rs = BeanMapperUtil.mapList(dbList, BranchInfo.class);
        return rs;
    }
   
    // 获取注册号和信用代码
    private String getRegnoCode(String nbxh) {
        String str = "";
        Joiner joiner = Joiner.on(" / ").skipNulls();
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> list = companyDao.selectByExample(exam);
        if(!list.isEmpty()) {
            PubCompanyInfo info = list.get(0);
            str = joiner.join(info.getRegno(), info.getCreditCode());
        }
        return str;
    }
    
    // 构建二维数组
    private <T> Object[][] buildTwoArray(List<T> datas) {
        
        Integer rows = datas.size();
        if(rows == 0) {
            return new Object[][]{};
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






















