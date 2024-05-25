package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.Cita;
import com.example.salondebelleza_database.entity.Cliente;
import com.example.salondebelleza_database.entity.Disponibilidad;
import com.example.salondebelleza_database.service.CitaService;
import com.example.salondebelleza_database.service.ClienteService;
import com.example.salondebelleza_database.service.EmpleadoService;
import com.example.salondebelleza_database.service.ServicioService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {
    @Autowired
    CitaService citaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    ServicioService servicioService;

    @DeleteMapping("/{idCita}")
    public ResponseEntity<String> eliminarCita(@PathVariable int idCita) {
        try {


            citaService.deleteCita(idCita);
            return ResponseEntity.ok("Cita eliminada correctamente.");
        } catch (AttributeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearCita(@RequestBody Cita cita)  {
        try {
            Cliente cliente = this.clienteService.getClienteById(cita.getCliente().getId_usuario());

            // Verificar si el cliente ya tiene 3 citas pendientes
            long citasPendientes = cliente.getCitas().stream()
                    .filter(c -> "pendiente".equalsIgnoreCase(c.getEstado()))
                    .count();

            if (citasPendientes >= 3) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El cliente ya tiene 3 citas pendientes y no puede agendar más.");
            }
            System.out.println("paso");
            System.out.println(cita.getId_cita()+cita.getCliente().getId_usuario()+"paso");
            System.out.println(cita.getId_cita());
            System.out.println("emple ser"+cita.getEmpleadoServicio().getIdEmpleadoServicio());
            Cita citaAux = cita;
            // Continuar con la creación de la cita
            Cita nuevaCita = citaService.saveCita(citaAux);
            System.out.println("paso 2");
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
        } catch (AttributeException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la cita.");
        }
    }

    @GetMapping("/{idCita}")
    public Cita obtenerCita(@PathVariable int idCita) {
        try {
            return citaService.getCitaById(idCita);
        } catch (AttributeException e) {
            // Manejo de excepciones, puedes retornar un ResponseEntity con un mensaje de error
            e.printStackTrace();
            return null; // Otra forma de manejar el error según tus necesidades
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<Cita> actualizarCita(@RequestBody Cita cita) {
        try {
            Cita updatedCita = citaService.actualizarCita(cita);
            return ResponseEntity.ok(updatedCita);
        } catch (AttributeException e) {
            return ResponseEntity.status(404).body(null); // Puedes ajustar el código de estado y el cuerpo según tus necesidades
        }
    }



}
