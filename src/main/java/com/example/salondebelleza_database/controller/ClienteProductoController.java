package com.example.salondebelleza_database.controller;

import com.example.salondebelleza_database.entity.ClienteProducto;
import com.example.salondebelleza_database.service.ClienteProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienteProductos")
public class ClienteProductoController {

    private final ClienteProductoService clienteProductoService;

    @Autowired
    public ClienteProductoController(ClienteProductoService clienteProductoService) {
        this.clienteProductoService = clienteProductoService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteProducto>> listarClienteProductos() {
        List<ClienteProducto> clienteProductos = clienteProductoService.listarClienteProductos();
        return ResponseEntity.ok(clienteProductos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteProducto> obtenerClienteProducto(@PathVariable Long id) {
        ClienteProducto clienteProducto = clienteProductoService.obtenerClienteProducto(id);
        if (clienteProducto != null) {
            return ResponseEntity.ok(clienteProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClienteProducto> crearClienteProducto(@RequestBody ClienteProducto clienteProducto) {
        ClienteProducto nuevoClienteProducto = clienteProductoService.crearClienteProducto(clienteProducto);
        return new ResponseEntity<>(nuevoClienteProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteProducto> actualizarClienteProducto(@PathVariable Long id, @RequestBody ClienteProducto clienteProducto) {
        clienteProducto.setIdClienteProducto(id);
        ClienteProducto clienteProductoActualizado = clienteProductoService.actualizarClienteProducto(clienteProducto);
        return ResponseEntity.ok(clienteProductoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClienteProducto(@PathVariable Long id) {
        clienteProductoService.eliminarClienteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
