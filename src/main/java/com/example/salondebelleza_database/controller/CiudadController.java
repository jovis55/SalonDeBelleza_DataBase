package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.Ciudad;
import com.example.salondebelleza_database.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "http://localhost:4200")
public class CiudadController {

    private final CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Ciudad>> getAllCiudades() {
        List<Ciudad> ciudades = ciudadService.getAllCiudades();
        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> getCiudadById(@PathVariable("id") int id) {
        Ciudad ciudad = ciudadService.getCiudadById(id);
        if (ciudad != null) {
            return new ResponseEntity<>(ciudad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Ciudad> saveCiudad(@RequestBody Ciudad ciudad) {
        Ciudad savedCiudad = ciudadService.saveCiudad(ciudad);
        return new ResponseEntity<>(savedCiudad, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiudad(@PathVariable("id") int id) {
        ciudadService.deleteCiudad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

