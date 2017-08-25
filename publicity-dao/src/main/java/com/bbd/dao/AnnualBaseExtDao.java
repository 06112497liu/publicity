
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.dao;

import com.bbd.domain.AnnualBase;
import org.apache.ibatis.annotations.Param;

/** 
 *  
 * @author liuweibo 
 * @version $Id: AnnualBaseCmpExtDao.java, v 0.1 2017年7月17日 下午2:41:49 liuweibo Exp $ 
 */
public interface AnnualBaseExtDao {

    /**
     * 查询企业最近的一条年报数据（根据nbxh）
     * @param name
     * @param pb
     * @return
     */
    AnnualBase selectRecentlyAnnualInfoByNbxh(@Param("nbxh") String nbxh);
    
    /**
     * 查询企业最近的一条年报数据（根据regno）
     * @param name
     * @param pb
     * @return
     */
    AnnualBase selectRecentlyAnnualInfoByRegno(@Param("code") String code);
    
}

