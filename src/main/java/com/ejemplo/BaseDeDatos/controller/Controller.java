/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.BaseDeDatos.controller;


import com.ejemplo.BaseDeDatos.Persona;
import com.ejemplo.BaseDeDatos.sobreMi;
import com.ejemplo.BaseDeDatos.estudio;
import com.ejemplo.BaseDeDatos.skill;
import com.ejemplo.BaseDeDatos.proyectos;
import com.ejemplo.BaseDeDatos.imgFondo;
import com.ejemplo.BaseDeDatos.ImgPerfil;
import com.ejemplo.BaseDeDatos.service.UserService;
import com.ejemplo.BaseDeDatos.service.UserService2;
import com.ejemplo.BaseDeDatos.service.UserService3;
import com.ejemplo.BaseDeDatos.service.UserService4;
import com.ejemplo.BaseDeDatos.service.UserService5;
import com.ejemplo.BaseDeDatos.service.UserService6;
import com.ejemplo.BaseDeDatos.service.UserService7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired
    UserService userService;

    @Autowired
    UserService2 userService2;
    
    @Autowired
    UserService3 userService3;
    
    @Autowired
    UserService4 userService4;
    
    @Autowired
    UserService5 userService5;
    
    @Autowired
    UserService6 userService6;
    
    @Autowired
    UserService7 userService7;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/persona")
    public List<Persona> list() {
        return userService.listAllUser();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sobreMi")
    public List<sobreMi> listSobreMi() {
        return userService2.listAllUserSobreMi();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/estudio")
    public List<estudio> listEstudio() {
        return userService3.listAllUserEstudio();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/skill")
    public List<skill> listSkill() {
        return userService4.listAllUserSkill();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/proyectos")
    public List<proyectos> listProyectos() {
        return userService5.listAllUserProyectos();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/fondo")
    public List<imgFondo> listFondo() {
        return userService6.listAllUserLink();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/perfil")
    public List<ImgPerfil> listPerfil() {
        return userService7.listAllUserPerfil();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Persona> get(@PathVariable Long id) {
        try {
            Persona user = userService.getNombre(id);
            return new ResponseEntity<Persona>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/persona")
    public void add(@RequestBody Persona user) {
        userService.saveUser(user);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sobreMi")
    public void add(@RequestBody sobreMi dato) {
        userService2.saveUser(dato);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/estudio")
    public void add(@RequestBody estudio dato) {
        userService3.saveUser(dato);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/skill")
    public void add(@RequestBody skill dato) {
        userService4.saveUser(dato);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/proyectos")
    public void add(@RequestBody proyectos dato) {
        userService5.saveUser(dato);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/fondo")
    public void add(@RequestBody imgFondo dato) {
        userService6.saveUser(dato);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/perfil")
    public void add(@RequestBody ImgPerfil dato) {
        userService7.saveUser(dato);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/persona/{id}")
    public ResponseEntity<?> update(@RequestBody Persona user, @PathVariable Long id) {
        try {
        	Persona existUser = userService.getNombre(id);
            user.setId(id);            
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/sobreMi/{id}")
    public ResponseEntity<?> update(@RequestBody sobreMi user, @PathVariable Long id) {
        try {
        	sobreMi existUser = userService2.getSobreMi(id);
            user.setId(id);            
            userService2.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/estudio/{id}")
    public ResponseEntity<?> update(@RequestBody estudio user, @PathVariable Long id) {
        try {
        	estudio existUser = userService3.getEstudio(id);
            user.setId(id);            
            userService3.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/skill/{id}")
    public ResponseEntity<?> update(@RequestBody skill user, @PathVariable Long id) {
        try {
        	skill existUser = userService4.getSkill(id);
            user.setId(id);            
            userService4.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/proyectos/{id}")
    public ResponseEntity<?> update(@RequestBody proyectos user, @PathVariable Long id) {
        try {
        	proyectos existUser = userService5.getProyectos(id);
            user.setId(id);            
            userService5.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/fondo/{id}")
    public ResponseEntity<?> update(@RequestBody imgFondo user, @PathVariable Long id) {
        try {
        	imgFondo existUser = userService6.getLink(id);
            user.setId(id);            
            userService6.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/perfil/{id}")
    public ResponseEntity<?> update(@RequestBody ImgPerfil user, @PathVariable Long id) {
        try {
        	ImgPerfil existUser = userService7.getLink(id);
            user.setId(id);            
            userService7.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("persona/{id}")
    public void delete(@PathVariable Long id) {

        userService.deleteNombre(id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("estudio/{id}")
    public void deleteEst(@PathVariable Long id) {

        userService3.deleteEstudio(id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("skill/{id}")
    public void deleteSkill(@PathVariable Long id) {

        userService4.deleteSkill(id);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("proyectos/{id}")
    public void deleteProy(@PathVariable Long id) {

        userService5.deleteProyectos(id);
    }
}
