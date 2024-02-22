package com.example.salondebelleza_database.service;



import com.example.salondebelleza_database.entity.Usuario;
import com.example.salondebelleza_database.service.excepciones.AttributeException;


import java.util.List;

public interface UsuarioIn {

    Usuario crearUsuario(Usuario usuario) throws AttributeException;

    Usuario actualizarUsuario(Usuario usuario) throws AttributeException;

    Usuario obtenerUsuario(String id_usuario) throws AttributeException;

    List<Usuario> listarUsuarios() throws AttributeException;

    void eliminarUsuario(String id_usuario) throws AttributeException;

    boolean existeUsuario(String id_usuario);
}