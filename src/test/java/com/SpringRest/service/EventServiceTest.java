package com.SpringRest.service;
import com.SpringRest.model.Event;
import com.SpringRest.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class EventServiceTest  {
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