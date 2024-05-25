package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.Servicio;
import com.example.salondebelleza_database.service.ServicioService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {

    private final ServicioService servicioService;

    @Autowired
    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        try {
            Servicio nuevoServicio = servicioService.crearServicio(servicio);
            return new ResponseEntity<>(nuevoServicio, HttpStatus.CREATED);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idServicio}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable("idServicio") int idServicio, @RequestBody Servicio servicio) {
        try {
            servicio.setId_servicio(idServicio);
            Servicio servicioActualizado = servicioService.actualizarServicio(servicio);
            return new ResponseEntity<>(servicioActualizado, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idServicio}")
    public ResponseEntity<Servicio> obtenerServicio(@PathVariable("idServicio") int idServicio) {
        try {
            Servicio servicio = servicioService.obtenerServicio(idServicio);
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idServicio}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable("idServicio") int idServicio) {
        try {
            servicioService.eliminarServicio(idServicio);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> listarServicios() {
        try {
            List<Servicio> servicios = servicioService.listarServicios();
            return new ResponseEntity<>(servicios, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}