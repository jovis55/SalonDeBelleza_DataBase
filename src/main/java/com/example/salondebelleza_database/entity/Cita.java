package com.example.salondebelleza_database.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cita", length = 10, nullable = false)
    private int id_cita;

    @Column(name="motivoCita", length = 400, nullable = false)
    private String motivoCita;
    
    @Column(name="estado", length = 100, nullable = false)
    private String estado;

    @Column(name="fecha_creacion", nullable = true)
    private LocalDateTime fecha_creacion;

    @Column(name="fecha_cita", nullable = true)
    private LocalDateTime fecha_cita;

    @Column(name="duracion", nullable = true)
    private double duracion;

    @ManyToOne // Many-to-One con EmpleadoServicio
    @JoinColumn(name = "id_empleado_servicio") // Columna en esta entidad que hace referencia a EmpleadoServicio
    private EmpleadoServicio empleadoServicio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;


    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // Evita la recursión infinita
    private Pago pago;


}
