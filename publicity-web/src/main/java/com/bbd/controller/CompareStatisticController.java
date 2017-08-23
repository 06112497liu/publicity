/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.controller;

import com.bbd.common.Constants;
import com.bbd.common.util.PercentUtil;
import com.bbd.controller.vo.CompareStatisticVo;
import com.bbd.dao.CompareStatisticDao;
import com.bbd.domain.CompareStatistic;
import com.bbd.domain.CompareTask;
import com.bbd.service.ICompanyService;
import com.bbd.service.ICompareTaskService;
import com.bean.RestResult;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.utils.BeanMapperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author tjwang
 * @version $Id: CompareStatisticController.java, v 0.1 2017/7/17 0017 17:20 tjwang Exp $
 */
@RestController
@RequestMapping("/cmp/statistic")
@Api(description = "首页统计")
public class CompareStatisticController extends AbstractController {

    @Autowired
    private CompareStatisticDao compareStatisticDao;

    @Autowired
    private ICompareTaskService compareTaskService;

    @Autowired
    private ICompanyService     companyService;

    @ApiOperation(value = "比对日志统计信息", httpMethod = "GET", response = CompareStatisticVo.class)
    @RequestMapping(value = "/total.do", method = RequestMethod.GET)
    public RestResult getCompareStatistic() {
        
        CompareStatistic d = compareStatisticDao.selectByPrimaryKey(1L);
        CompareStatisticVo vo = BeanMapperUtil.map(d, CompareStatisticVo.class);

        DateTime create = new DateTime(d.getGmtCreate());
        DateTime now = new DateTime();
        int days = Days.daysBetween(create, now).getDays();
        vo.setRunnedDays(days);

        return RestResult.ok(vo);
    }

    @ApiOperation(value = "当前比对周期", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/current/ins.do", method = RequestMethod.GET)
    public RestResult getCurrentInstantlyTaskInfo() {
        
        Optional<CompareTask> opt = compareTaskService.getCurrentRunningTask(Constants.TASK_INSTANTLY_TYPE);
        Map<String, Object> map = Maps.newHashMap();

        // 已对比企业数量
        int total = 0;
        // 已对比项目数量
        int totalItem = 0;
        // 企业总数
        int totalCompany = 0;
        // 新增异常企业
        int increasedCompany = 0;

        if (opt.isPresent()) {
            CompareTask task = opt.get();
            total = task.getTotal();
            totalItem = task.getTotalItem();
            totalCompany = companyService.getTotalCompany();
            increasedCompany = task.getExIncreased();
        }
        map.put("percent", PercentUtil.calcIntPercent(totalCompany, total));
        map.put("total", total);
        map.put("totalItem", totalItem);
        map.put("totalCompany", totalCompany);
        map.put("increasedCompany", increasedCompany);
        
        return RestResult.ok(map);
    }
    
    @ApiOperation(value = "系统比对成效", httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/ex/statistics.do", method = RequestMethod.GET)
    public RestResult getExStatistics() {
        Map<String, Object> map = Maps.newHashMap();

        int insExNum = compareTaskService.getInsExNum();
        int annualExNum = compareTaskService.getAnnualExNum();
        int exNum = compareTaskService.getExNum();
        
        map.put("exTotal", exNum);
        map.put("insTotal", insExNum);
        map.put("annualTotal", annualExNum);
        return RestResult.ok(map);
    }
    
    
}












