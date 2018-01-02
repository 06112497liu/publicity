package com.bbd.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 记录信息dao层
 * @author Liuweibo
 * @version Id: DeletedCompanyRecordExtDao.java, v0.1 2017/12/28 Liuweibo Exp $$
 */
public interface RecordMsgDao {

    /**
     * 删除表
     * @param tableName
     */
    void truncateTable(@Param("tableName") String tableName);

    /**
     * 记录被删除公司的nbxh
     */
    void recordDeletedCompany();

    /**
     * 初始化bbd_pub_company_ex_item表的del_flag字段的值：0
     */
    void initExItemDelFlag();

    /**
     * 初始化bbd_pub_company_ex_item_pre表的del_flag字段的值：0
     */
    void initExItemPreDelFlag();

    /**
     * 更新bbd_pub_company_ex_item的del_flag字段
     */
    void updateExItemDelFlag();

    /**
     * 更新bbd_pub_company_ex_item_pre的del_flag字段
     */
    void updateExItemPreDelFlag();
}
    
    