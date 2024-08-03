package com.java38.spring_framework.exercises.task9;

import com.java38.spring_framework.lectures.exceptions.SdaException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FileDataService {

    private final FileDataRepository fileDataRepository;

    public FileDataService(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

    public FileDataCollection getAllFileDatas() {
        List<FileData> fileDatas = fileDataRepository.findAll();
        return new FileDataCollection(fileDatas);
    }

    public FileData getFileDataById(UUID id) {
        return fileDataRepository.findById(id)
                .orElseThrow(() -> new SdaException("Cannot find file data with given id"));
    }

    public FileData createFileData(FileData fileData) {
        fileData.setId(null);
        return fileDataRepository.save(fileData);
    }

    public FileData updateFileData(UUID id, FileData fileData) {
        FileData existingFileData = getFileDataById(id);

        existingFileData.setFileName(fileData.getFileName());
        existingFileData.setExtension(fileData.getExtension());
        existingFileData.setSizeInKb(fileData.getSizeInKb());
        existingFileData.setContent(fileData.getContent());

        return fileDataRepository.save(existingFileData);
    }

    public void deleteFileDataById(UUID id) {
        getFileDataById(id);
        fileDataRepository.deleteById(id);
    }
}
