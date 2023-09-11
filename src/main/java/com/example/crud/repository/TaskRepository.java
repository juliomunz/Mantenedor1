package com.example.crud.repository;

import com.example.crud.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long>{

    Optional<Task> findTaskByNombre(String nombre);
}
