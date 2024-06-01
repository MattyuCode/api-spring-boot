package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.AuthenticationDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.AuthenticationResponse;
import com.sistema.SistemaWebAuxiliatura.Utils.JwtUtil;
import com.sistema.SistemaWebAuxiliatura.servicio.JWT.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /*
    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody
                                                                AuthenticationDTO authenticationDTO,
                                                            HttpServletResponse response) throws
            BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));

            //Validar bien la contraseña y el usuario si existe
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Usuario o contraseña incorrecta");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuario no esta activo");
            return null;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getUsername());
        final String access_token = jwtUtil.generateToken(userDetails.getUsername());
        String user = jwtUtil.extractUsername(access_token);
        Date expirationDate = jwtUtil.extractExpiration(access_token);
        return new AuthenticationResponse(access_token, user, expirationDate);
    }*/


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO) {
        try {
            //Encontrar el usuario si esta activo o no
            UserDetails user = userDetailsService.loadUserByUsername(authenticationDTO.getUsername());
//            if (user.isEnabled()) {
//                Map<String, String> response = new HashMap<>();
//                response.put("Message", "El usuario esta inactivo");
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//            }

            //Comparando contraseña del ingresaddo por el usuario y el  que esta guardado en la DB
            if (!passwordEncoder.matches(authenticationDTO.getPassword(), user.getPassword())) {
                Map<String, String> response = new HashMap<>();
//                response.put("Message", "Usuario o contraseña incorrecta");
                response.put("Message", "Contraseña incorrecta");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            String access_token = jwtUtil.generateToken(user.getUsername());
            String users = jwtUtil.extractUsername(access_token);
            Date expiractionToken = jwtUtil.extractExpiration(access_token);

            AuthenticationResponse response = new AuthenticationResponse(access_token, users, expiractionToken);
            return ResponseEntity.ok(response);

        } catch (UsernameNotFoundException e) {
            Map<String, String> response = new HashMap<>();
            response.put("Message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
