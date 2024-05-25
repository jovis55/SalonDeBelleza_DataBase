package com.example.salondebelleza_database.controller;


import com.example.salondebelleza_database.entity.Pago;
import com.example.salondebelleza_database.service.PagoService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        try {
            Pago nuevoPago = pagoService.crearPago(pago);
            return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idPago}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable("idPago") int idPago, @RequestBody Pago pago) {
        try {
            pago.setId_pago(idPago);
            Pago pagoActualizado = pagoService.actualizarPago(pago);
            return new ResponseEntity<>(pagoActualizado, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idPago}")
    public ResponseEntity<Pago> obtenerPago(@PathVariable("idPago") int idPago) {
        try {
            Pago pago = pagoService.obtenerPago(idPago);
            return new ResponseEntity<>(pago, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idPago}")
    public ResponseEntity<Void> eliminarPago(@PathVariable("idPago") int idPago) {
        try {
            pagoService.eliminarPago(idPago);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pago>> listarPagos() {
        try {
            List<Pago> pagos = pagoService.listarPagos();
            return new ResponseEntity<>(pagos, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}