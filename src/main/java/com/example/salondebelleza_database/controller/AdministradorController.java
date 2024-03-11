package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.Administrador;
import com.example.salondebelleza_database.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public ResponseEntity<List<Administrador>> getAllAdministradores() {
        List<Administrador> administradores = administradorService.getAllAdministradores();
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable("id") String id) {
        Administrador administrador = administradorService.getAdministradorById(id);
        if (administrador != null) {
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Administrador> saveAdministrador(@RequestBody Administrador administrador) {
        Administrador savedAdministrador = administradorService.saveAdministrador(administrador);
        return new ResponseEntity<>(savedAdministrador, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable("id") String id) {
        administradorService.deleteAdministrador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


