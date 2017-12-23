/**
 * BBD Service Inc
 * All Rights Reserved @2017
 */
package com.bbd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.dao.AnnualAdminLicenseDao;
import com.bbd.dao.AnnualBaseDao;
import com.bbd.dao.AnnualBaseExtDao;
import com.bbd.dao.AnnualBranchDao;
import com.bbd.dao.AnnualEnterpriseAssetsDao;
import com.bbd.dao.AnnualEquityChangeDao;
import com.bbd.dao.AnnualExtProvGuarInfoDao;
import com.bbd.dao.AnnualOutboundInvestmentDao;
import com.bbd.dao.AnnualStockholderDao;
import com.bbd.dao.AnnualWebInfoDao;
import com.bbd.dao.PubCompanyInfoDao;
import com.bbd.domain.AnnualAdminLicense;
import com.bbd.domain.AnnualAdminLicenseExample;
import com.bbd.domain.AnnualBase;
import com.bbd.domain.AnnualBaseExample;
import com.bbd.domain.AnnualBranch;
import com.bbd.domain.AnnualBranchExample;
import com.bbd.domain.AnnualEnterpriseAssets;
import com.bbd.domain.AnnualEnterpriseAssetsExample;
import com.bbd.domain.AnnualEquityChange;
import com.bbd.domain.AnnualEquityChangeExample;
import com.bbd.domain.AnnualExtProvGuarInfo;
import com.bbd.domain.AnnualExtProvGuarInfoExample;
import com.bbd.domain.AnnualOutboundInvestment;
import com.bbd.domain.AnnualOutboundInvestmentExample;
import com.bbd.domain.AnnualStockholder;
import com.bbd.domain.AnnualStockholderExample;
import com.bbd.domain.AnnualWebInfo;
import com.bbd.domain.AnnualWebInfoExample;
import com.bbd.domain.PubCompanyInfo;
import com.bbd.domain.PubCompanyInfoExample;
import com.bbd.pagin.PageListHelper;
import com.bbd.service.IAnnualService;
import com.bbd.service.IDictionaryService;
import com.bbd.service.param.AdminLicVo;
import com.bbd.service.param.AnnualBaseInfoVo;
import com.bbd.service.param.BranchVo;
import com.bbd.service.param.EnterpriseAssetVo;
import com.bbd.service.param.EquityChangeVo;
import com.bbd.service.param.OutInvesInfoVo;
import com.bbd.service.param.ProvGuarVo;
import com.bbd.service.param.StockholderInfosVo;
import com.bbd.service.param.WebInfoVo;
import com.bbd.util.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.domain.PageBounds;
import com.mybatis.domain.PageList;
import com.mybatis.domain.Paginator;
import com.utils.BeanMapperUtil;

/**
 * 年报查询服务
 *
 * @author liuweibo
 * @version $Id: AnnualServiceImpl.java, v 0.1 2017年7月13日 下午5:36:40 liuweibo Exp $
 */
@Service
public class AnnualServiceImpl implements IAnnualService {

    @Autowired
    private AnnualBaseDao               baseDao;

    @Autowired
    private AnnualBaseExtDao            baseExtDao;

    @Autowired
    private AnnualOutboundInvestmentDao investmentDao;

    @Autowired
    private AnnualWebInfoDao            webInfoDao;

    @Autowired
    private AnnualExtProvGuarInfoDao    extProvGuarInfoDao;

    @Autowired
    private AnnualEquityChangeDao       equityChangeDao;

    @Autowired
    private AnnualStockholderDao        stockholderDao;

    @Autowired
    private AnnualEnterpriseAssetsDao   enterpriseAssetsDao;

    @Autowired
    private AnnualAdminLicenseDao       adminLicenseDao;

    @Autowired
    private AnnualBranchDao             branchDao;

    @Autowired
    private PubCompanyInfoDao           companyInfoDao;

    @Autowired
    private IDictionaryService          dictionaryService;

    /**
     * 模糊查询年报列表
     *
     * @see com.bbd.service.IAnnualService#getAnnualInfoList(java.lang.String, com.mybatis.domain.PageBounds)
     */
    @Override
    public List<AnnualBaseInfoVo> getAnnualInfoList(String param, PageBounds pb) {
        List<AnnualBaseInfoVo> rs = Lists.newArrayList();
        // 1.先根据注册号或信用代码来查询，看用户是否是精确查询
        if (!StringUtils.isEmpty(param)) {
            rs = getAnnualInfoListByRegno(param, pb);
        }
        if (!rs.isEmpty()) {
            return rs;
        } else {
            // 2.如果通过注册号或信用代码查不到数据，就通过企业名称模糊查询
            rs = getAnnualInfoListByName(param, pb);
            return rs;
        }
    }

    // 根据企业注册号或信用代码精确查找企业年报信息
    private List<AnnualBaseInfoVo> getAnnualInfoListByRegno(String param, PageBounds pb) {
        PageList<AnnualBaseInfoVo> rs = new PageList<>();
        // 1.查询年报表
        AnnualBase annualInfo = baseExtDao.selectRecentlyAnnualInfoByRegno(param);
        if (annualInfo == null) {
            return rs;
        }
        AnnualBaseInfoVo infoVo = BeanMapperUtil.map(annualInfo, AnnualBaseInfoVo.class);

        // 2.查询公司基础表，获取法人代表
        String nbxh = infoVo.getNbxh();
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> dbList = companyInfoDao.selectByExample(example);
        
        if (!dbList.isEmpty()) {
            PubCompanyInfo p = dbList.get(0);
            String creditCode = p.getCreditCode();
            String legPer = p.getLegalPerson();
            infoVo.setLegalPerson(legPer);
            infoVo.setCreditCode(creditCode);
        }

        // 3.构建结果
        ArrayList<AnnualBaseInfoVo> tempList = Lists.newArrayList();
        tempList.add(infoVo);
        rs = PageListHelper.create(tempList, new Paginator(1, 10, 1));

        return rs;
    }

    // 根据企业名称模糊查询企业年报信息
    private List<AnnualBaseInfoVo> getAnnualInfoListByName(String param, PageBounds pb) {
        List<AnnualBaseInfoVo> temp = Lists.newArrayList();
        // 1.先去基础表查询有年报数据的公司并获取nbxh集合
        PubCompanyInfoExample exam = new PubCompanyInfoExample();
        PubCompanyInfoExample.Criteria criteria = exam.createCriteria();
        criteria.andAnnualedEqualTo(1);
        if (!StringUtils.isEmpty(param)) {
            criteria.andCompanyNameLike("%" + param + "%");
        }
        List<PubCompanyInfo> dbList1 = companyInfoDao.selectByExampleWithPageBounds(exam, pb);
        Paginator paginator = PageListHelper.getPaginator(dbList1);

        // 2.去年报表查询年报基本信息
        for (PubCompanyInfo p : dbList1) {
            String nb = p.getNbxh();
            String person = p.getLegalPerson();
            String creditCode = p.getCreditCode();
            Integer property = p.getCompanyProperty();
            AnnualBase s = baseExtDao.selectRecentlyAnnualInfoByNbxh(nb);
            AnnualBaseInfoVo t = BeanMapperUtil.map(s, AnnualBaseInfoVo.class);
            if(null != t) {
                t.setLegalPerson(person);
                t.setCreditCode(creditCode);
                t.setCompanyProperty(property);
                temp.add(t);
            }
        }
        PageList<AnnualBaseInfoVo> rs = PageListHelper.create(temp, paginator);
        return rs;
    }

    /**
     * 根据企业nbxh来查询企业有年报的年份、年报流水号、企业性质
     */
    @Override
    public Map<String, Object> getAnnualYearInfoByNbxh(String nbxh) {
        // 1.查询企业有哪些年份有年报
        AnnualBaseExample example = new AnnualBaseExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<AnnualBase> list = baseDao.selectByExample(example);
        Map<String, String> yearAndSerialNo = list.stream().sorted((x, y) -> -x.getAnnualYear().compareTo(y.getAnnualYear()))
            .collect(Collectors.toMap(AnnualBase::getAnnualYear, AnnualBase::getSerialNo));
        Map<String, Object> rs = Maps.newHashMap();
        rs.put("year", yearAndSerialNo);

        // 2.查询企业性质
        Integer companyProperty = getCompanyProperty(nbxh);
        rs.put("companyProperty", companyProperty);
        return rs;
    }

    /**
     * 根据企业nbxh获取企业性质
     */
    public Integer getCompanyProperty(String nbxh) {
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> rs = companyInfoDao.selectByExample(example);
        if (rs.isEmpty()) {
            return null;
        }
        PubCompanyInfo info = rs.get(0);
        Integer companyProperty = info.getCompanyProperty();
        return companyProperty;
    }
    
    // 查询企业注册号
    private String getCreditCode(String nbxh) {
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> rs = companyInfoDao.selectByExample(example);
        if (rs.isEmpty()) {
            return null;
        }
        PubCompanyInfo info = rs.get(0);
        String code  = info.getCreditCode();
        return code;
    }

    /**
     * 根据企业nbxh，年报年度查询企业某年年报基本信息
     *
     * @see
     */
    @Override
    public AnnualBaseInfoVo getAnnualBaseInfo(String nbxh, String year) {

        // 1.查询年报基本信息
        AnnualBaseExample example = new AnnualBaseExample();
        AnnualBaseExample.Criteria criteria = example.createCriteria();
        criteria.andNbxhEqualTo(nbxh).andAnnualYearEqualTo(year);
        List<AnnualBase> list = baseDao.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        AnnualBaseInfoVo rs = BeanMapperUtil.map(list.get(0), AnnualBaseInfoVo.class);

        // 2.获取企业性质
        Integer companyProperty = getCompanyProperty(nbxh);
        rs.setCompanyProperty(companyProperty);
        
        // 3.获取企业注册号
        if(rs.getCreditCode() == null) {
            rs.setCreditCode(getCreditCode(nbxh));
        }

        // 3.如果是企业，构建页面显示的一些其它信息（企业性质：1.企业；2.个体；3.农专社）
        if (companyProperty == 1) {
            buildOtherInfo(rs);
        }
        return rs;
    }

    // 构建企业年报基本信息中，页面需要显示的其它信息
    private void buildOtherInfo(AnnualBaseInfoVo rs) {
        String serialNo = rs.getSerialNo();
        if (StringUtils.isBlank(serialNo))
            return;
        // 1.是否有投资信息或购买其它公司股权
        boolean flag1 = getIsInvestment(serialNo);
        rs.setHaveInvest(flag1);
        // 2.是否有网站或网店
        boolean flag2 = getIsWeb(serialNo);
        rs.setHaveWeb(flag2);
        // 3.是否有对外提供担保信息
        boolean flag3 = getIsGuarantee(serialNo);
        rs.setHaveGuarantee(flag3);
        // 4.是否发生股权转让
        boolean flag4 = getIsEqTrans(serialNo);
        rs.setHaveEqTrans(flag4);
    }

    // 查看企业是否有投资信息或购买其它公司股权
    private boolean getIsInvestment(String serialNo) {
        AnnualOutboundInvestmentExample example = new AnnualOutboundInvestmentExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualOutboundInvestment> infos = investmentDao.selectByExample(example);
        return infos.size() > 0;
    }

    // 查看企业是否有网站或网店
    private boolean getIsWeb(String serialNo) {
        AnnualWebInfoExample example = new AnnualWebInfoExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualWebInfo> infos = webInfoDao.selectByExample(example);
        return infos.size() > 0;
    }

    // 查看企业是否有对外提供担保信息
    private boolean getIsGuarantee(String serialNo) {
        AnnualExtProvGuarInfoExample example = new AnnualExtProvGuarInfoExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualExtProvGuarInfo> infos = extProvGuarInfoDao.selectByExample(example);
        return infos.size() > 0;
    }

    // 查看是否发生股权转让
    private boolean getIsEqTrans(String serialNo) {
        AnnualEquityChangeExample example = new AnnualEquityChangeExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualEquityChange> infos = equityChangeDao.selectByExample(example);
        return infos.size() > 0;
    }

    /**
     * 查询网站或网店信息
     */
    @Override
    public List<WebInfoVo> getWebInfo(String serialNo) {
        AnnualWebInfoExample example = new AnnualWebInfoExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualWebInfo> dbList = webInfoDao.selectByExample(example);
        List<WebInfoVo> rs = BeanMapperUtil.mapList(dbList, WebInfoVo.class);
        return rs;
    }

    /**
     * 根据年报流水号获取股东及出资信息
     */
    @Override
    public List<StockholderInfosVo> getStockholderInfo(String serialNo, PageBounds pb) {
        AnnualStockholderExample example = new AnnualStockholderExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualStockholder> dbList = stockholderDao.selectByExampleWithPageBounds(example, pb);
        List<StockholderInfosVo> temp = BeanMapperUtil.mapList(dbList, StockholderInfosVo.class);
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<StockholderInfosVo> rs = PageListHelper.create(temp, paginator);
        return rs;
    }

    /**
     * 根据年报流水号获取对外投资信息
     *
     */
    @Override
    public List<OutInvesInfoVo> getOutInvesInfo(String serialNo) {
        AnnualOutboundInvestmentExample example = new AnnualOutboundInvestmentExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualOutboundInvestment> dbList = investmentDao.selectByExample(example);
        List<OutInvesInfoVo> rs = BeanMapperUtil.mapList(dbList, OutInvesInfoVo.class);
        for (OutInvesInfoVo vo : rs) {
            String re = vo.getRegno();
            List<PubCompanyInfo> list = Lists.newArrayList();
            PubCompanyInfoExample exam = new PubCompanyInfoExample();
            if(Objects.nonNull(re)) {
                exam.createCriteria().andRegnoEqualTo(re);
                list = companyInfoDao.selectByExample(exam);
            }
            if(!list.isEmpty()) {
                PubCompanyInfo info = list.get(0);
                vo.setCreditCode(info.getCreditCode());
            }
        }
        return rs;
    }

    /**
     * 根据年报流水号获取资产状况信息
     *
     */
    @Override
    public EnterpriseAssetVo queryEnterpriAssetInfo(String serialNo) {
        AnnualEnterpriseAssetsExample example = new AnnualEnterpriseAssetsExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualEnterpriseAssets> dbList = enterpriseAssetsDao.selectByExample(example);
        List<EnterpriseAssetVo> rs = BeanMapperUtil.mapList(dbList, EnterpriseAssetVo.class);
        if (rs.isEmpty()) {
            return null;
        }
        return rs.get(0);
    }

    /**
     * 根据年报流水号获取对外提供保证担保信息
     */
    @Override
    public List<ProvGuarVo> getProvGuarInfo(String serialNo, PageBounds pb) {
        AnnualExtProvGuarInfoExample example = new AnnualExtProvGuarInfoExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualExtProvGuarInfo> dbList = extProvGuarInfoDao.selectByExampleWithPageBounds(example, pb);
        List<ProvGuarVo> temp = BeanMapperUtil.mapList(dbList, ProvGuarVo.class);
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<ProvGuarVo> rs = PageListHelper.create(temp, paginator);
        return rs;
    }

    /**
     * 根据年报流水号获取股变更信息
     */
    @Override
    public List<EquityChangeVo> getEquityChangeInfo(String serialNo, PageBounds pb) {
        AnnualEquityChangeExample example = new AnnualEquityChangeExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualEquityChange> dbList = equityChangeDao.selectByExampleWithPageBounds(example, pb);
        List<EquityChangeVo> temp = BeanMapperUtil.mapList(dbList, EquityChangeVo.class);
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<EquityChangeVo> rs = PageListHelper.create(temp, paginator);
        return rs;
    }

    /**
     * 根据年报流水号获取行政许可信息
     */
    @Override
    public List<AdminLicVo> getAdminLicInfo(String serialNo, PageBounds pb) {
        AnnualAdminLicenseExample example = new AnnualAdminLicenseExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualAdminLicense> dbList = adminLicenseDao.selectByExampleWithPageBounds(example, pb);
        List<AdminLicVo> temp = BeanMapperUtil.mapList(dbList, AdminLicVo.class);
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<AdminLicVo> rs = PageListHelper.create(temp, paginator);
        return rs;
    }

    /**
     * 根据年报流水号查询分支机构情况
     */
    @Override
    public List<BranchVo> getBranchInfo(String serialNo, PageBounds pb) {
        AnnualBranchExample example = new AnnualBranchExample();
        example.createCriteria().andSerialNoEqualTo(serialNo);
        List<AnnualBranch> dbList = branchDao.selectByExampleWithPageBounds(example, pb);
        List<BranchVo> temp = BeanMapperUtil.mapList(dbList, BranchVo.class);
        Paginator paginator = PageListHelper.getPaginator(dbList);
        PageList<BranchVo> rs = PageListHelper.create(temp, paginator);
        return rs;
    }

}
