
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.service.param.report; 
/** 
 *  
 * @author liuweibo 
 * @version $Id: WebInfo.java, v 0.1 2017年9月5日 上午10:50:23 liuweibo Exp $ 
 */
public class WebInfo {
    
    /** 行号 */
    private Integer line;
    
    /** 网站名称 */
    private String name;
    
    /** 类型   */
    private String type;
    
    /** 网址   */
    private String url;

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}

