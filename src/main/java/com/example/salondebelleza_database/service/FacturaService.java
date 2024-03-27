package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.Factura;
import com.example.salondebelleza_database.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements FacturaIn {

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura obtenerFactura(int id) {
        Optional<Factura> facturaOptional = facturaRepository.findById(id);
        return facturaOptional.orElse(null);
    }

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }


}
