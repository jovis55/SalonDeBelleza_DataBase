package com.example.salondebelleza_database.service;


import com.example.salondebelleza_database.entity.Disponibilidad;
import com.example.salondebelleza_database.service.excepciones.AttributeException;

public interface DisponibilidadIn {

    Disponibilidad crearDisponibilidad (Disponibilidad disponibilidad) throws AttributeException;
    Disponibilidad actualizarDisponibilidad (Disponibilidad disponibilidad) throws AttributeException;
    Disponibilidad obtenerDisponibilidad (int idDisponibilidad) throws AttributeException;
    void eliminarDisponibilidad (int idDisponibilidad) throws AttributeException;
    boolean existeDisponibilidad (int idDisponibilidad);
    Disponibilidad actualizarDisponibilidad(int idDisponibilidad, Disponibilidad disponibilidad) throws AttributeException;



}
