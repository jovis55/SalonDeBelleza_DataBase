package com.example.salondebelleza_database.servicio;

import com.example.salondebelleza_database.entity.Servicio;

import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioIn {

    Servicio crearServicio(Servicio servicio) throws AttributeException;

    Servicio actualizarServicio(Servicio servicio) throws AttributeException;

    Servicio obtenerServicio(int idServicio) throws AttributeException;

    List<Servicio> listarServicios() throws AttributeException;

    void eliminarServicio(int idServicio) throws AttributeException;

    boolean existeServicio(int idServicio);
}