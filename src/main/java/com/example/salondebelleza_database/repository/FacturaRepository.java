package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
