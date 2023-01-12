package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.ImgPerfil;
import com.ejemplo.BaseDeDatos.repository.UserRepository7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService7 {
    @Autowired
    private UserRepository7 userRepository7;
    public List<ImgPerfil> listAllUserPerfil() {
        return userRepository7.findAll();
    }

    public void saveUser(ImgPerfil dato) {
        userRepository7.save(dato);
    }

    public ImgPerfil getLink(Long id) {
        return userRepository7.findById(id).get();
    }

    public void deleteLink(Long id) {
        userRepository7.deleteById(id);
    }
}