package com.java38.spring_framework.exercises.task6;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "pl.sdacademy.zad6")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@ToString
public class PersonProperties {

    @Email
    @NotNull(message = " Email cannot be null")
    private String email;

    @NotNull(message = " First name cannot be null")
    private String firstName;

    @Size(min=3,max=20)
    @NotNull(message = " Last name cannot be null")
    private String lastName;

    @NotNull(message = " Address cannot be null")
    private String address;

    @Min(18)
    private int age;

    @NotEmpty(message = "values cannot be empty")
    private List<String> values;

    @NotEmpty(message = "Custom attributes cannot be empty")
    private Map<String,String> customAttributes;
}
