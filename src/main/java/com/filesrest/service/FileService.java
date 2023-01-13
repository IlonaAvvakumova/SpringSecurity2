package com.filesrest.service;

import com.filesrest.model.FileEntity;
import com.filesrest.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final FileRepository fileRep;

    public FileService(FileRepository fileRep) {
        this.fileRep = fileRep;
    }


    public List<FileEntity> getAll() {
        return fileRep.findAll();
    }


    public FileEntity getById(Integer id) {
        Optional<FileEntity> optional = fileRep.findById(id);
        return optional.orElse(null);
    }


    public FileEntity create(FileEntity fileEntity) {
        return fileRep.save(fileEntity);
    }


    public void deleteById(Integer id) {
        fileRep.deleteById(id);
    }
}
