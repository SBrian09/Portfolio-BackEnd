package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.estudio;
import com.ejemplo.BaseDeDatos.repository.UserRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService3 {
    @Autowired
    private UserRepository3 userRepository3;
    public List<estudio> listAllUserEstudio() {
        return userRepository3.findAll();
    }

    public void saveUser(estudio dato) {
        userRepository3.save(dato);
    }

    public estudio getEstudio(Long id) {
        return userRepository3.findById(id).get();
    }

    public void deleteEstudio(Long id) {
        userRepository3.deleteById(id);
    }
}
