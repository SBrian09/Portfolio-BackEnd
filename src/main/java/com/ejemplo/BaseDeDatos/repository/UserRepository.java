package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.Persona;

@Repository
public interface UserRepository extends JpaRepository<Persona, Long>{
}
