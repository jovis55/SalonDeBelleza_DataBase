package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.Especialidad;
import com.example.salondebelleza_database.service.EspecialidadService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad) {
        try {
            Especialidad nuevaEspecialidad = especialidadService.crearEspecialidad(especialidad);
            return new ResponseEntity<>(nuevaEspecialidad, HttpStatus.CREATED);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idEspecialidad}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable("idEspecialidad") int idEspecialidad, @RequestBody Especialidad especialidad) {
        try {
            especialidad.setId_especialidad(idEspecialidad);
            Especialidad especialidadActualizada = especialidadService.actualizarEspecialidad(especialidad);
            return new ResponseEntity<>(especialidadActualizada, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{idEspecialidad}")
    public ResponseEntity<Especialidad> obtenerEspecialidad(@PathVariable("idEspecialidad") int idEspecialidad) {
        try {
            Especialidad especialidad = especialidadService.obtenerEspecialidad(idEspecialidad);
            return new ResponseEntity<>(especialidad, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idEspecialidad}")
    public ResponseEntity<Void> eliminarEspecialidad(@PathVariable("idEspecialidad") int idEspecialidad) {
        try {
            especialidadService.eliminarEspecialidad(idEspecialidad);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Especialidad>> listarEspecialidades() {
        try {
            List<Especialidad> especialidades = especialidadService.listarEspecialidades();
            return new ResponseEntity<>(especialidades, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
