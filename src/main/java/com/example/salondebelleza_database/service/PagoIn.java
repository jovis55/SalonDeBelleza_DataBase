package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Pago;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PagoIn {

    Pago crearPago(Pago pago) throws AttributeException;

    Pago actualizarPago(Pago pago) throws AttributeException;

    Pago obtenerPago(int idPago) throws AttributeException;

    List<Pago> listarPagos() throws AttributeException;

    void eliminarPago(int idPago) throws AttributeException;

    boolean existePago(int idPago);
}

