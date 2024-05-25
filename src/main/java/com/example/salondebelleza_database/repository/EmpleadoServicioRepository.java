package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.EmpleadoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoServicioRepository extends JpaRepository<EmpleadoServicio, Long> {

    @Query("SELECT es.idEmpleadoServicio FROM EmpleadoServicio es WHERE es.empleado.id_usuario = :idEmpleado AND es.servicio.id_servicio = :idServicio")
    Long findIdEmpleadoServicio(@Param("idEmpleado") String idEmpleado, @Param("idServicio") Long idServicio);
}
