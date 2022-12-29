package com.SpringRest.controller;

import com.SpringRest.model.Event;
import com.SpringRest.service.EventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable("id") int id) throws IOException {
        return eventService.getById(id);
    }

    @GetMapping
    public List<Event> getAll() throws JsonProcessingException {
        List<Event> eventEntities = eventService.getAll();
        return eventEntities;
    }
}

