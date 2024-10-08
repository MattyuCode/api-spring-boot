package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

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
    private String dpi;



    //FECHA SE REGISTRA POR DEFAUL: FECHA ACTUAL
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaRegistrado = LocalDateTime.now();

    public LocalDateTime getFechaRegistrado() {
        return fechaRegistrado;
    }

    public void setFechaRegistrado(LocalDateTime fechaRegistrado) {
        this.fechaRegistrado = fechaRegistrado;
    }

    public Listadogeneralpersona(String nombreApellido, long telefono, long sector, long idUsuarioRegistro, String dpi) {

        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.sector = sector;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.dpi = dpi;
        this.fechaRegistrado = LocalDateTime.now();

    }

    public Listadogeneralpersona() {
       this.fechaRegistrado = LocalDateTime.now();
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

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

}
