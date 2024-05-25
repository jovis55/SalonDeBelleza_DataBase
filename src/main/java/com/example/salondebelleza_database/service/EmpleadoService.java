package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Empleado;
import com.example.salondebelleza_database.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements EmpleadoIn {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }
    public List<Empleado> findEmpleadosPorEspecialidad(int especialidadId) {
        return empleadoRepository.findByEspecialidadId(especialidadId);
    }
    public List<Empleado> findEmpleadosPorServicio(int servicioId) {
        return empleadoRepository.findByServicioId(servicioId);
    }
    @Override
    public Empleado getEmpleadoById(String id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        return empleadoOptional.orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(String id) {
        empleadoRepository.deleteById(id);
    }
}
