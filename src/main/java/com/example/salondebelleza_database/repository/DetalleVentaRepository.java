package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    List<DetalleVenta> findByFacturaId(int idFactura);
}