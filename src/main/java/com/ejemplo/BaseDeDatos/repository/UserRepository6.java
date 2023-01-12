package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.imgFondo;

@Repository
public interface UserRepository6 extends JpaRepository<imgFondo, Long>{

}