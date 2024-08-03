package com.java38.spring_framework.exercises.task12;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping
    public List<Car> getCars() {
        return List.of(
                new Car("Mercedes", "C-class", 2020),
                new Car("Audi", "A8", 2022));
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return car;
    }
}
