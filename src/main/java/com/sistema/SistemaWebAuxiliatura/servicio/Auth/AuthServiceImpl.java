package com.sistema.SistemaWebAuxiliatura.servicio.Auth;

import com.sistema.SistemaWebAuxiliatura.DTO.SignUpDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.UserDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.UsuarioRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /* @Override
    public UserDTO createUser(SignUpDTO signUpDTO) {
        Usuario user = new Usuario();
        user.setNombreApellido(signUpDTO.getName());
        user.setEmail(signUpDTO.getEmail());
        user.setNombreUsuario(signUpDTO.getUsername());
        user.setIdRol(signUpDTO.getRol());
        user.setContrasenia(new BCryptPasswordEncoder().encode(signUpDTO.getPassword()));
        Usuario createdUser = usuarioRepositorio.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getIdUsuario());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setName(createdUser.getNombreApellido());
        userDTO.setUsername(createdUser.getNombreUsuario());
        return userDTO;
    }*/


   @Override
    public Usuario createUser(SignUpDTO signUpDTO) {
        Usuario user = new Usuario();
        user.setNombreApellido(signUpDTO.getName());
        user.setEmail(signUpDTO.getEmail());
        user.setNombreUsuario(signUpDTO.getUsername());
        user.setIdRol(signUpDTO.getRol());
        user.setContrasenia(new BCryptPasswordEncoder().encode(signUpDTO.getPassword()));
        Usuario createdUser = usuarioRepositorio.save(user);
        return createdUser;
    }
}
