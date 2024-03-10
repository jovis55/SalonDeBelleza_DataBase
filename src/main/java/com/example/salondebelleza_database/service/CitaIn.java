package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Cita;

import java.util.List;

public interface CitaIn {
    List<Cita> getAllCitas();
    Cita getCitaById(int id);
    Cita saveCita(Cita cita);
    void deleteCita(int id);
}
