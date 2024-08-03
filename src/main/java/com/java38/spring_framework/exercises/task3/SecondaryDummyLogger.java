package com.java38.spring_framework.exercises.task3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondaryDummyLogger implements DummyLogger {
    @Override
    public void sayHello() {
        log.info("Hello from Secondary Dummy Logger");
    }
}
