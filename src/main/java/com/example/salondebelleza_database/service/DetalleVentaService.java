package com.example.salondebelleza_database.service;

import com.example.salondebelleza_database.entity.DetalleVenta;
import com.example.salondebelleza_database.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService implements DetalleVentaIn {

    private final DetalleVentaRepository detalleVentaRepository;

    @Autowired
    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta obtenerDetalleVenta(int id) {
        Optional<DetalleVenta> detalleVentaOptional = detalleVentaRepository.findById(id);
        return detalleVentaOptional.orElse(null);
    }



    // Puedes implementar más métodos según sea necesario
}
