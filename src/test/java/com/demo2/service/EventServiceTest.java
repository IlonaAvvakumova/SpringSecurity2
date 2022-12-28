package com.demo2.service;
import com.demo2.model.Event;
import com.demo2.model.User;
import com.demo2.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class EventServiceTest {
    @Autowired
    public EventService eventService;


    @MockBean
    private EventRepository eventRepository;

    @Test
    void getAll() {

        eventService.getAll();
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    void getById() {
        when(eventRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(new Event()));
        eventService.getById(1);
        verify(eventRepository, times(1)).findById(1);
    }
}