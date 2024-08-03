package com.java38.spring_framework.exercises.task3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SecondaryDummyCommandLinner implements CommandLineRunner {

    private DummyLogger dummyLogger;

    public SecondaryDummyCommandLinner(@Qualifier(value = "secondaryDummyLogger") DummyLogger dummyLogger) {
        this.dummyLogger = dummyLogger;
    }

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
