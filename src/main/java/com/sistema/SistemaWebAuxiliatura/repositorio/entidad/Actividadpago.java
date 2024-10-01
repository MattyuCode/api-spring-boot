package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Actividadpago {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idActividadPago;
    private String nombreActividad;
    private Double cantidad;
    private  Long idUsuario;




    public Actividadpago(long idActividadPago, String nombreActividad, double cantidad, long idUsuario) {
        this.idActividadPago = idActividadPago;
        this.nombreActividad = nombreActividad;
        this.cantidad = cantidad;
        this.idUsuario = idUsuario;
    }

    public Actividadpago(String nombreActividad, double cantidad, long idUsuario) {

        this.nombreActividad = nombreActividad;
        this.cantidad = cantidad;
        this.idUsuario = idUsuario;
    }

    public Actividadpago() {

    }

    public Long getIdActividadPago() {
        return idActividadPago;
    }

    public void setIdActividadPago(Long idActvidadPago) {
        this.idActividadPago = idActvidadPago;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
