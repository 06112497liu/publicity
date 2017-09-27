
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
import java.util.Objects;

import com.bbd.service.ICompanyService;
import com.bbd.util.ReportUtils;
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
import com.google.common.collect.Maps;
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

    @Autowired
    private ICompanyService companyService;
    
    /** 企业  */
    private static final Optional<String> sourceQY = Optional.of("report/AnnualReport_QY.prpt");
    
    /** 农专  */
    private static final Optional<String> sourceNZ = Optional.of("report/AnnualReport_NZ.prpt");
    
    /** 个体  */
    private static final Optional<String> sourceGT = Optional.of("report/AnnualReport_GT.prpt");

    @Override
    public void getAnnualQY(OutputStream out, String nbxh, String year) {
        // 获取流水号
        String serialNo = getSerialNo(nbxh, year);
        // 获取年报年度、公司名称、注册号
        Map<String, Object> params = getParams(nbxh, year);
        // 年报基本信息
        List<BaseInfo> baseInfo = getAnnualBaseInfo(nbxh, year); 
        ReportElementModel baseModel = 
                buildReportElementModel("BaseInfo", "BaseData", baseInfo, 7, Title.baseInfoQYTitle);
        // 资产状况信息
        List<AssetsInfo> assetsInfo = getAssetsInfo(nbxh, serialNo);
        ReportElementModel assetsModel = 
                buildReportElementModel("AssetsInfo", "AssetsData", assetsInfo, 7, Title.assetsInfoQYTitle);
        // 网站网店信息
        List<WebInfo> webInfo = getWebInfo(serialNo);
        ReportElementModel webModel = 
                buildReportElementModel("WebInfo", "WebData", webInfo, 6, Title.webInfoTitle);
        // 股东及出资信息
        List<StockholderInfo> stockholderInfo = getStockholderInfo(serialNo);
        ReportElementModel stockholderModel = 
                buildReportElementModel("StockholderInfo", "StockholderData", stockholderInfo, 5, Title.stockholderInfoTitle);
        // 对外投资信息
        List<InvestInfo> investInfo = getInvestInfo(serialNo, nbxh);
        ReportElementModel investModel = 
                buildReportElementModel("InvestmentInfo", "InvestmentData", investInfo, 4, Title.investInfoTitle);
        // 对外提供担保保证信息
        List<GuaranteeInfo> guaranteeInfo = getGuaranteeInfo(serialNo);
        ReportElementModel guaranteeModel = 
                buildReportElementModel("ProvGuarInfo", "ProvGuarData", guaranteeInfo, 3, Title.guaranteeInfoTitle);
        // 股权变更信息
        List<ChangeInfo> changeInfo = getChangeInfo(serialNo);
        ReportElementModel changeModel = 
                buildReportElementModel("EquityChangeInfo", "EquityChangeData", changeInfo, 2, Title.changeInfoTitle);
        ArrayListMultimap<StructureEnum, ReportElementModel> elements =
                buildArrayListMultimap(baseModel, assetsModel, webModel, stockholderModel, investModel, guaranteeModel, changeModel);
        ReportEngine re = new ReportEngine();
        re.generateReport(sourceQY, elements, params, ExportEnum.PDF, out);
    }

    @Override
    public void getAnnualGT(OutputStream out, String nbxh, String year) {
        
        // 获取流水号
        String serialNo = getSerialNo(nbxh, year);
        
        // 获取年报年度、公司名称、注册号
        Map<String, Object> params = getParams(nbxh, year);
        
        // 年报基本信息
        List<BaseInfo> baseInfo = getAnnualBaseInfo(nbxh, year); 
        ReportElementModel baseModel = 
                buildReportElementModel("BaseInfo", "BaseData", baseInfo, 4, Title.baseInfoGTTitle);
        
        // 资产状况信息
        List<AssetsInfo> assetsInfo = getAssetsInfo(nbxh, serialNo);
        ReportElementModel assetsModel = 
                buildReportElementModel("AssetsInfo", "AssetsData", assetsInfo, 4, Title.assetsInfoGTTitle);
        
        // 行政许可信息
        List<AdminLicInfo> adminLicInfo = getadminLicInfo(serialNo);
        ReportElementModel adminLicModel = 
                buildReportElementModel("AdminLicInfo", "AdminLicData", adminLicInfo, 3, Title.adminLicInfoTile);
        
        // 网站网店信息
        List<WebInfo> webInfo = getWebInfo(serialNo);
        ReportElementModel webModel = 
                buildReportElementModel("WebInfo", "WebData", webInfo, 2, Title.webInfoTitle);
        
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = 
                buildArrayListMultimap(baseModel, assetsModel, adminLicModel, webModel);
        ReportEngine re = new ReportEngine();
        re.generateReport(sourceGT, elements, params, ExportEnum.PDF, out);
    }

    //获取年报流水号
    private String getSerialNo(String nbxh, String year) {
        AnnualBaseExample exam = new AnnualBaseExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andAnnualYearEqualTo(year);
        List<AnnualBase> list = baseDao.selectByExample(exam);
        String serialNo = null;
        if(!list.isEmpty()) {
            AnnualBase base = list.get(0);
            serialNo = base.getSerialNo();
        }
        return serialNo;
    }

    // 获取年报年度、公司名称、注册号
    private Map<String, Object> getParams(String nbxh, String year) {
        Map<String, Object> params = Maps.newHashMap();
        AnnualBaseExample exam = new AnnualBaseExample();
        exam.createCriteria().andNbxhEqualTo(nbxh).andAnnualYearEqualTo(year);
        List<AnnualBase> list = baseDao.selectByExample(exam);
        String companyName = null;
        String regno = null;
        String code = null;
        if(!list.isEmpty()) {
            AnnualBase base = list.get(0);
            companyName = base.getCompanyName();
            regno = base.getRegno();
            code = base.getCreditCode();
        }
        Optional<PubCompanyInfo> op = getOneByNbxh(nbxh);
        if(op.isPresent()) {
            PubCompanyInfo c = op.get();
            params.put("year", year);
            params.put("companyName", companyName == null ? c.getCompanyName() : companyName);
            params.put("regno", getRegnoCode(code == null ? c.getCreditCode() : code, regno == null ? c.getRegno() : regno));
        }
        return params;
    }

    @Override
    public void getAnnualNZ(OutputStream out, String nbxh, String year) {
        
        // 获取流水号
        String serialNo = getSerialNo(nbxh, year);
        
        // 获取年报年度、公司名称、注册号
        Map<String, Object> params = getParams(nbxh, year);
        
        // 年报基本信息
        List<BaseInfo> baseInfo = getAnnualBaseInfo(nbxh, year); 
        ReportElementModel baseModel = 
                buildReportElementModel("BaseInfo", "BaseData", baseInfo, 5, Title.baseInfoNZTitle);
        
        // 资产状况信息
        List<AssetsInfo> assetsInfo = getAssetsInfo(nbxh, serialNo);
        ReportElementModel assetsModel = 
                buildReportElementModel("AssetsInfo", "AssetsData", assetsInfo, 5, Title.assetsInfoNZTitle);
        
        // 行政许可信息
        List<AdminLicInfo> adminLicInfo = getadminLicInfo(serialNo);
        ReportElementModel adminLicModel = 
                buildReportElementModel("AdminLicInfo", "AdminLicData", adminLicInfo, 4, Title.adminLicInfoTile);
        
        // 网站网店信息
        List<WebInfo> webInfo = getWebInfo(serialNo);
        ReportElementModel webModel = 
                buildReportElementModel("WebInfo", "WebData", webInfo, 3, Title.webInfoTitle);
        
        // 分之机构情况
        List<BranchInfo> branchInfo = getBranchInfo(serialNo); 
        ReportElementModel branchModel = 
                buildReportElementModel("BranchInfo", "BranchData", branchInfo, 2, Title.branchInfo);
        
        ArrayListMultimap<StructureEnum, ReportElementModel> elements = 
                buildArrayListMultimap(baseModel, assetsModel, adminLicModel, webModel, branchModel);
        ReportEngine re = new ReportEngine();
        re.generateReport(sourceNZ, elements, params, ExportEnum.PDF, out);
    }
    
    
    // 获取年报基本信息
    private List<BaseInfo> getAnnualBaseInfo(String nbxh, String year) {
        
        List<BaseInfo> list = Lists.newArrayList();        
        AnnualBaseInfoVo baseInfo = annualService.getAnnualBaseInfo(nbxh, year);
        Integer property = annualService.getCompanyProperty(nbxh);

        PubCompanyInfo p = companyService.getByNbxh(nbxh);
        String regno = baseInfo.getRegno();
        String code = baseInfo.getCreditCode();
        if (regno == null) regno = p.getRegno();
        if (code == null) code = p.getCreditCode();

        if(Sets.newHashSet(1, 2, 3).contains(property)) {
            BaseInfoQY info;
            info = BeanMapperUtil.map(baseInfo, BaseInfoQY.class);
            info.setCode(getRegnoCode(code, regno));
            info.setEmpnum(baseInfo.getEmpnum() + "人");
            info.setWomenNum(baseInfo.getWomenNum() + "人");
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
            BaseInfoNZ info;
            info = BeanMapperUtil.map(baseInfo, BaseInfoNZ.class);
            info.setCode(getRegnoCode(code, regno));
            info.setMemnum(baseInfo.getMemnum() + "人");
            info.setEmpnum(baseInfo.getEmpnum() + "人");
            info.setWomenNum(baseInfo.getWomenNum() + "人");
            list.add(info);
            return list;
        } else if(5 == property) {
            BaseInfoGT info;
            info = BeanMapperUtil.map(baseInfo, BaseInfoGT.class);
            info.setCode(getRegnoCode(code, regno));
            info.setEmpnum(baseInfo.getEmpnum() + "人");
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
        if(Objects.isNull(vo)) return rs;
        if(Sets.newHashSet(1, 2, 3).contains(property)) {            
            AssetsInfoQY info = BeanMapperUtil.map(vo, AssetsInfoQY.class);
            rs.add(info);
            addUnit(rs, "万元");
            return rs;
        } else if(4 == property) {
            AssetsInfoNZ info = BeanMapperUtil.map(vo, AssetsInfoNZ.class);
            rs.add(info);
            addUnit(rs, "万元");
            return rs;
        } else if(5 == property) {
            AssetsInfoGT info = BeanMapperUtil.map(vo, AssetsInfoGT.class);
            rs.add(info);
            addUnit(rs, "万元");
            return rs;
        }
        return rs;
    }
    
    private <T> void addUnit(List<T> datas, String unit) {
        for (T t : datas) {
            Field[] field = t.getClass().getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                Field f = field[i];
                f.setAccessible(true);
                try {
                    f.set(t, f.get(t) + unit);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    logger.info("转换异常", e);
                }
            }
        }
    }
    
    // 对外投资信息
    private List<InvestInfo> getInvestInfo(String serialNo, String nbxh) {

        int count = 0;
        List<OutInvesInfoVo> dbList = annualService.getOutInvesInfo(serialNo);
        List<InvestInfo> rs = BeanMapperUtil.mapList(dbList, InvestInfo.class);
        for (int i = 0; i < rs.size(); i++) {
            InvestInfo info = rs.get(i);
            OutInvesInfoVo vo = dbList.get(i);
            String re = vo.getRegno();
            Optional<PubCompanyInfo> op = getOneByRegno(re);
            String code = null;
            if(op.isPresent()) {
                PubCompanyInfo c = op.get();
                code = c.getCreditCode();
            }
            info.setLine(++count);
            info.setCode(getRegnoCode(code, re));
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
            info.setShareholder(vo.getShareholder());
            info.setPreEquityRatio(vo.getPreEquityRatio() + "%");
            info.setAftEquityRatio(vo.getAftEquityRatio() + "%");
            info.setChangeDate(DateUtil.formatDateByPatten(vo.getChangeDate(), "yyyy/MM/dd"));
            list.add(info);
        }
        return list;
    }
    
    // 行政许可信息
    private List<AdminLicInfo> getadminLicInfo(String serialNo) {
        Map<String, String> typeMap = dictionaryService.getFileTypeItem();
        List<AdminLicInfo> list = Lists.newArrayList();
        AnnualAdminLicenseExample exam = new AnnualAdminLicenseExample();
        exam.createCriteria().andSerialNoEqualTo(serialNo);
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
        List<BranchInfo> rs = Lists.newArrayList();
        for (AnnualBranch info : dbList) {
            BranchInfo vo = new BranchInfo();
            String nb = info.getNbxh();
            Optional<PubCompanyInfo> op = getOneByNbxh(nb);
            String re = null;
            String co = null;
            if(op.isPresent()) {
                PubCompanyInfo companyInfo = op.get();
                re = companyInfo.getRegno();
                co = companyInfo.getCreditCode();
            }
            vo.setName(info.getName());
            vo.setCode(getRegnoCode(re, co));
            rs.add(vo);
        }
        return rs;
    }
   
    // 获取注册号和信用代码
    private String getRegnoCode(String...params) {
        Joiner joiner = Joiner.on("/").skipNulls();
        String str = joiner.join(params);
        return str;
    }
    
    // 获取企业详情(根据企业nbxh)
    private Optional<PubCompanyInfo> getOneByNbxh(String nbxh) {
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> dbList = companyDao.selectByExample(exam);
        PubCompanyInfo info = null;
        if(!dbList.isEmpty()) info = dbList.get(0);
        return Optional.fromNullable(info);
    }
    
    // 获取企业详情(根据企业注册号)
    private Optional<PubCompanyInfo> getOneByRegno(String regno) {
        if(Objects.isNull(regno))
            return Optional.fromNullable(null);
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        exam.createCriteria().andRegnoEqualTo(regno);
        List<PubCompanyInfo> dbList = companyDao.selectByExample(exam);
        PubCompanyInfo info = null;
        if(!dbList.isEmpty()) info = dbList.get(0);
        return Optional.fromNullable(info);
    }

    private <T> ReportElementModel buildReportElementModel(String name, String dataName, List<T> lists, int index, Object[] title) {
        ReportElementModel model = new ReportElementModel();
        Object[][] arrays = ReportUtils.buildTwoArray(lists);
        TableDataModel dataModel = new TableDataModel(arrays, title);
        model.setName(name);
        model.setDataName(dataName);
        model.setIndex(index);
        model.setElementEnum(ElementEnum.REPORT_DEFINITION_TABLE);
        model.setDataModel(dataModel);
        return model;
        
    }
    
    private ArrayListMultimap<StructureEnum, ReportElementModel> buildArrayListMultimap(ReportElementModel...params) {
        ArrayListMultimap<StructureEnum, ReportElementModel> list = ArrayListMultimap.create();
        for (ReportElementModel model : params) {
            list.put(StructureEnum.GROUP_FOOTER, model);
        }
        return list;
    }

}






















