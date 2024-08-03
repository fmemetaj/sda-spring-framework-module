package com.java38.spring_framework.lectures.value;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "java38")
public class ConfigurationClass {

    private String name;
    private int numberOfStudents;

}
