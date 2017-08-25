/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.dao.*;
import com.bbd.domain.*;
import com.bbd.pagin.PageListHelper;
import com.bbd.service.ICompareExceptionService;
import com.bbd.service.IDictionaryService;
import com.bbd.service.param.ExDetailVo;
import com.bbd.service.param.ExceptionSearchParam;
import com.bbd.util.StringUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mybatis.domain.PageBounds;
import com.utils.BeanMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 对比异常服务实现
 *
 * @author tjwang
 * @version $Id: CompareExceptionServiceImpl.java, v 0.1 2017/7/18 0018 16:44 tjwang Exp $
 */
@Service
public class CompareExceptionServiceImpl implements ICompareExceptionService {

    @Autowired
    private CompanyExItemDao         companyExItemDao;

    @Autowired
    private CompanyExItemExtDao      companyExItemExtDao;

    @Autowired
    private AnnualExDetailDao        annualExDetailDao;

    @Autowired
    private AnnualExPrevDetailDao    annualExPrevDetailDao;

    @Autowired
    private InstantlyExDetailDao     instantlyExDetailDao;

    @Autowired
    private InstantlyExPrevDetailDao instantlyExPrevDetailDao;

    @Autowired
    private PubCompanyInfoDao        companyInfoDao;

    @Autowired
    private IDictionaryService       dictionaryServiceDao;

    @Override
    public List<String> searchAnnualByParam(ExceptionSearchParam param, PageBounds pb) {
        List<String> rs = Lists.newArrayList();

        String region = param.getRegion();
        String primaryIndustry = param.getPrimaryIndustry();
        int moduleType = param.getModuleType();
        int exType = param.getExType();
        int sortType = param.getSortType();
        String sort = param.getSort();

        List<String> ds = companyExItemExtDao.queryAnnualByParam(region, primaryIndustry, moduleType, exType, sortType, sort, pb);

        if (ds.size() == 0) {
            return rs;
        }
        rs.addAll(ds);

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchAnnualByExCount(int count, String sort, int sortType, PageBounds pb) {
        List<String> rs = Lists.newArrayList();
        String str = (sort == null ? "desc" : sort);
        
        CompanyExItemExample exam = new CompanyExItemExample();
        if(sortType == 1) {
            exam.setOrderByClause("annual_num " + str);
        } else if(sortType == 2) {
            exam.setOrderByClause("annual_ex_modules_num " + str);
        }        
        if(count > 0)
            exam.createCriteria().andAnnualNumGreaterThanOrEqualTo(count);
        else 
            exam.createCriteria().andAnnualNumGreaterThan(count);

        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return rs;
        }

        ds.forEach(p -> rs.add(p.getNbxh()));

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchAnnualByCompanyName(String companyName, String sort, int sortType, PageBounds pb) {
        List<String> rs = Lists.newArrayList();
        String str = (sort == null ? "desc" : sort);
        
        CompanyExItemExample exam = new CompanyExItemExample();
        if(sortType == 1) {
            exam.setOrderByClause("annual_num " + str);
        } else if(sortType == 1) {
            exam.setOrderByClause("annual_ex_modules_num " + str);
        }
        
        CompanyExItemExample.Criteria criteria = exam.createCriteria();
        criteria.andAnnualNumGreaterThan(0);
        
        if (!StringUtils.isEmpty(companyName)) {
            criteria.andCompanyNameLike("%" + companyName + "%");
        }
        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
        }

        ds.forEach(p -> rs.add(p.getNbxh()));

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchInstantlyByParam(ExceptionSearchParam param, PageBounds pb) {
        List<String> rs = Lists.newArrayList();

        String region = param.getRegion();
        String primaryIndustry = param.getPrimaryIndustry();
        int moduleType = param.getModuleType();
        int exType = param.getExType();
        int sortType = param.getSortType();
        String sort = param.getSort();

        List<String> ds = companyExItemExtDao.queryInstantlyByParam(region, primaryIndustry, moduleType, exType, sort, sortType, pb);

        if (ds.size() == 0) {
            return rs;
        }
        rs.addAll(ds);

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchInstantlyByExCount(int count, String sort, int sortType, PageBounds pb) {
        List<String> rs = Lists.newArrayList();
        String str = (sort == null ? "desc" : sort);
        
        CompanyExItemExample exam = new CompanyExItemExample();
        if(sortType == 1) exam.setOrderByClause("instantly_num " + str);
        if(sortType == 2) exam.setOrderByClause("ins_ex_modules_num " + str);
        
        if(count > 0)
            exam.createCriteria().andInstantlyNumGreaterThanOrEqualTo(count);
        else 
            exam.createCriteria().andInstantlyNumGreaterThan(count);

        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return rs;
        }
        ds.forEach(p -> rs.add(p.getNbxh()));
        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchInstantlyByCompanyName(String companyName, String sort, int sortType, PageBounds pb) {
        List<String> rs = Lists.newArrayList();
        String str = (sort == null ? "desc" : sort);
        
        CompanyExItemExample exam = new CompanyExItemExample();
        if(sortType == 1) exam.setOrderByClause("instantly_num " + str);
        if(sortType == 2) exam.setOrderByClause("ins_ex_modules_num " + str);
        CompanyExItemExample.Criteria criteria = exam.createCriteria();
        criteria.andInstantlyNumGreaterThan(0);
        
        if(!StringUtils.isEmpty(companyName)) {
            criteria.andCompanyNameLike("%" + companyName + "%");            
        }
        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
        }
        ds.forEach(p -> rs.add(p.getNbxh()));
        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchAllByParam(ExceptionSearchParam param, PageBounds pb) {
        List<String> rs = Lists.newArrayList();

        String region = param.getRegion();
        String primaryIndustry = param.getPrimaryIndustry();
        int exType = param.getExType();
        int sortType = param.getSortType();
        String sort = param.getSort();

        List<String> ds = companyExItemExtDao.queryAllByParam(region, primaryIndustry, exType, sort, sortType, pb);

        if (ds.size() == 0) {
            return rs;
        }
        rs.addAll(ds);

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchAllByExCount(int count, String sort, int sortType, PageBounds pb) {
        List<String> rs = Lists.newArrayList();
        String str = (sort == null ? "desc" : sort);
        
        CompanyExItemExample exam = new CompanyExItemExample();
        if(sortType == 1) exam.setOrderByClause("num " + str);
        if(sortType == 2) exam.setOrderByClause("ex_modules_num " + str);
        if(count > 0)
            exam.createCriteria().andNumGreaterThanOrEqualTo(count);
        else 
            exam.createCriteria().andNumGreaterThan(count);

        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return rs;
        }

        ds.forEach(p -> rs.add(p.getNbxh()));

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<String> searchAllByCompanyName(String companyName, String sort, int sortType, PageBounds pb) {
        List<String> rs = Lists.newArrayList();
        String str = (sort == null ? "desc" : sort);
        
        CompanyExItemExample exam = new CompanyExItemExample();
        if(sortType == 1) exam.setOrderByClause("num " + str);
        if(sortType == 2) exam.setOrderByClause("ex_modules_num " + str);
        CompanyExItemExample.Criteria criteria = exam.createCriteria();
        criteria.andNumGreaterThan(0);
        if(!StringUtils.isEmpty(companyName)) {
            criteria.andCompanyNameLike("%" + companyName + "%");          
        }

        List<CompanyExItem> ds = companyExItemDao.selectByExampleWithPageBounds(exam, pb);
        if (ds.size() == 0) {
            return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
        }

        ds.forEach(p -> rs.add(p.getNbxh()));

        return PageListHelper.create(rs, PageListHelper.getPaginator(ds));
    }

    @Override
    public List<ExDetailVo> getCompanyAnnualExDetails(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "内部序号不能为空");

        List<AnnualExDetail> ds = getAnnualExDetails(nbxh);
        if (ds.size() > 0) {
            return BeanMapperUtil.mapList(ds, ExDetailVo.class);
        }

        List<AnnualExPrevDetail> pds = getAnnualExPrevDetails(nbxh);
        if (pds.size() > 0) {
            return BeanMapperUtil.mapList(pds, ExDetailVo.class);
        }

        return Lists.newArrayList();
    }

    private List<AnnualExDetail> getAnnualExDetails(String nbxh) {
        AnnualExDetailExample exam = new AnnualExDetailExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return annualExDetailDao.selectByExample(exam);
    }

    private List<AnnualExPrevDetail> getAnnualExPrevDetails(String nbxh) {
        AnnualExPrevDetailExample exam = new AnnualExPrevDetailExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return annualExPrevDetailDao.selectByExample(exam);
    }

    @Override
    public List<ExDetailVo> getCompanyInstantlyExDetails(String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "内部序号不能为空");

        List<InstantlyExDetail> ds = getInstantlyExDetails(nbxh);
        if (ds.size() > 0) {
            return BeanMapperUtil.mapList(ds, ExDetailVo.class);
        }
        List<InstantlyExPrevDetail> pds = getInstantlyExPrevDetails(nbxh);
        if (ds.size() > 0) {
            return BeanMapperUtil.mapList(pds, ExDetailVo.class);
        }

        return Lists.newArrayList();
    }

    private List<InstantlyExDetail> getInstantlyExDetails(String nbxh) {
        InstantlyExDetailExample exam = new InstantlyExDetailExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return instantlyExDetailDao.selectByExample(exam);
    }

    private List<InstantlyExPrevDetail> getInstantlyExPrevDetails(String nbxh) {
        InstantlyExPrevDetailExample exam = new InstantlyExPrevDetailExample();
        exam.createCriteria().andNbxhEqualTo(nbxh);
        return instantlyExPrevDetailDao.selectByExample(exam);
    }

    /**
     * 根据企业nbxh查询企业异常详情头部信息
     * @see com.bbd.service.ICompareExceptionService#getCompanyInfo(java.lang.String) 
     */
    @Override
    public Map<String, Object> getCompanyInfo(String nbxh) {
        Map<String, String> disMap = dictionaryServiceDao.getDistrict();
        Map<String, Object> rs = Maps.newHashMap();
        PubCompanyInfoExample example = new PubCompanyInfoExample();
        example.createCriteria().andNbxhEqualTo(nbxh);
        List<PubCompanyInfo> dbList = companyInfoDao.selectByExample(example);
        if (!dbList.isEmpty()) {
            PubCompanyInfo info = dbList.get(0);
            rs.put("companyName", info.getCompanyName());
            rs.put("regno", info.getRegno());
            rs.put("creditCode", info.getCreditCode());
            String district = info.getRegion();
            rs.put("district", "贵阳市" + disMap.get(district));
            rs.put("legalPerson", info.getLegalPerson());           
        }
        return rs;
    }

}
