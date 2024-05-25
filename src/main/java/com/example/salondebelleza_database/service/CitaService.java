package com.example.salondebelleza_database.service;


import com.example.salondebelleza_database.entity.Cita;
import com.example.salondebelleza_database.repository.CitaRepository;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import jdk.swing.interop.SwingInterOpUtils;
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
    public Cita getCitaById(int id) throws AttributeException  {
        Optional<Cita> citaOptional = citaRepository.findById(id);
        return citaOptional.orElse(null);
    }
    @Override
    public Cita actualizarCita(Cita cita) throws AttributeException {
        Optional<Cita> citaOptional = citaRepository.findById(cita.getId_cita());
        if (citaOptional.isPresent()) {
            return citaRepository.save(cita);
        } else {
            throw new AttributeException("Cita no encontrada en la base de datos.");
        }
    }

    @Override
    public Cita saveCita(Cita cita) throws AttributeException  {
        System.out.println(cita.getId_cita()+cita.getDuracion()+""+cita.getFecha_cita()+cita.getFecha_creacion()+"hola"+cita.getEmpleadoServicio().getIdEmpleadoServicio()+cita.getCliente().getId_usuario());
        return citaRepository.save(cita);
    }

    @Override
    public void deleteCita (int idCita) throws AttributeException {
        if (existeCita(idCita)) {
            citaRepository.deleteById(idCita);
        } else {
            throw new AttributeException("Cita no encontrada en la base de datos.");
        }
    }
    @Override
    public boolean existeCita (int idCita) {
        return citaRepository.existsById(idCita);
    }
}
