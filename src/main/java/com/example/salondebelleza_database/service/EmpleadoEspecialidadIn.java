package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.EmpleadoEspecialidad;

import java.util.List;

public interface EmpleadoEspecialidadIn {
    List<EmpleadoEspecialidad> getAllEmpleadoEspecialidades();
    EmpleadoEspecialidad getEmpleadoEspecialidadById(Long id);
    EmpleadoEspecialidad saveEmpleadoEspecialidad(EmpleadoEspecialidad empleadoEspecialidad);
    void deleteEmpleadoEspecialidad(Long id);
}
