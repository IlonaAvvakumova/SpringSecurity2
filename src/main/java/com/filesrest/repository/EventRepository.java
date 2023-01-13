package com.filesrest.repository;
import com.filesrest.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<EventEntity, Integer> {

}
