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
}
    
    