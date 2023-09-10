package com.example.crud.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String descripcion;

    private LocalDateTime fechaCreacion;

    private boolean vigente;

    public String getName() {
        return null;
    }
}
