package com.example.salondebelleza_database.service;


import com.example.salondebelleza_database.entity.Cita;
import com.example.salondebelleza_database.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements CitaIn{

    private final CitaRepository citaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita getCitaById(int id) {
        Optional<Cita> citaOptional = citaRepository.findById(id);
        return citaOptional.orElse(null);
    }

    @Override
    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void deleteCita(int id) {
        citaRepository.deleteById(id);
    }
}
