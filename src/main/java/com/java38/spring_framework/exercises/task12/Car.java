package com.java38.spring_framework.exercises.task12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String brand;
    private String model;
    private int year;
}
