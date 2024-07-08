package com.java38.spring_framework.value;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValueExample {

    private final ConfigurationClass configurationClass;
    private final ConfigurationValueExample configurationValueExample;

    public ValueExample(ConfigurationClass configurationClass,
                        ConfigurationValueExample configurationValueExample) {
        this.configurationClass = configurationClass;
        this.configurationValueExample = configurationValueExample;
        showConfigurationProperties();
    }

    public void showConfigurationProperties() {
        log.info("Class name: {}", configurationClass.getName());
        log.info("Class number of students: {}", configurationClass.getNumberOfStudents());

        log.info("Student name is: {}", configurationValueExample.getName());
    }

}
