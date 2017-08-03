/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.common.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bbd.common.config.properties.JDBCProperties;
import com.mybatis.pagination.OffsetLimitInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis配置
 *
 * @author tjwang
 * @version $Id: MyBatisConfig.java, v 0.1 2017/7/5 0005 10:32 tjwang Exp $
 */
@Configuration
public class MyBatisConfig implements TransactionManagementConfigurer {

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Autowired
    private JDBCProperties jdbcProperties;

    @Bean
    public static OffsetLimitInterceptor offsetLimitInterceptor() {
        OffsetLimitInterceptor offsetLimitInterceptor = new OffsetLimitInterceptor();
        offsetLimitInterceptor.setDialectClass("com.mybatis.dialect.MySQLDialect");
        return offsetLimitInterceptor;
    }

    @Bean("dataSource")
    public DataSource dataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", jdbcProperties.getDriverClassName());
        props.put("url", jdbcProperties.getUrl());
        props.put("username", jdbcProperties.getName());
        props.put("password", jdbcProperties.getPassword());
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds); // 指定数据源
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));

        fb.setPlugins(new Interceptor[]{offsetLimitInterceptor()});

        return fb.getObject();
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        try {
            return new DataSourceTransactionManager(dataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("annotationDrivenTransactionManager 异常");
    }

}
