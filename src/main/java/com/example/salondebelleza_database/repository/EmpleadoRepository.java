package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}