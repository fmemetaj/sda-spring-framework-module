package com.java38.spring_framework.exercises.task9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDataCollection {
    private List<FileData> fileDataList;
}
