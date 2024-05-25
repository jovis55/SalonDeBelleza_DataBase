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

public class Factura implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura", length = 10, nullable = false)
    private int id_factura;


    @Column(name="fecha", nullable = true)
    private LocalDateTime fecha;


    @Enumerated(EnumType.STRING)
    @Column(name = "estado_venta", length = 20, nullable = false)
    private Estado_venta estado_venta;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;
}
