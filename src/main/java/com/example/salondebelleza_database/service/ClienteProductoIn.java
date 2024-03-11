package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.ClienteProducto;
import com.example.salondebelleza_database.service.excepciones.AttributeException;

import java.util.List;

public interface ClienteProductoIn {
    ClienteProducto crearClienteProducto(ClienteProducto clienteProducto) throws AttributeException;
    ClienteProducto actualizarClienteProducto(ClienteProducto clienteProducto) throws AttributeException;
    ClienteProducto obtenerClienteProducto(Long id) throws AttributeException;
    void eliminarClienteProducto(Long id) throws AttributeException;
    List<ClienteProducto> listarClienteProductos() throws AttributeException;
}

