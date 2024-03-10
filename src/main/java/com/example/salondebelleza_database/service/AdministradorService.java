package com.example.salondebelleza_database.service;


import com.example.salondebelleza_database.entity.Administrador;
import com.example.salondebelleza_database.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService implements AdministradorIn {

    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador getAdministradorById(String id) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        return administradorOptional.orElse(null);
    }

    @Override
    public Administrador saveAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public void deleteAdministrador(String id) {
        administradorRepository.deleteById(id);
    }
}
