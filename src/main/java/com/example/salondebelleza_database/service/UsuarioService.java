package com.example.salondebelleza_database.service;



import com.example.salondebelleza_database.entity.Usuario;
import com.example.salondebelleza_database.service.excepciones.AttributeException;
import com.example.salondebelleza_database.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService implements UsuarioIn {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws AttributeException {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws AttributeException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId_usuario());
        if (usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new AttributeException("Usuario no encontrado en la base de datos.");
        }
    }

    @Override
    public Usuario obtenerUsuario(String id_usuario) throws AttributeException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id_usuario);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new AttributeException("Usuario no encontrado en la base de datos.");
        }
    }

    @Override
    public void eliminarUsuario(String id_usuario) throws AttributeException {
        if (existeUsuario(id_usuario)) {
            usuarioRepository.deleteById(id_usuario);
        } else {
            throw new AttributeException("Usuario no encontrado en la base de datos.");
        }
    }

    @Override
    public boolean existeUsuario(String id_usuario) {
        return usuarioRepository.existsById(id_usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() throws AttributeException {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new AttributeException("No se pudieron listar los usuarios.");
        }
    }
}