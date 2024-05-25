package com.example.salondebelleza_database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleado_servicio") // Nombre de la tabla intermedia
@Getter
@Setter
@ToString
public class EmpleadoServicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_servicio", nullable = false)
    private Long idEmpleadoServicio;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) // Nombre de la columna que referencia al empleado
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false) // Nombre de la columna que referencia al servicio
    private Servicio servicio;

    @OneToMany(mappedBy = "empleadoServicio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita la serialización recursiva
    private List<Cita> citas = new ArrayList<>();


}

