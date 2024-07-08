package com.java38.spring_framework.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class ConfigurationValueExample {

    @Value("${student.name}")
    private String name;
}
