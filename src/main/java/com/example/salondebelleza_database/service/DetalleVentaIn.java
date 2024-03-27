package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.DetalleVenta;
import com.example.salondebelleza_database.entity.Factura;
import java.util.List;

public interface DetalleVentaIn {
    DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta obtenerDetalleVenta(int id);


}
