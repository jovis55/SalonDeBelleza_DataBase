package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
 @Query("SELECT e FROM Empleado e " +
         "JOIN e.empleadoEspecialidadList ee " +
         "WHERE ee.especialidad.id_especialidad = :especialidadId")
 List<Empleado> findByEspecialidadId(@Param("especialidadId") int especialidadId);

 @Query("SELECT e FROM Empleado e " +
         "JOIN e.empleadoServicioList ee " +
         "WHERE ee.servicio.id_servicio = :servicioId")
 List<Empleado> findByServicioId(@Param("servicioId") int servicioId);

}