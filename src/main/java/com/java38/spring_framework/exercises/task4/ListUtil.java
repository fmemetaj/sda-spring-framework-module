package com.java38.spring_framework.exercises.task4;

import java.util.List;

public class ListUtil {

    public int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
