package com.example.crud.controller;

import com.example.crud.entity.Task;
import com.example.crud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> findAll(){
        return this.taskService.getTasks();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createTask(@RequestBody Task task){
        return this.taskService.newTask(task);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateTask(@RequestBody Task task) {
        return this.taskService.newTask(task);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable ("id") Long id){
        return this.taskService.deleteTask(id);
    }


}
