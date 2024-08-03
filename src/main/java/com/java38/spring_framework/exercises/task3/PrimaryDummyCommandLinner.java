package com.java38.spring_framework.exercises.task3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class PrimaryDummyCommandLinner implements CommandLineRunner {

    private DummyLogger dummyLogger;

    public PrimaryDummyCommandLinner(DummyLogger dummyLogger) {
        this.dummyLogger = dummyLogger;
    }
    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
