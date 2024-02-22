package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Especialidad;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import com.example.salondebelleza_database.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EspecialidadService implements EspecialidadIn {

    private final EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public Especialidad crearEspecialidad(Especialidad especialidad) throws AttributeException {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad actualizarEspecialidad(Especialidad especialidad) throws AttributeException {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(especialidad.getId_especialidad());
        if (especialidadOptional.isPresent()) {
            return especialidadRepository.save(especialidad);
        } else {
            throw new AttributeException("Especialidad no encontrada en la base de datos.");
        }
    }

    @Override
    public Especialidad obtenerEspecialidad(int idEspecialidad) throws AttributeException {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(idEspecialidad);
        if (especialidadOptional.isPresent()) {
            return especialidadOptional.get();
        } else {
            throw new AttributeException("Especialidad no encontrada en la base de datos.");
        }
    }

    @Override
    public void eliminarEspecialidad(int idEspecialidad) throws AttributeException {
        if (existeEspecialidad(idEspecialidad)) {
            especialidadRepository.deleteById(idEspecialidad);
        } else {
            throw new AttributeException("Especialidad no encontrada en la base de datos.");
        }
    }

    @Override
    public boolean existeEspecialidad(int idEspecialidad) {
        return especialidadRepository.existsById(idEspecialidad);
    }

    @Override
    public List<Especialidad> listarEspecialidades() throws AttributeException {
        try {
            return especialidadRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar las especialidades.");
        }
    }
}
