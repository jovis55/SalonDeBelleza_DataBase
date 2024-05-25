package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.EmpleadoEspecialidad;
import com.example.salondebelleza_database.repository.EmpleadoEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoEspecialidadService implements EmpleadoEspecialidadIn {
    private final EmpleadoEspecialidadRepository empleadoEspecialidadRepository;

    @Autowired
    public EmpleadoEspecialidadService(EmpleadoEspecialidadRepository empleadoEspecialidadRepository) {
        this.empleadoEspecialidadRepository = empleadoEspecialidadRepository;
    }


    @Override
    public List<EmpleadoEspecialidad> getAllEmpleadoEspecialidades() {
        return empleadoEspecialidadRepository.findAll();
    }

    @Override
    public EmpleadoEspecialidad getEmpleadoEspecialidadById(Long id) {
        return empleadoEspecialidadRepository.findById(id).orElse(null);
    }

    @Override
    public EmpleadoEspecialidad saveEmpleadoEspecialidad(EmpleadoEspecialidad empleadoEspecialidad) {
        return empleadoEspecialidadRepository.save(empleadoEspecialidad);
    }

    @Override
    public void deleteEmpleadoEspecialidad(Long id) {
        empleadoEspecialidadRepository.deleteById(id);
    }
}
