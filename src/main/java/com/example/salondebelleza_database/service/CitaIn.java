package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Cita;
import com.example.salondebelleza_database.service.excepciones.AttributeException;

import java.util.List;

public interface CitaIn {
    List<Cita> getAllCitas() throws AttributeException ;
    Cita actualizarCita (Cita cita) throws AttributeException;
    Cita getCitaById(int id) throws AttributeException ;
    Cita saveCita(Cita cita) throws AttributeException;
    void deleteCita(int id) throws AttributeException;
    boolean existeCita (int idCita);
}
