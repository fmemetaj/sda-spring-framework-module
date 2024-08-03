package com.java38.spring_framework.exercises.task4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfiguration {

    @Bean
    public DummyLogger dummyLogger() {
        return new DummyLogger();
    }

    @Bean
    public ListUtil listUtil() {
        return new ListUtil();
    }

    @Bean
    public StringUtil stringUtil() {
        return new StringUtil();
    }
}
