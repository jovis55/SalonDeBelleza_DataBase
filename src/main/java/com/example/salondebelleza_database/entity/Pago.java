package com.example.salondebelleza_database.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

public class Pago implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pago", length = 10, nullable = false)
    private int id_pago;

    @Column(name="metodo_pago", length = 20, nullable = false)
    private String metodo_pago;

    @Column(name="estado", length = 100, nullable = false)
    private String estado;

    @Column(name="fecha_pago", nullable = true)
    private LocalDateTime fecha_pago;

    @Column(name="monto", nullable = true)
    private double monto;

    @OneToOne
    @JoinColumn(name = "id_cita")
    @JsonManagedReference // Evita la recursión infinita
    private Cita cita;


}
