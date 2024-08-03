package com.java38.spring_framework.exercises.task11;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PCGameForm {

    private String title;
    private String producer;
    private String genre;
    private Integer minimumAge;
    private Boolean isAAA;
}
