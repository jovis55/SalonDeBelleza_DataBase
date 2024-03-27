package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Factura;

import java.util.List;

public interface FacturaIn {
    Factura crearFactura(Factura factura);
    Factura obtenerFactura(int id);
    List<Factura> listarFacturas();

}