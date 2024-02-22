package com.example.salondebelleza_database.repository;

import com.example.salondebelleza_database.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}