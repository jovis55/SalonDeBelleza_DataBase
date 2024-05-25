package com.example.salondebelleza_database.controller;


import com.example.salondebelleza_database.entity.Ciudad;
import com.example.salondebelleza_database.entity.Cliente;
import com.example.salondebelleza_database.entity.Genero_Musical;
import com.example.salondebelleza_database.entity.Tipo_usuario;
import com.example.salondebelleza_database.service.ClienteService;
import com.example.salondebelleza_database.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.AttributeException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final ClienteService clienteService;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id_usuario") String id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrarCliente")
    public Cliente crearCliente(@RequestParam("imagen") MultipartFile imagen,
                                @RequestParam("id_usuario") String id_usuario,
                                @RequestParam("nombre") String nombre,
                                @RequestParam("contrasena") String contrasena,
                                @RequestParam("email") String email,
                                @RequestParam("telefono") String telefono,
                                @RequestParam("direccion") String direccion,
                                @RequestParam("fecha_nacimiento") String fecha_nacimiento,
                                @RequestParam("id_ciudad") String id_ciudad,
                                @RequestParam("genero_musical") String genero_musical) {

        try {
            Tipo_usuario tipo_usuario = Tipo_usuario.CLIENTE; // No es necesario utilizar valueOf aquí
            Genero_Musical generoMusical1 = Genero_Musical.valueOf(genero_musical);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date fechaNacimiento1 = dateFormat.parse(fecha_nacimiento);

            Map<String, String> result = cloudinaryService.cargarImagen(imagen);
            String imageUrl = result.get("url");

            Cliente cliente = new Cliente();
            cliente.setId_usuario(id_usuario);
            cliente.setNombre(nombre);
            cliente.setContrasena(contrasena);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setDireccion(direccion);
            cliente.setFecha_nacimiento(fechaNacimiento1);
            cliente.setTipo_usuario(tipo_usuario);
            cliente.setImagen_url(imageUrl);

            Ciudad ciudad = new Ciudad();
            ciudad.setId_ciudad(Integer.parseInt(id_ciudad));

            cliente.setCiudad(ciudad);
            cliente.setGenero_musical(generoMusical1);

            return clienteService.saveCliente(cliente);

        } catch (IllegalArgumentException e) {
            // Valor inválido para el género musical
            throw new IllegalArgumentException("Valor inválido para el género musical", e);
        } catch (Exception e) {
            // Captura cualquier otra excepción no esperada
            throw new RuntimeException("Error al crear el cliente", e);
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") String id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
