package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.ImgPerfil;

@Repository
public interface UserRepository7 extends JpaRepository<ImgPerfil, Long>{

}
