package com.SpringRest.controller;

import com.SpringRest.model.Event;
import com.SpringRest.model.FileEntity;
import com.SpringRest.model.User;
import com.SpringRest.service.FileService;
import com.SpringRest.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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