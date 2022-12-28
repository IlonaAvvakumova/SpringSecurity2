package com.demo2.service;
import com.demo2.model.User;
import com.demo2.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

   @MockBean
   
    UserRepository userRepository;

    User user;

    @Test
    void getAll() {
        userService.getAll();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getById() {
        when(userRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(new User()));
        userService.getById(1);
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void create() {
        when(userRepository.save(Mockito.mock(User.class))).thenReturn(user);
        userService.create(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void update() {
        when(userRepository.save(Mockito.mock(User.class))).thenReturn(user);
        userService.create(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void deleteById() {
        userService.deleteById(1);
        verify(userRepository, times(1)).deleteById(1);
    }
}