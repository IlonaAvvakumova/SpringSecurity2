package com.SpringRest.service;

import com.SpringRest.model.UserEntity;
import com.SpringRest.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRep;

    public UserService(UserRepository userRep) {
        this.userRep = userRep;
    }


    public List<UserEntity> getAll() {
        return userRep.findAll();
    }


    public UserEntity getById(Integer id) {
        Optional<UserEntity> optional = userRep.findById(id);
        return optional.orElse(null);
    }


    public UserEntity create(UserEntity user) {
        user.setPassword("user");
        return userRep.save(user);
    }


    public UserEntity update(UserEntity user) {
        return userRep.save(user);
    }


    public void deleteById(Integer id) {
        userRep.deleteById(id);
    }
}
