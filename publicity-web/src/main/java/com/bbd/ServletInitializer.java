package com.bbd;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Liuweibo
 * @version Id: ServletInitializer.java, v0.1 2018/1/2 Liuweibo Exp $$
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootMvcApplication.class);
    }
}
    
    