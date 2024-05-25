package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.EmpleadoEspecialidad;
import com.example.salondebelleza_database.service.EmpleadoEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado-especialidades")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoEspecialidadController {

    private final EmpleadoEspecialidadService empleadoEspecialidadService;

    @Autowired
    public EmpleadoEspecialidadController(EmpleadoEspecialidadService empleadoEspecialidadService) {
        this.empleadoEspecialidadService = empleadoEspecialidadService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoEspecialidad>> getAllEmpleadoEspecialidades() {
        List<EmpleadoEspecialidad> empleadoEspecialidades = empleadoEspecialidadService.getAllEmpleadoEspecialidades();
        return ResponseEntity.ok(empleadoEspecialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoEspecialidad> getEmpleadoEspecialidadById(@PathVariable Long id) {
        EmpleadoEspecialidad empleadoEspecialidad = empleadoEspecialidadService.getEmpleadoEspecialidadById(id);
        if (empleadoEspecialidad != null) {
            return ResponseEntity.ok(empleadoEspecialidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmpleadoEspecialidad> saveEmpleadoEspecialidad(@RequestBody EmpleadoEspecialidad empleadoEspecialidad) {
        EmpleadoEspecialidad savedEmpleadoEspecialidad = empleadoEspecialidadService.saveEmpleadoEspecialidad(empleadoEspecialidad);
        return new ResponseEntity<>(savedEmpleadoEspecialidad, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleadoEspecialidad(@PathVariable Long id) {
        empleadoEspecialidadService.deleteEmpleadoEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}
