package com.java38.spring_framework.lectures.restapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    private String name;
    private String description;
    private int minutes;


}
