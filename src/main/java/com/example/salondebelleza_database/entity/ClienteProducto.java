package com.example.salondebelleza_database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "cliente_producto") // Nombre de la tabla intermedia
@Getter
@Setter
@ToString
public class ClienteProducto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_producto", nullable = false)
    private Long idClienteProducto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) // Nombre de la columna que referencia al empleado
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false) // Nombre de la columna que referencia al producto
    private Producto producto;

    // Otros atributos y métodos si es necesario
}
