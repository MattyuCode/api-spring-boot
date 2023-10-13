package com.sistema.SistemaWebAuxiliatura.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Long rol;
}
