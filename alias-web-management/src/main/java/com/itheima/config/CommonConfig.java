package com.itheima.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 配置类
public class CommonConfig {

    // 申明第三方　bean
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }

}
