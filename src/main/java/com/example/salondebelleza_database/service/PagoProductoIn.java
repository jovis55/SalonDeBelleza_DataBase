package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.PagoProducto;

import java.util.List;

public interface PagoProductoIn {
    PagoProducto savePagoProducto(PagoProducto pagoProducto);
    PagoProducto getPagoProductoById(Long id);
    List<PagoProducto> getAllPagoProductos();
    void deletePagoProducto(Long id);
}
