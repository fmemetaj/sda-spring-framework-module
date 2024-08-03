package com.java38.spring_framework.exercises.task8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/random-boolean")
public class RandomBooleanController {

    private RandomBooleanProvider randomBooleanProvider;

    public RandomBooleanController(RandomBooleanProvider randomBooleanProvider) {
        this.randomBooleanProvider = randomBooleanProvider;
    }

    @GetMapping
    public boolean randomBoolean() {
        return randomBooleanProvider.getValue();
    }

}
