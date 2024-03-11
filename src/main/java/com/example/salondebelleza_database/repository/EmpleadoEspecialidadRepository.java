package com.example.salondebelleza_database.repository;


import com.example.salondebelleza_database.entity.EmpleadoEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoEspecialidadRepository extends JpaRepository<EmpleadoEspecialidad, Long> {
}

