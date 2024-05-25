package com.example.salondebelleza_database.controller;


import com.example.salondebelleza_database.entity.Empleado;
import com.example.salondebelleza_database.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable String id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoService.saveEmpleado(empleado);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }
    // Endpoint para obtener empleados por ID de especialidad
    @GetMapping("/espe/{idEspecialidad}")
    public List<Empleado> obtenerEmpleadosPorEspecialidad(@PathVariable int idEspecialidad) {
        return empleadoService.findEmpleadosPorEspecialidad(idEspecialidad);
    }

    @GetMapping("/servicio/{idServicio}")
    public List<Empleado> obtenerEmpleadosPorServicio(@PathVariable int idServicio) {
        return empleadoService.findEmpleadosPorServicio(idServicio);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable String id) {
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
