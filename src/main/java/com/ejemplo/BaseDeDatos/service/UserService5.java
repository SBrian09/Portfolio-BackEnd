package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.proyectos;
import com.ejemplo.BaseDeDatos.repository.UserRepository5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService5 {
    @Autowired
    private UserRepository5 userRepository5;
    public List<proyectos> listAllUserProyectos() {
        return userRepository5.findAll();
    }

    public void saveUser(proyectos dato) {
        userRepository5.save(dato);
    }

    public proyectos getProyectos(Long id) {
        return userRepository5.findById(id).get();
    }

    public void deleteProyectos(Long id) {
        userRepository5.deleteById(id);
    }
}