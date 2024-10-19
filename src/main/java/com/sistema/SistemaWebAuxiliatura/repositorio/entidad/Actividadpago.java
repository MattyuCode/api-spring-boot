package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;


@Entity
@Table(name = "actividadpago")
public class Actividadpago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad_pago")
    private  Long idActividadPago;

    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Column(name = "cantidad")
    private Double cantidad;
    private  Long idUsuario;


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
