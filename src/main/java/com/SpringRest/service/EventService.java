package com.SpringRest.service;

import com.SpringRest.model.Event;
import com.SpringRest.repository.EventRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRep;

    public EventService(EventRepository eventRep) {
        this.eventRep = eventRep;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public List<Event> getAll() {
        return eventRep.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public Event getById(Integer id) {
       Optional<Event> optional =  eventRep.findById(id);
       return optional.orElse(null);
    }
}
