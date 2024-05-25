package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
public class Especialidad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_especialidad", length = 10, nullable = false)
    private int id_especialidad;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;


}
