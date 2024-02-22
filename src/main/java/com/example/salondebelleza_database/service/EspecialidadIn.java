package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Especialidad;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EspecialidadIn {

    Especialidad crearEspecialidad(Especialidad especialidad) throws AttributeException;

    Especialidad actualizarEspecialidad(Especialidad especialidad) throws AttributeException;

    Especialidad obtenerEspecialidad(int idEspecialidad) throws AttributeException;

    List<Especialidad> listarEspecialidades() throws AttributeException;

    void eliminarEspecialidad(int idEspecialidad) throws AttributeException;

    boolean existeEspecialidad(int idEspecialidad);
}
