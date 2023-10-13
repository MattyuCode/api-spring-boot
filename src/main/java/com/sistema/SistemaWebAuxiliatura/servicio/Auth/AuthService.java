package com.sistema.SistemaWebAuxiliatura.servicio.Auth;

import com.sistema.SistemaWebAuxiliatura.DTO.SignUpDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.UserDTO;

public interface AuthService {
    UserDTO createUser(SignUpDTO signUpDTO);
}
