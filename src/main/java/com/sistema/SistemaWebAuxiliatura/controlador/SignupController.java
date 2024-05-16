package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.SignUpDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.UserDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import com.sistema.SistemaWebAuxiliatura.servicio.Auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SignupController {
    @Autowired
    private AuthService authService;

    /* @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody SignUpDTO signupDTO) {
        UserDTO createdUser = authService.createUser(signupDTO);
        if (createdUser == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }*/


    @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody SignUpDTO signupDTO) {

        try {
            Usuario createdUser = authService.createUser(signupDTO);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            Map<String, String> response = new HashMap<>();
            String message = "El nombre de usuario ya existe.";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
