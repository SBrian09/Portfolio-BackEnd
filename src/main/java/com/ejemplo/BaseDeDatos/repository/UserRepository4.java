package com.ejemplo.BaseDeDatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.skill;

@Repository
public interface UserRepository4 extends JpaRepository<skill, Long>{
}