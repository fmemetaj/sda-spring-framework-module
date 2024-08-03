package com.java38.spring_framework.exercises.task7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/pairs")
public class PairsController {

    @GetMapping("{name}")
    public NamedPairs getPairs(@PathVariable String name) {
        return NamedPairs.builder()
                .name(name)
                .pairs(Map.of())
                .build();
    }
}
