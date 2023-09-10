package com.example.crud.service;


import com.example.crud.entity.Task;
import com.example.crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this. taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return this.taskRepository.findAll();
    }

    public void newTask(Task task){
        Optional<Task> respuesta = taskRepository.findTaskByName(task.getName());
        if (respuesta.isPresent()){
            throw new IllegalStateException("Ya existe tarea");
        }
        taskRepository.save(task);
    }
}
