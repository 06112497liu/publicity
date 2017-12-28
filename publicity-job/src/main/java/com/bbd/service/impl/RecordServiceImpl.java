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
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private RecordMsgDao recordMsgDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void recordDeletedCompany() {
        recordMsgDao.truncateTable("bbd_deleted_company_record");
        recordMsgDao.recordDeletedCompany();
    }
}
    
    