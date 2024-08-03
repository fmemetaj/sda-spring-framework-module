package com.java38.spring_framework.exercises.task13;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservations")
public class Reservation {

    @Id
    private Long id;

    @Size(min = 2, max = 20)
    private String name;
    private String hotelName;
    private Integer numberOfPeople;
    private Standard standard;
    private Float price;
    private LocalDate startDate;
    private LocalDate endDate;
}
