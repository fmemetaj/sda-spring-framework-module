package com.java38.spring_framework.exercises.task3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BothCommandLineRunner implements CommandLineRunner {

    private List<DummyLogger> dummyLoggers;

    public BothCommandLineRunner(List<DummyLogger> dummyLoggers) {
        this.dummyLoggers = dummyLoggers;
    }
    @Override
    public void run(String... args) throws Exception {
        dummyLoggers.forEach(DummyLogger::sayHello);
    }
}
