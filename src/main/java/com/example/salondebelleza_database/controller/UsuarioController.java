package com.example.salondebelleza_database.controller;


import com.example.salondebelleza_database.entity.Usuario;
import com.example.salondebelleza_database.service.UsuarioService;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id_usuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id_usuario") String idUsuario, @RequestBody Usuario usuario) {
        try {
            usuario.setId_usuario(idUsuario);
            Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id_usuario") String idUsuario) {
        try {
            Usuario usuario = usuarioService.obtenerUsuario(idUsuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable("id_usuario") String idUsuario) {
        try {
            usuarioService.eliminarUsuario(idUsuario);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (AttributeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}