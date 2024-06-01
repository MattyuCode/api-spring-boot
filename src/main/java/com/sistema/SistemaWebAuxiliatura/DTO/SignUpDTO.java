package com.sistema.SistemaWebAuxiliatura.DTO;

import lombok.Data;

@Data
public class SignUpDTO {
    private String name;
    private String telefono;
    private String username;
    private String password;
    private Long rol;
}
