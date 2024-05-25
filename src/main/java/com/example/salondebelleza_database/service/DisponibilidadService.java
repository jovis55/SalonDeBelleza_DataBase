package com.example.salondebelleza_database.service;


import com.example.salondebelleza_database.entity.Disponibilidad;
import com.example.salondebelleza_database.repository.DisponibilidadRepository;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional

public class DisponibilidadService implements DisponibilidadIn{

    private DisponibilidadRepository disponibilidadRepository;

    @Autowired
    public DisponibilidadService(DisponibilidadRepository disponibilidadRepository) {
        this.disponibilidadRepository = disponibilidadRepository;
    }
    @Override
    public Disponibilidad actualizarDisponibilidad(int idDisponibilidad, Disponibilidad disponibilidad) throws AttributeException {
        Optional<Disponibilidad> disponibilidadExistente = disponibilidadRepository.findById(idDisponibilidad);
        if (disponibilidadExistente.isPresent()) {
            Disponibilidad disponibilidadActual = disponibilidadExistente.get();
            disponibilidadActual.setEstado(disponibilidad.getEstado());
            // Actualiza otros campos según sea necesario
            return disponibilidadRepository.save(disponibilidadActual);
        } else {
            throw new AttributeException("Disponibilidad no encontrada");
        }
    }

    @Override
    public Disponibilidad crearDisponibilidad (Disponibilidad disponibilidad) throws AttributeException {
        return disponibilidadRepository.save(disponibilidad);
    }

    @Override
    public Disponibilidad actualizarDisponibilidad (Disponibilidad disponibilidad) throws AttributeException {
        Optional<Disponibilidad> disponibilidadOptional = disponibilidadRepository.findById(disponibilidad.getIdDisponibilidad());
        if (disponibilidadOptional.isPresent()) {
            return disponibilidadRepository.save(disponibilidad);
        } else {
            throw new AttributeException("Disponibilidad no encontrada en la base de datos.");
        }
    }

    @Override
    public Disponibilidad obtenerDisponibilidad (int idDisponibilidad) throws AttributeException {
        Optional<Disponibilidad> disponibilidadOptional = disponibilidadRepository.findById(idDisponibilidad);
        if (disponibilidadOptional.isPresent()) {
            return disponibilidadOptional.get();
        } else {
            throw new AttributeException("Disponibilidad no encontrada en la base de datos.");
        }
    }


    @Override
    public void eliminarDisponibilidad (int idDisponibilidad) throws AttributeException {
        if (existeDisponibilidad (idDisponibilidad)) {
            disponibilidadRepository.deleteById(idDisponibilidad);
        } else {
            throw new AttributeException("Disponibilidad no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeDisponibilidad (int idDisponibilidad) {
        return disponibilidadRepository.existsById(idDisponibilidad);
    }
}