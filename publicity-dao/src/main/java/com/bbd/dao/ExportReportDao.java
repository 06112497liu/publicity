package com.bbd.dao;

import com.bbd.vo.ExDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报告导出dao层
 * @author Liuweibo
 * @version Id: ExportReportDao.java, v0.1 2017/9/18 Liuweibo Exp $$
 */
public interface ExportReportDao {

    /**
     * 查询指定nbxh的企业异常详情(年报)
     * @param nbxhs
     * @return
     */
    List<ExDetailVo> queryAnnualAllByParam(@Param("nbxhs") String nbxhs);

    /**
     * 查询指定nbxh的企业异常详情(年报)
     * @param nbxhs
     * @return
     */
    List<ExDetailVo> queryInsAllByparam(@Param("nbxhs") String nbxhs);
}
    
    