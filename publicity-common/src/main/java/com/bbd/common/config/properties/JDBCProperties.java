/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tjwang
 * @version $Id: JDBCProperties.java, v 0.1 2017/7/5 0005 14:07 tjwang Exp $
 */
@Component
@ConfigurationProperties(prefix = "jdbc")
public class JDBCProperties {

    private String driverClassName;

    private String url;

    private String name;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
