package com.ejemplo.BaseDeDatos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.BaseDeDatos.usuarios;

@Repository
public interface UserRepositoryB extends JpaRepository<usuarios, Long> {
	Optional<usuarios> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
