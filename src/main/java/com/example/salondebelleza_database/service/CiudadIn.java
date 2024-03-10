package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Ciudad;

import java.util.List;

public interface CiudadIn {
    List<Ciudad> getAllCiudades();
    Ciudad getCiudadById(int id);
    Ciudad saveCiudad(Ciudad ciudad);
    void deleteCiudad(int id);
}
