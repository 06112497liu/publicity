package com.bbd.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExDetailExtDao {

    /**
     * 将年报异常信息复制到历史记录表
     */
    void copyAnnualExToPre();

    /**
     * 删除年报异常
     */
    void deleteAnnualExDetail();

    /**
     * 删除年报异常历史
     */
    void deleteAnnualExDetailPrev();

    /**
     * 将年报异常信息复制到历史记录表
     */
    void copyInstantlyExToPre();

    /**
     * 删除年报异常
     */
    void deleteInstantlyExDetail();

    /**
     * 删除年报异常历史
     */
    void deleteInstantlyExDetailPrev();

    /**
     * 查询企业年报异常项
     *
     * @param nbxh
     * @return
     */
    List<Integer> selectAnnualExTypes(@Param("nbxh") String nbxh);

    /**
     * 查询企业即时信息异常项
     *
     * @param nbxh
     * @return
     */
    List<Integer> selectInstantlyExTypes(@Param("nbxh") String nbxh);

    /**
     * 查询企业即时信息模块
     *
     * @param nbxh
     * @return
     */
    List<Integer> selectAnnualExModules(@Param("nbxh") String nbxh);

    /**
     * 查询年报信息模块
     *
     * @param nbxh
     * @return
     */
    List<Integer> selectInstantlyExModules(@Param("nbxh") String nbxh);
}