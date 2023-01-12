package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.Persona;
import com.ejemplo.BaseDeDatos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<Persona> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(Persona user) {
        userRepository.save(user);
    }

    public Persona getNombre(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteNombre(Long id) {
        userRepository.deleteById(id);
    }
}
