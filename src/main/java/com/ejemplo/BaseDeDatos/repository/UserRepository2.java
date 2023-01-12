package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.sobreMi;

@Repository
public interface UserRepository2 extends JpaRepository<sobreMi, Long>{
}
