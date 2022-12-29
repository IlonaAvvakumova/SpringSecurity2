package com.SpringRest.service;
import com.SpringRest.model.EventEntity;
import com.SpringRest.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.AliasFor;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.Mockito.*;


@SpringBootTest
public class EventServiceTest  {
    @Autowired
    public EventService eventService;


    @MockBean
    private EventRepository eventRepository;

    @Test
    @WithMockUser(roles = "ADMIN")
    void getAll() {

        eventService.getAll();
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void getById() {
        when(eventRepository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(new EventEntity()));
        eventService.getById(1);
        verify(eventRepository, times(1)).findById(1);
    }
}