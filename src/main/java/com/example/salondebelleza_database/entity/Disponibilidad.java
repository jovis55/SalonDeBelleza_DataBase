package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disponibilidad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDisponibilidad", length = 10, nullable = false)
    private int idDisponibilidad;

    @Column(name="fecha", nullable = false)
    private Date fecha;

    @Column(name="hora", length = 100, nullable = false)
    private String hora;

    @Column(name="estado", length = 100, nullable = false)
    private String estado;



    @ManyToOne
    private Empleado empleado;

}