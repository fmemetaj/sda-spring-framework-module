package com.java38.spring_framework.exercises.task6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PersonPropertiesCommandLine implements CommandLineRunner {

    private final PersonProperties personProperties;

    public PersonPropertiesCommandLine(PersonProperties personProperties) {
        this.personProperties = personProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Person properties: {}", personProperties.toString());
    }
}
