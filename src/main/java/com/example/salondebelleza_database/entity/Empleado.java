package com.example.salondebelleza_database.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_usuario")

public class Empleado extends Usuario implements Serializable {
    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="telefono", length = 20, nullable = false)
    private String telefono;
    @Column(name="direccion", length = 200, nullable = false)
    private String direccion;

    @Column(name="fecha_nacimiento", nullable = true)
    private Date fecha_nacimiento;

    @Column(name = "imagen_url", length = 200, nullable = true)
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;
}
