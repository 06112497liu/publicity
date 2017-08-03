
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.exception;

import com.exception.ErrorCode;

/** 
 *  
 * @author liuweibo 
 * @version $Id: PubErrorCode.java, v 0.1 2017年7月18日 下午5:34:48 liuweibo Exp $ 
 */
public enum PubErrorCode implements ErrorCode {
    
    OPERATION_RUNDATE_ERROR(6001, "查询对象不存在");

    private int    status;
    private String message;    
    
    /**
     * @param status
     * @param message 
     */
    private PubErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
    /**
     *
     * @see com.exception.ErrorCode#getStatus() 
     */
    @Override
    public int getStatus() {
        return this.status;
    }
    /**
     *
     * @see com.exception.ErrorCode#getMessage() 
     */
    @Override
    public String getMessage() {
        return this.message;
    }
    
}

