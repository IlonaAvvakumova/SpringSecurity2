package com.SpringRest.repository;
import com.SpringRest.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Integer> {

}
