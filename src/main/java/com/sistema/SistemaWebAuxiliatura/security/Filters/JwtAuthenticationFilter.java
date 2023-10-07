package com.sistema.SistemaWebAuxiliatura.security.Filters;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import com.sistema.SistemaWebAuxiliatura.security.jwt.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {

        this.jwtUtils = jwtUtils;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        Usuario userEntity = null;
        String userName = "";
        String password = "";

        try {
            userEntity = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            userName = userEntity.getNombreUsuario();
            password = userEntity.getContrasenia();

        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);


        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String token = jwtUtils.GenerateAccessToken(user.getUsername());

        response.addHeader("Authorization", token);
        Map<String, Object> httResponse = new HashMap<>();
        httResponse.put("Access_Token", token);
        httResponse.put("Message", "Autenticación Correcta");
        httResponse.put("UserName", user.getUsername());

        response.getWriter().write(new ObjectMapper().writeValueAsString(httResponse));
        response.setStatus(HttpStatus.OK.value());

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
