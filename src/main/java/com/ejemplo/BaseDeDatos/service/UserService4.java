package com.ejemplo.BaseDeDatos.service;

import com.ejemplo.BaseDeDatos.skill;
import com.ejemplo.BaseDeDatos.repository.UserRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService4 {
    @Autowired
    private UserRepository4 userRepository4;
    public List<skill> listAllUserSkill() {
        return userRepository4.findAll();
    }

    public void saveUser(skill dato) {
        userRepository4.save(dato);
    }

    public skill getSkill(Long id) {
        return userRepository4.findById(id).get();
    }

    public void deleteSkill(Long id) {
        userRepository4.deleteById(id);
    }
}
   