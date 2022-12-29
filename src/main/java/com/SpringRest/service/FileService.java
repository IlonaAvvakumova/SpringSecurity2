package com.SpringRest.service;

import com.SpringRest.model.FileEntity;
import com.SpringRest.repository.FileRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final FileRepository fileRep;

    public FileService(FileRepository fileRep) {
        this.fileRep = fileRep;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public List<FileEntity> getAll() {
        return fileRep.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public FileEntity getById(Integer id) {
        Optional<FileEntity> optional = fileRep.findById(id);
        return optional.orElse(null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public FileEntity create(FileEntity fileEntity) {
        return fileRep.save(fileEntity);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public void deleteById(Integer id) {
        fileRep.deleteById(id);
    }
}
