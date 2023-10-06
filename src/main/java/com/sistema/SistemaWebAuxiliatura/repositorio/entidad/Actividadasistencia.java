package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actividadasistencia {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividadAsistencia;
    private String nombreActividad;
    private  Long idUsuario;

    public Actividadasistencia(Long idActividadAsistencia, String nombreActividad, Long usuario) {
        this.idActividadAsistencia = idActividadAsistencia;
        this.nombreActividad = nombreActividad;
        this.idUsuario = usuario;
    }

    public Actividadasistencia(String nombreActividad, Long usuario) {

        this.nombreActividad = nombreActividad;
        this.idUsuario= usuario;

    }

    public Actividadasistencia() {

    }


    public Long getIdActividadAsistencia() {
        return idActividadAsistencia;
    }

    public void setIdActividadAsistencia(Long idActividadAsistencia) {
        this.idActividadAsistencia = idActividadAsistencia;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long usuario) {
        this.idUsuario = usuario;
    }
}
