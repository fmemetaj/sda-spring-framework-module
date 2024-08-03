package com.java38.spring_framework.exercises.task1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component(value = "task1DummyLogger")
@Slf4j
public class DummyLogger implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Hello from task1");
    }
}
