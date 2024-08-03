package com.java38.spring_framework.exercises.task2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineWithConstructor implements CommandLineRunner {

    private final DummyLogger dummyLogger;

    public CommandLineWithConstructor(DummyLogger dummyLogger) {
        this.dummyLogger = dummyLogger;
    }

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
