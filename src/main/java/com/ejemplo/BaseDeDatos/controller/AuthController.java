package com.ejemplo.BaseDeDatos.controller;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.BaseDeDatos.ImgPerfil;
import com.ejemplo.BaseDeDatos.Persona;
import com.ejemplo.BaseDeDatos.estudio;
import com.ejemplo.BaseDeDatos.imgFondo;
import com.ejemplo.BaseDeDatos.proyectos;
import com.ejemplo.BaseDeDatos.roles;
import com.ejemplo.BaseDeDatos.rolesDeUsuarios;
import com.ejemplo.BaseDeDatos.skill;
import com.ejemplo.BaseDeDatos.sobreMi;
import com.ejemplo.BaseDeDatos.usuarios;
import com.ejemplo.BaseDeDatos.repository.RoleRepository;
import com.ejemplo.BaseDeDatos.repository.UserRepositoryB;
import com.ejemplo.BaseDeDatos.request.LoginRequest;
import com.ejemplo.BaseDeDatos.request.SignupRequest;
import com.ejemplo.BaseDeDatos.response.UserInfoResponse;
import com.ejemplo.BaseDeDatos.response.MessageResponse;
import com.ejemplo.BaseDeDatos.security.jwt.JwtUtils;
import com.ejemplo.BaseDeDatos.security.jwt.service.UserDetailsImpl;
import com.ejemplo.BaseDeDatos.service.UserService;
import com.ejemplo.BaseDeDatos.service.UserService2;
import com.ejemplo.BaseDeDatos.service.UserService3;
import com.ejemplo.BaseDeDatos.service.UserService4;
import com.ejemplo.BaseDeDatos.service.UserService5;
import com.ejemplo.BaseDeDatos.service.UserService6;
import com.ejemplo.BaseDeDatos.service.UserService7;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepositoryB userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  
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
  
  
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(jwt,
        							userDetails.getId(),
                                   userDetails.getUsername(),
                                   userDetails.getEmail(),
                                   roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: El Username ya esta en uso!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: El Email ya esta en uso!"));
    }

    // Create new user's account
    usuarios user = new usuarios(signUpRequest.getUsername(),
                         signUpRequest.getEmail(),
                         encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<roles> roles = new HashSet<>();

    if (strRoles == null) {
      roles userRole = roleRepository.findByName(rolesDeUsuarios.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          roles adminRole = roleRepository.findByName(rolesDeUsuarios.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          roles modRole = roleRepository.findByName(rolesDeUsuarios.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          roles userRole = roleRepository.findByName(rolesDeUsuarios.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }


  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
  
  
  

  @GetMapping("/users/persona")
  public List<Persona> list() {
      return userService.listAllUser();
  }
  
 
  @GetMapping("/users/sobreMi")
  public List<sobreMi> listSobreMi() {
      return userService2.listAllUserSobreMi();
  }
  

  @GetMapping("/users/estudio")
  public List<estudio> listEstudio() {
      return userService3.listAllUserEstudio();
  }
  

  @GetMapping("/users/skill")
  public List<skill> listSkill() {
      return userService4.listAllUserSkill();
  }
  
 
  @GetMapping("/users/proyectos")
  public List<proyectos> listProyectos() {
      return userService5.listAllUserProyectos();
  }
  

  @GetMapping("/users/fondo")
  public List<imgFondo> listFondo() {
      return userService6.listAllUserLink();
  }
  

  @GetMapping("/users/perfil")
  public List<ImgPerfil> listPerfil() {
      return userService7.listAllUserPerfil();
  }


  @GetMapping("/users/{id}")
  public ResponseEntity<Persona> get(@PathVariable Long id) {
      try {
          Persona user = userService.getNombre(id);
          return new ResponseEntity<Persona>(user, HttpStatus.OK);
      } catch (NoSuchElementException e) {
          return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
      }
  }
  

  @PostMapping("/users/persona")
  public void add(@RequestBody Persona user) {
      userService.saveUser(user);
  }
  

  @PostMapping("/users/sobreMi")
  public void add(@RequestBody sobreMi dato) {
      userService2.saveUser(dato);
  }
  

  @PostMapping("/users/estudio")
  public void add(@RequestBody estudio dato) {
      userService3.saveUser(dato);
  }
  

  @PostMapping("/users/skill")
  public void add(@RequestBody skill dato) {
      userService4.saveUser(dato);
  }
  

  @PostMapping("/users/proyectos")
  public void add(@RequestBody proyectos dato) {
      userService5.saveUser(dato);
  }
  

  @PostMapping("/users/fondo")
  public void add(@RequestBody imgFondo dato) {
      userService6.saveUser(dato);
  }
  

  @PostMapping("/users/perfil")
  public void add(@RequestBody ImgPerfil dato) {
      userService7.saveUser(dato);
  }
  

  @PutMapping("/users/persona/{id}")
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
  

  @PutMapping("/users/sobreMi/{id}")
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
  

  @PutMapping("/users/estudio/{id}")
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
  

  @PutMapping("/users/skill/{id}")
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
  

  @PutMapping("/users/proyectos/{id}")
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
  

  @PutMapping("/users/fondo/{id}")
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
  

  @PutMapping("/users/perfil/{id}")
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
  

  @DeleteMapping("/users/persona/{id}")
  public void delete(@PathVariable Long id) {

      userService.deleteNombre(id);
  }
  

  @DeleteMapping("/users/estudio/{id}")
  public void deleteEst(@PathVariable Long id) {

      userService3.deleteEstudio(id);
  }
  

  @DeleteMapping("/users/skill/{id}")
  public void deleteSkill(@PathVariable Long id) {

      userService4.deleteSkill(id);
  }
  

  @DeleteMapping("/users/proyectos/{id}")
  public void deleteProy(@PathVariable Long id) {

      userService5.deleteProyectos(id);
  }
}