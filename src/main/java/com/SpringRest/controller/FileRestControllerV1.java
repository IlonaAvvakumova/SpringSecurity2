package com.SpringRest.controller;

import com.SpringRest.model.EventEntity;
import com.SpringRest.model.FileEntity;
import com.SpringRest.model.UserEntity;
import com.SpringRest.service.FileService;
import com.SpringRest.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/files")
public class FileRestControllerV1 {

    private final FileService fileService;
    @Autowired
    private final UserService userService;

    public FileRestControllerV1(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public List<FileEntity> getAll() throws JsonProcessingException {
        List<FileEntity> files = fileService.getAll();
        return files;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public FileEntity getById(@PathVariable("id") int id) throws IOException {
        FileEntity files = fileService.getById(id);
        return files;
    }

    @PostMapping("/create")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    protected String create(@RequestBody FileEntity fileEntity, @RequestHeader(value = "user_id") Integer id) {
        UserEntity user = userService.getById(id);
        List<EventEntity> eventEntities = new ArrayList<>();
        EventEntity event = new EventEntity();
        event.setFileEntity(fileEntity);
        event.setUser(user);
        eventEntities.add(event);
        user.setEventEntities(eventEntities);
        userService.update(user);
        return "Created file: " + fileEntity.toString();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    protected void delete(@PathVariable("id") int id) {
        fileService.deleteById(id);
    }


}