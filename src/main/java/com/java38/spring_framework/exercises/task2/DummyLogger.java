package com.java38.spring_framework.exercises.task2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component(value = "task2DummyLogger")
@Slf4j
public class DummyLogger {

    public void sayHello() {
        log.info("Hello from dummy logger!");
    }
}
