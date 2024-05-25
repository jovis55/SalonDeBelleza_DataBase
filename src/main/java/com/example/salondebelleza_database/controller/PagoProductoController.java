package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.PagoProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos-productos")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoProductoController {

    @Autowired
    private com.example.salondebelleza_database.service.impl.PagoProductoService pagoProductoService;

    @PostMapping
    public ResponseEntity<PagoProducto> createPagoProducto(@RequestBody PagoProducto pagoProducto) {
        PagoProducto newPagoProducto = pagoProductoService.savePagoProducto(pagoProducto);
        return ResponseEntity.ok(newPagoProducto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoProducto> getPagoProductoById(@PathVariable Long id) {
        PagoProducto pagoProducto = pagoProductoService.getPagoProductoById(id);
        if (pagoProducto != null) {
            return ResponseEntity.ok(pagoProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PagoProducto>> getAllPagoProductos() {
        List<PagoProducto> pagoProductos = pagoProductoService.getAllPagoProductos();
        return ResponseEntity.ok(pagoProductos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagoProducto(@PathVariable Long id) {
        pagoProductoService.deletePagoProducto(id);
        return ResponseEntity.noContent().build();
    }
}
