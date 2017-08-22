/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.impl;

import com.bbd.domain.PubCompanyInfo;
import com.bbd.service.ICompanyService;
import com.bbd.service.ICompareService;
import com.bbd.service.ICompareTaskService;
import com.bbd.service.compare.CompareProperty;
import com.bbd.util.StringUtils;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 对比服务
 *
 * @author tjwang
 * @version $Id: AbstractCompareService.java, v 0.1 2017/7/17 0017 13:44 tjwang Exp $
 */
public abstract class AbstractCompareService implements ICompareService {

    @Autowired
    protected ICompanyService     companyService;

    @Autowired
    protected ICompareTaskService compareTaskService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void compare(long taskId, String nbxh) {
        Preconditions.checkArgument(StringUtils.isNotBlank(nbxh), "内部序号不能为空");

        Optional<PubCompanyInfo> opt = companyService.queryByNbxh(nbxh);
        if (!opt.isPresent()) {
            return;
        }

        PubCompanyInfo info = opt.get();
        List<CompareProperty> props = getCompareProperties(info);
        int exNum = validate(info, props);
        createOrUpdateCompanyExItem(info, exNum);

        boolean isException = exNum > 0;
        // 更新本轮新增和退出企业数量
        updateExIncreasedAndDecreased(taskId, nbxh, isException);
        compareTaskService.updateCompareTaskInfo(taskId, nbxh, props.size());
        // 判断对比之后，企业是否异常
        updateCompareStatisticsCount(props.size(), isException);
    }

    /**
     * 后去对比属性
     *
     * @param c
     * @return
     */
    protected abstract List<CompareProperty> getCompareProperties(PubCompanyInfo c);

    protected abstract void addExDetail(PubCompanyInfo c, CompareProperty p, int r);

    /**
     * 校验对比属性
     *
     * @param c
     * @param props
     * @return
     */
    protected int validate(PubCompanyInfo c, List<CompareProperty> props) {
        if (props == null || props.isEmpty()) {
            return 0;
        }
        // 异常项数量
        int exNum = 0;
        for (CompareProperty p : props) {
            int r = p.compare();
            if (r == 0) {
                continue;
            }
            exNum++;
            addExDetail(c, p, r);
        }
        return exNum;
    }

    /**
     * 更新或创建异常项信息
     *
     * @param c
     * @param num
     */
    protected abstract void createOrUpdateCompanyExItem(PubCompanyInfo c, int num);

    /**
     * 更新统计信息
     *
     * @param itemCount
     */
    protected abstract void updateCompareStatisticsCount(int itemCount, boolean flag);

    /**
     * 更新异常企业新增数量信息
     *
     * @param taskId
     */
    protected void updateExIncreasedAndDecreased(long taskId, String nbxh, boolean isException) {

    }

}
