package com.example.salondebelleza_database.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS )
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(name="id_usuario", length = 10, nullable = false)
    private String id_usuario;

    @Column(name="contrasena", length = 20, nullable = false)
    private String contrasena;

    @Column(name="email", length = 50, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", length = 10, nullable = false)
    private Tipo_usuario tipo_usuario;

}
