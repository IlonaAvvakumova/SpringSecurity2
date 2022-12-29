package com.SpringRest.repository;
import com.SpringRest.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<FileEntity, Integer> {

}
