package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.proyectos;

@Repository
public interface UserRepository5 extends JpaRepository<proyectos, Long>{
}
