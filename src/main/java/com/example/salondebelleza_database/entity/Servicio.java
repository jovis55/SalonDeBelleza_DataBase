package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@ToString
public class Servicio implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio", length = 10, nullable = false)
    private int id_servicio;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name="duracion",  nullable = false)
    private double duracion;

    @Column(name="precio", nullable = true)
    private double precio;
}
