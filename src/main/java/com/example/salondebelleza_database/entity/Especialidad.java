package com.example.salondebelleza_database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

public class Especialidad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_especialidad", length = 10, nullable = false)
    private int id_especialidad;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

}
