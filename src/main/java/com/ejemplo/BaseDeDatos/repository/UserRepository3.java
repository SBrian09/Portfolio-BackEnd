package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.estudio;

@Repository
public interface UserRepository3 extends JpaRepository<estudio, Long>{
}
