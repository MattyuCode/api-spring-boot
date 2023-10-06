package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Listadogeneralpersona {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombreApellido;
    private Long telefono;
    private Long sector;
    private Long idUsuarioRegistro;
    private LocalDateTime fechaRegistrado;





    public Listadogeneralpersona(String nombreApellido, long telefono, long sector, long idUsuarioRegistro) {

        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.sector = sector;
        this.idUsuarioRegistro = idUsuarioRegistro;


    }

    public Listadogeneralpersona() {

    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getSector() {
        return sector;
    }

    public void setSector(Long sector) {
        this.sector = sector;
    }

    public Long getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Long idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public LocalDateTime getFechaRegistrado() {
        return fechaRegistrado = LocalDateTime.now();
    }

    public void setFechaRegistrado(LocalDateTime fechaRegistrado) {
        this.fechaRegistrado = fechaRegistrado;
    }

}
