package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
