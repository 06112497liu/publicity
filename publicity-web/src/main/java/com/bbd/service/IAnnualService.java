
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service;

import java.util.List;
import java.util.Map;

import com.bbd.service.param.AdminLicVo;
import com.bbd.service.param.AnnualBaseInfoVo;
import com.bbd.service.param.BranchVo;
import com.bbd.service.param.EnterpriseAssetVo;
import com.bbd.service.param.EquityChangeVo;
import com.bbd.service.param.OutInvesInfoVo;
import com.bbd.service.param.ProvGuarVo;
import com.bbd.service.param.StockholderInfosVo;
import com.bbd.service.param.WebInfoVo;
import com.mybatis.domain.PageBounds;

/** 
 * 年报查询服务
 * @author liuweibo 
 * @version $Id: IAnnualService.java, v 0.1 2017年7月13日 下午5:35:56 liuweibo Exp $ 
 */
public interface IAnnualService {
    
    /**
     * 模糊查询年报列表
     * @param param          模糊查询参数
     * @param pb             分页对象
     * @return
     */
    List<AnnualBaseInfoVo> getAnnualInfoList(String param, PageBounds pb);
    
    /**
     * 根据企业nbxh来查询企业有年报的年份、年报流水号、企业性质
     * @param nbxh           企业nbxh
     * @return
     */
    Map<String, Object> getAnnualYearInfoByNbxh(String nbxh);
    
    /**
     * 根据nbxh获取企业性质
     * @param nbxh           企业nbxh
     * @return
     */
    Integer getCompanyProperty(String nbxh);
    
    /**
     * 根据企业nbxh，年报年度查询企业某年年报基本信息
     * @param nbxh           企业nbxh
     * @param year           年报年度
     * @return
     */
    AnnualBaseInfoVo getAnnualBaseInfo(String nbxh, String year);
    
    /**
     * 根据年报流水号查询网站或网店信息 
     * @param serialNo       年报流水号
     * @return
     */
    List<WebInfoVo> getWebInfo(String serialNo);
    
    /**
     * 根据年报流水号获取股东及出资信息
     * @param serialNo       年报流水号
     * @param pb             分页对象
     * @return
     */
    List<StockholderInfosVo> getStockholderInfo(String serialNo, PageBounds pb);
    
    /**
     * 根据年报流水号获取对外投资信息
     * @param serialNo       年报流水号
     * @return
     */
    List<OutInvesInfoVo> getOutInvesInfo(String serialNo);
    
    /**
     * 根据年报流水号获取资产状况信息
     * @param serialNo       年报流水号
     * @return
     */
    EnterpriseAssetVo queryEnterpriAssetInfo(String serialNo);
    
    /**
     * 根据年报流水号获取对外提供保证担保信息
     * @param serialNo       年报流水号
     * @param pb             分页对象
     * @return
     */
    List<ProvGuarVo> getProvGuarInfo(String serialNo, PageBounds pb);
    
    /**
     * 根据年报流水号获取股变更信息
     * @param serialNo       年报流水号
     * @param pb             分页对象
     * @return
     */
    List<EquityChangeVo> getEquityChangeInfo(String serialNo, PageBounds pb);
    
    /**
     * 根据年报流水号获取行政许可信息
     * @param serialNo       年报流水号
     * @param pb             分页对象
     * @return
     */
    List<AdminLicVo> getAdminLicInfo(String serialNo, PageBounds pb);
    
    /**
     * 根据年报流水号查询分支机构情况
     * @param serialNo       年报流水号
     * @param pb             分页对象
     * @return
     */
    List<BranchVo> getBranchInfo(String serialNo, PageBounds pb);
}
















