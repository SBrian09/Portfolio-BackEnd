package com.ejemplo.BaseDeDatos.repository;

import com.ejemplo.BaseDeDatos.roles;
import com.ejemplo.BaseDeDatos.rolesDeUsuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<roles, Long> {
	Optional<roles> findByName(rolesDeUsuarios name);
}