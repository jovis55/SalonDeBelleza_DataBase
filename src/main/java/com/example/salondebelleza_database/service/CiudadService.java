package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Ciudad;
import com.example.salondebelleza_database.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService implements CiudadIn {

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Ciudad> getAllCiudades() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad getCiudadById(int id) {
        Optional<Ciudad> ciudadOptional = ciudadRepository.findById(id);
        return ciudadOptional.orElse(null);
    }

    @Override
    public Ciudad saveCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public void deleteCiudad(int id) {
        ciudadRepository.deleteById(id);
    }
}
