package com.filesrest.service;

import com.filesrest.model.EventEntity;
import com.filesrest.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRep;

    public EventService(EventRepository eventRep) {
        this.eventRep = eventRep;
    }

    public List<EventEntity> getAll() {
        return eventRep.findAll();
    }

    public EventEntity getById(Integer id) {
        Optional<EventEntity> optional = eventRep.findById(id);
        return optional.orElse(null);
    }
}
