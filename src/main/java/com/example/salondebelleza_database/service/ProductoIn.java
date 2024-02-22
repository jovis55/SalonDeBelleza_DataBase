package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Producto;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoIn {

    Producto crearProducto(Producto producto) throws AttributeException;

    Producto actualizarProducto(Producto producto) throws AttributeException;

    Producto obtenerProducto(int idProducto) throws AttributeException;

    List<Producto> listarProductos() throws AttributeException;

    void eliminarProducto(int idProducto) throws AttributeException;

    boolean existeProducto(int idProducto);
}

