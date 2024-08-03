package com.java38.spring_framework.exercises.task4;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    public String fromSentence(List<String> words) {
        return words.stream().collect(Collectors.joining(" ", "", "."));
    }
}
