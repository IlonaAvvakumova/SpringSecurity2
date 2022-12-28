package com.demo2.controller;

import com.demo2.model.Event;
import com.demo2.model.FileEntity;
import com.demo2.model.User;
import com.demo2.service.FileService;
import com.demo2.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private final FileService fileService;
    @Autowired
    private final UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping
    public List<FileEntity> getAll() throws JsonProcessingException {
        List<FileEntity> files = fileService.getAll();
        return files;
    }

    @GetMapping("/{id}")
    public FileEntity getById(@PathVariable("id") int id) throws IOException {
        FileEntity files = fileService.getById(id);
        return files;
    }

    @PostMapping("/create")
    @ResponseBody
    protected String create(@RequestBody FileEntity fileEntity, @RequestHeader(value = "user_id") Integer id) {
        User user = userService.getById(id);
        List<Event> eventEntities = new ArrayList<>();
        Event event = new Event();
        event.setFileEntity(fileEntity);
        event.setUser(user);
        eventEntities.add(event);
        user.setEventEntities(eventEntities);
        userService.update(user);
        return "Created file: " + fileEntity.toString();
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") int id) {
        fileService.deleteById(id);
    }


}