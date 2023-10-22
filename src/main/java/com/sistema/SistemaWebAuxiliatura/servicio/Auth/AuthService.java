package com.sistema.SistemaWebAuxiliatura.servicio.Auth;

import com.sistema.SistemaWebAuxiliatura.DTO.SignUpDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.UserDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;

public interface AuthService {
   // UserDTO createUser(SignUpDTO signUpDTO);

     Usuario createUser(SignUpDTO signUpDTO);

}
