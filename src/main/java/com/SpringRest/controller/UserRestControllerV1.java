package com.SpringRest.controller;

import com.SpringRest.model.UserEntity;
import com.SpringRest.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {

    private final UserService userService;

    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR') ")
    public List<UserEntity> getAll() throws JsonProcessingException {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_USER')")
    public UserEntity getById(@PathVariable("id") int id) throws IOException {
        return userService.getById(id);
    }

    @PostMapping("/create")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    protected String create(@RequestBody UserEntity user) throws IOException {
        return "Created user: " + userService.create(user).toString();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')  ")
    protected UserEntity update(@RequestBody UserEntity user, @PathVariable("id") int id) throws IOException {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    protected void delete(@PathVariable("id") int id) {
        userService.deleteById(id);
    }
}