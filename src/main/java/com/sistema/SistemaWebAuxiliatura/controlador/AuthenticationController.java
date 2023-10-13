package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.AuthenticationDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.AuthenticationResponse;
import com.sistema.SistemaWebAuxiliatura.Utils.JwtUtil;
import com.sistema.SistemaWebAuxiliatura.servicio.JWT.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody
                                                                AuthenticationDTO authenticationDTO,
                                                            HttpServletResponse response) throws
            BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));

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
    }

}
