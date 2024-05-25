package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto", length = 10, nullable = false)
    private int id_producto;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name="descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "imagen_url", length = 200, nullable = true)
    private String imagen_url;


    @Column(name="precio", nullable = true)
    private double precio;

    @Column(name="stock_dispo", nullable = true)
    private int stock_dispo;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<PagoProducto> pagosProductos;
}
