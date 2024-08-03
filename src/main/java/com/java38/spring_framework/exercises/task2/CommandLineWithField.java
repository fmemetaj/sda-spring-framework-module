package com.java38.spring_framework.exercises.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineWithField implements CommandLineRunner {

    @Autowired
    private DummyLogger dummyLogger;

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
