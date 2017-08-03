package com.bbd;

import com.google.common.collect.Lists;
import com.mybatis.jackson2.PageListJsonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.bbd")
@MapperScan(basePackages = "com.bbd.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class SpringbootMvcApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMvcApplication.class, args).start();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);

        Iterator<HttpMessageConverter<?>> iter = converters.iterator();
        while (iter.hasNext()) {
            if (iter.next() instanceof MappingJackson2HttpMessageConverter) {
                iter.remove();
            }
        }
        MappingJackson2HttpMessageConverter c = new MappingJackson2HttpMessageConverter();

        PageListJsonMapper mapper = new PageListJsonMapper();
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        MediaType mediaType2 = new MediaType("application", "*+json", Charset.forName("UTF-8"));
        c.setSupportedMediaTypes(Lists.newArrayList(mediaType, mediaType2));
        c.setObjectMapper(mapper);

        converters.add(c);
    }
}
