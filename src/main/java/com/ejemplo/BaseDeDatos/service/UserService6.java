package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.imgFondo;
import com.ejemplo.BaseDeDatos.repository.UserRepository6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService6 {
    @Autowired
    private UserRepository6 userRepository6;
    public List<imgFondo> listAllUserLink() {
        return userRepository6.findAll();
    }

    public void saveUser(imgFondo dato) {
        userRepository6.save(dato);
    }

    public imgFondo getLink(Long id) {
        return userRepository6.findById(id).get();
    }

    public void deleteLink(Long id) {
        userRepository6.deleteById(id);
    }
}