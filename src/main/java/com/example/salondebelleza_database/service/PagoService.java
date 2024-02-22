package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Pago;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import com.example.salondebelleza_database.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PagoService implements PagoIn {

    private final PagoRepository pagoRepository;

    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago crearPago(Pago pago) throws AttributeException {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago actualizarPago(Pago pago) throws AttributeException {
        Optional<Pago> pagoOptional = pagoRepository.findById(pago.getId_pago());
        if (pagoOptional.isPresent()) {
            return pagoRepository.save(pago);
        } else {
            throw new AttributeException("Pago no encontrado en la base de datos.");
        }
    }

    @Override
    public Pago obtenerPago(int idPago) throws AttributeException {
        Optional<Pago> pagoOptional = pagoRepository.findById(idPago);
        if (pagoOptional.isPresent()) {
            return pagoOptional.get();
        } else {
            throw new AttributeException("Pago no encontrado en la base de datos.");
        }
    }

    @Override
    public void eliminarPago(int idPago) throws AttributeException {
        if (existePago(idPago)) {
            pagoRepository.deleteById(idPago);
        } else {
            throw new AttributeException("Pago no encontrado en la base de datos.");
        }
    }

    @Override
    public boolean existePago(int idPago) {
        return pagoRepository.existsById(idPago);
    }

    @Override
    public List<Pago> listarPagos() throws AttributeException {
        try {
            return pagoRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar los pagos.");
        }
    }
}
