package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.PagoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoProductoRepository extends JpaRepository<PagoProducto, Long> {
}
