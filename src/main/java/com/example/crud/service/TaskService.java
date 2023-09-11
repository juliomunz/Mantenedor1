package com.example.crud.service;


import com.example.crud.entity.Task;
import com.example.crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    HashMap<String, Object> datos;

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this. taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return this.taskRepository.findAll();
    }

    public ResponseEntity<Object> newTask (Task task){
        Optional<Task> respuesta = taskRepository.findTaskByNombre(task.getNombre());

        datos = new HashMap<>();

        if (respuesta.isPresent() && task.getId()==null){
            datos.put("error", true);
            datos.put("message", "Ya existe una tarea con este nombre");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "Se guardó con éxito");
        if(task.getId()!=null){
            datos.put("message","Se actualizó con éxito");
        }
        taskRepository.save(task);
        datos.put("payload", task);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteTask(Long id){
        datos = new HashMap<>();
        boolean existe = this.taskRepository.existsById(id);
        if(!existe){
            datos.put("error", true);
            datos.put("mesagge", "No existe una tarea con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        taskRepository.deleteById(id);
        datos.put("mesagge", "Tarea Eliminada");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

}
