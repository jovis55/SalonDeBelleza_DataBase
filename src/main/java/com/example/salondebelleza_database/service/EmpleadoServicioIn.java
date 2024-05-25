package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.EmpleadoServicio;
import com.example.salondebelleza_database.service.excepciones.AttributeException;

import java.util.List;

public interface EmpleadoServicioIn {

    Long getIdEmpleadoServicio(String idEmpleado, Long idServicio);
    EmpleadoServicio crearEmpleadoServicio(EmpleadoServicio empleadoServicio) throws AttributeException;
    EmpleadoServicio actualizarEmpleadoServicio(EmpleadoServicio empleadoServicio) throws AttributeException;
    EmpleadoServicio obtenerEmpleadoServicio(Long id) throws AttributeException;
    void eliminarEmpleadoServicio(Long id) throws AttributeException;
    List<EmpleadoServicio> listarEmpleadoServicios() throws AttributeException;
}

