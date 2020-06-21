package com.sh.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sh
 * @date 2020-03-13 11:22
 */
@Configuration
public class TestBeanConfig {

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public TestBean testBean() {
        return new TestBean();
    }
}
