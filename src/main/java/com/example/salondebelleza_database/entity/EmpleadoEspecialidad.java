package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "empleado_especialidad") // Nombre de la tabla intermedia
@Getter
@Setter
@ToString
public class EmpleadoEspecialidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_especialidad", nullable = false)
    private Long idEmpleadoEspecialidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) // Nombre de la columna que referencia al empleado
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false) // Nombre de la columna que referencia a la especialidad
    private Especialidad especialidad;

    // Otros atributos y métodos si es necesario
}
