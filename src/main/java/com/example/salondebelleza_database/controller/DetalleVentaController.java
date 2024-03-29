package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.DetalleVenta;
import com.example.salondebelleza_database.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles-venta")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @Autowired
    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @PostMapping
    public DetalleVenta crearDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.crearDetalleVenta(detalleVenta);
    }

    @GetMapping("/{id}")
    public DetalleVenta obtenerDetalleVenta(@PathVariable int id) {
        return detalleVentaService.obtenerDetalleVenta(id);
    }



}
