package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Servicio;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import com.example.salondebelleza_database.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicioService implements com.example.salondebelleza_database.servicio.ServicioIn {

    private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Servicio crearServicio(Servicio servicio) throws AttributeException {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizarServicio(Servicio servicio) throws AttributeException {
        Optional<Servicio> servicioOptional = servicioRepository.findById(servicio.getId_servicio());
        if (servicioOptional.isPresent()) {
            return servicioRepository.save(servicio);
        } else {
            throw new AttributeException("Servicio no encontrado en la base de datos.");
        }
    }

    @Override
    public Servicio obtenerServicio(int idServicio) throws AttributeException {
        Optional<Servicio> servicioOptional = servicioRepository.findById(idServicio);
        if (servicioOptional.isPresent()) {
            return servicioOptional.get();
        } else {
            throw new AttributeException("Servicio no encontrado en la base de datos.");
        }
    }

    @Override
    public void eliminarServicio(int idServicio) throws AttributeException {
        if (existeServicio(idServicio)) {
            servicioRepository.deleteById(idServicio);
        } else {
            throw new AttributeException("Servicio no encontrado en la base de datos.");
        }
    }

    @Override
    public boolean existeServicio(int idServicio) {
        return servicioRepository.existsById(idServicio);
    }

    @Override
    public List<Servicio> listarServicios() throws AttributeException {
        try {
            return servicioRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar los servicios.");
        }
    }
}
