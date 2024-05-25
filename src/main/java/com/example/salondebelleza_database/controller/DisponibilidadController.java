package com.example.salondebelleza_database.controller;


import com.example.salondebelleza_database.entity.Disponibilidad;
import com.example.salondebelleza_database.service.DisponibilidadService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disponibilidad")
@CrossOrigin(origins = "http://localhost:4200")

public class DisponibilidadController {
    @Autowired
    DisponibilidadService disponibilidadService;


    @GetMapping("/{idDisponibilidad}")
    public ResponseEntity<Disponibilidad> obtenerDisponibilidad(@PathVariable int idDisponibilidad) {
        try {
            Disponibilidad disponibilidad = disponibilidadService.obtenerDisponibilidad(idDisponibilidad);
            return new ResponseEntity<>(disponibilidad, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idDisponibilidad}")
    public ResponseEntity<Disponibilidad> actualizarDisponibilidad(@PathVariable int idDisponibilidad, @RequestBody Disponibilidad disponibilidad) {
        try {
            System.out.println("ESTADOOO"+disponibilidad.getEstado());
            Disponibilidad disponibilidadActualizada = disponibilidadService.actualizarDisponibilidad(idDisponibilidad, disponibilidad);
            return new ResponseEntity<>(disponibilidadActualizada, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
