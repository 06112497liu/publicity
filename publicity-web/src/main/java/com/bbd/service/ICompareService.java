/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service;

/**
 * 对比服务
 *
 * @author tjwang
 * @version $Id: ICompareService.java, v 0.1 2017/7/10 0010 17:13 tjwang Exp $
 */
public interface ICompareService {

    /**
     * 对比
     *
     * @param taskId
     * @param nbxh
     * @return 对比了多少项
     */
    void compare(long taskId, String nbxh);

}
