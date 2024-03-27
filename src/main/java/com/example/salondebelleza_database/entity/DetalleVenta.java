package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_venta", length = 10, nullable = false)
    private int id_detalle_venta;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name="cantidad", nullable = false)
    private int cantidad;

    @Column(name="precio_unitario", nullable = false)
    private double precio_unitario;

    // Constructor, getters y setters
}
