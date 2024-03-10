package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Empleado;

import java.util.List;

public interface EmpleadoIn {
    List<Empleado> getAllEmpleados();
    Empleado getEmpleadoById(String id);
    Empleado saveEmpleado(Empleado empleado);
    void deleteEmpleado(String id);
}
