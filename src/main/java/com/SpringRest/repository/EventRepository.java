package com.SpringRest.repository;
import com.SpringRest.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<EventEntity, Integer> {

}
