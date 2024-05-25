package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.EmpleadoServicio;
import com.example.salondebelleza_database.service.EmpleadoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleadoservicios")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoServicioController {

    private final EmpleadoServicioService empleadoServicioService;
    @GetMapping("/buscarEmpSer")
    public ResponseEntity<?> getIdEmpleadoServicio(@RequestParam String idEmpleado, @RequestParam Long idServicio) {
        Long idEmpleadoServicio = empleadoServicioService.getIdEmpleadoServicio(idEmpleado, idServicio);
        if (idEmpleadoServicio != null) {
            System.out.println(idEmpleadoServicio);
            return ResponseEntity.ok(idEmpleadoServicio);
        } else {
            return ResponseEntity.status(404).body("Empleado o Servicio no encontrado");
        }
    }
    @Autowired
    public EmpleadoServicioController(EmpleadoServicioService empleadoServicioService) {
        this.empleadoServicioService = empleadoServicioService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoServicio>> listarEmpleadoServicios() {
        List<EmpleadoServicio> empleadoServicios = empleadoServicioService.listarEmpleadoServicios();
        return ResponseEntity.ok(empleadoServicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoServicio> obtenerEmpleadoServicio(@PathVariable Long id) {
        EmpleadoServicio empleadoServicio = empleadoServicioService.obtenerEmpleadoServicio(id);
        if (empleadoServicio != null) {
            return ResponseEntity.ok(empleadoServicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmpleadoServicio> crearEmpleadoServicio(@RequestBody EmpleadoServicio empleadoServicio) {
        EmpleadoServicio nuevoEmpleadoServicio = empleadoServicioService.crearEmpleadoServicio(empleadoServicio);
        return new ResponseEntity<>(nuevoEmpleadoServicio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoServicio> actualizarEmpleadoServicio(@PathVariable Long id, @RequestBody EmpleadoServicio empleadoServicio) {
        empleadoServicio.setIdEmpleadoServicio(id);
        EmpleadoServicio empleadoServicioActualizado = empleadoServicioService.actualizarEmpleadoServicio(empleadoServicio);
        return ResponseEntity.ok(empleadoServicioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleadoServicio(@PathVariable Long id) {
        empleadoServicioService.eliminarEmpleadoServicio(id);
        return ResponseEntity.noContent().build();
    }
}
