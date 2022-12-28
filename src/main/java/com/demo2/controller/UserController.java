package com.demo2.controller;

import com.demo2.model.User;
import com.demo2.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() throws JsonProcessingException {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id) throws IOException {
        return userService.getById(id);
    }

    @PostMapping("/create")
    @ResponseBody
    protected String create(@RequestBody User user) throws IOException {
        return "Created user: " + userService.create(user).toString();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    protected User update(@RequestBody User user, @PathVariable("id") int id) throws IOException {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") int id) {
        userService.deleteById(id);
    }
}