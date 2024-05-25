package com.example.salondebelleza_database.service.impl;

import com.example.salondebelleza_database.entity.PagoProducto;
import com.example.salondebelleza_database.repository.PagoProductoRepository;
import com.example.salondebelleza_database.service.PagoProductoIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoProductoService implements PagoProductoIn {

    @Autowired
    private PagoProductoRepository pagoProductoRepository;

    @Override
    public PagoProducto savePagoProducto(PagoProducto pagoProducto) {
        return pagoProductoRepository.save(pagoProducto);
    }

    @Override
    public PagoProducto getPagoProductoById(Long id) {
        return pagoProductoRepository.findById(id).orElse(null);
    }

    @Override
    public List<PagoProducto> getAllPagoProductos() {
        return pagoProductoRepository.findAll();
    }

    @Override
    public void deletePagoProducto(Long id) {
        pagoProductoRepository.deleteById(id);
    }
}
