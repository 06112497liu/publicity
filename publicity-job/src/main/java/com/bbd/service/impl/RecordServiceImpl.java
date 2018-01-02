package com.bbd.service.impl;

import com.bbd.dao.RecordMsgDao;
import com.bbd.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Liuweibo
 * @version Id: IRecordServiceImpl.java, v0.1 2017/12/28 Liuweibo Exp $$
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private RecordMsgDao recordMsgDao;

    @Override
    public void recordDeletedCompany() {
        recordMsgDao.truncateTable("bbd_deleted_company_record");
        recordMsgDao.recordDeletedCompany();
    }

    @Override
    public void updateDelFlag() {
        // step-1：记录被移除的公司的nbxh
        recordDeletedCompany();

        // step-2：更新del_flag字段的值
            // bbd_pub_company_ex_item表
        recordMsgDao.initExItemDelFlag();
        recordMsgDao.updateExItemDelFlag();
            // bbd_pub_company_ex_item_pre表
        recordMsgDao.initExItemPreDelFlag();
        recordMsgDao.updateExItemPreDelFlag();
    }
}
    
    