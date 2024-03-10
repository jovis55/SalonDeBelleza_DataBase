package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}