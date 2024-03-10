package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Administrador;

import java.util.List;

public interface AdministradorIn {
    List<Administrador> getAllAdministradores();
    Administrador getAdministradorById(String id);
    Administrador saveAdministrador(Administrador administrador);
    void deleteAdministrador(String id);
}
