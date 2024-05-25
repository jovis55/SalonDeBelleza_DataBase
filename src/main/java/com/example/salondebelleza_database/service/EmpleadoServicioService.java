package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.EmpleadoServicio;
import com.example.salondebelleza_database.repository.EmpleadoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicioService implements EmpleadoServicioIn {

    private final EmpleadoServicioRepository empleadoServicioRepository;

    @Override
    public Long getIdEmpleadoServicio(String idEmpleado, Long idServicio) {
        return empleadoServicioRepository.findIdEmpleadoServicio(idEmpleado, idServicio);
    }
    @Autowired
    public EmpleadoServicioService(EmpleadoServicioRepository empleadoServicioRepository) {
        this.empleadoServicioRepository = empleadoServicioRepository;
    }

    @Override
    public EmpleadoServicio crearEmpleadoServicio(EmpleadoServicio empleadoServicio) {
        return empleadoServicioRepository.save(empleadoServicio);
    }

    @Override
    public EmpleadoServicio actualizarEmpleadoServicio(EmpleadoServicio empleadoServicio) {
        return empleadoServicioRepository.save(empleadoServicio);
    }

    @Override
    public EmpleadoServicio obtenerEmpleadoServicio(Long id) {
        Optional<EmpleadoServicio> empleadoServicioOptional = empleadoServicioRepository.findById(id);
        return empleadoServicioOptional.orElse(null);
    }

    @Override
    public void eliminarEmpleadoServicio(Long id) {
        empleadoServicioRepository.deleteById(id);
    }

    @Override
    public List<EmpleadoServicio> listarEmpleadoServicios() {
        return empleadoServicioRepository.findAll();
    }
}
