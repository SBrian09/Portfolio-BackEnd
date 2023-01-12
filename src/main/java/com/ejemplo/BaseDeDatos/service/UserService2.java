package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.sobreMi;
import com.ejemplo.BaseDeDatos.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService2 {
    @Autowired
    private UserRepository2 userRepository2;
    public List<sobreMi> listAllUserSobreMi() {
        return userRepository2.findAll();
    }

    public void saveUser(sobreMi dato) {
        userRepository2.save(dato);
    }

    public sobreMi getSobreMi(Long id) {
        return userRepository2.findById(id).get();
    }

    public void deleteSobreMi(Long id) {
        userRepository2.deleteById(id);
    }
}
