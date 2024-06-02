package com.sistema.SistemaWebAuxiliatura.servicio.JWT;

import com.sistema.SistemaWebAuxiliatura.repositorio.UsuarioRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import com.sistema.SistemaWebAuxiliatura.servicio.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user =  userRepository.findBynombreUsuario(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario no encotrado",null);
        }
        //return new User(user.getNombreUsuario(), user.getContrasenia(), new ArrayList<>());
        return new CustomUserDetails(user);
    }
}
