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
