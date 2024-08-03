package com.java38.spring_framework.exercises.task9;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/files-data")
public class FileDataController {

    private final FileDataService fileDataService;

    public FileDataController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @GetMapping
    public ResponseEntity<FileDataCollection> getAllFileDatas() {
        return ResponseEntity.ok(fileDataService.getAllFileDatas());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<FileData> getFileDataById(@PathVariable UUID id) {
        return ResponseEntity.ok(fileDataService.getFileDataById(id));
    }

    @PostMapping
    public ResponseEntity<FileData> createFileData(@RequestBody FileData fileData) {
        return ResponseEntity.ok(fileDataService.createFileData(fileData));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<FileData> updateFileData(@PathVariable UUID id, @RequestBody FileData fileData) {
        return ResponseEntity.ok(fileDataService.updateFileData(id, fileData));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteFileData(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }
}
