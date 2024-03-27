package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ciudad", length = 10, nullable = false)
    private int id_ciudad;

    @Column(name="nombre", length = 40, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
    private List<Empleado> empleados;

}
