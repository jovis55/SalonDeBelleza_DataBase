package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}