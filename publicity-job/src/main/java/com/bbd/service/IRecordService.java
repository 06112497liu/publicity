package com.bbd.service;

/**
 * 做记录的service
 * @author Liuweibo
 * @version Id: IRecordService.java, v0.1 2017/12/28 Liuweibo Exp $$
 */
public interface IRecordService {

    /**
     * 将被删除的企业记录在一个新表里面
     */
    void recordDeletedCompany();

    /**
     * 更新bbd_pub_company_ex_item和表bbd_pub_company_ex_item_pre的del_flag字段
     */
    void updateDelFlag();
}
