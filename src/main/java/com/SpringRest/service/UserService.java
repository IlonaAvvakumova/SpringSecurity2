package com.SpringRest.service;

import com.SpringRest.model.User;
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

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR') ")
    public List<User> getAll() {
        return userRep.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_USER')")
    public User getById(Integer id) {
        Optional<User> optional = userRep.findById(id);
        return optional.orElse(null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User create(User user) {
        user.setPassword("user");
        return userRep.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')  ")
    public User update(User user) {
        return userRep.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(Integer id) {
        userRep.deleteById(id);
    }
}
