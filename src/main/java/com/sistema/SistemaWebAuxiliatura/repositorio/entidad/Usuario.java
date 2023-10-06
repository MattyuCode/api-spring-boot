package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Usuario {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombreApellido;
    private String nombreUsuario;
    private String contrasenia;
    private Integer idRol;

    public Usuario(Long idUsuario, String nombreApellido, String nombreUsuario, String contrasenia, Integer idRol) {
        this.idUsuario = idUsuario;
        this.nombreApellido = nombreApellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idRol = idRol;
    }

    public Usuario(String nombreApellido, String nombreUsuario, String contrasenia, Integer idRol) {

        this.nombreApellido = nombreApellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idRol = idRol;
    }

    public Usuario() {

    }


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }


}
