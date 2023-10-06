package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

@Entity
public class Pago {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;
    private Long idPersona;
    private Double cantidad_Q;
    private Long idTipoPago;
    private String descripcion;
    @Nullable
    private Long idUsuarioRegistro;
    @Nullable
    private LocalDateTime fechaRegistro;

    @Nullable
    private Long idUsuarioModifica;
    @Nullable
    private LocalDateTime fechaModificado;


    public Pago(long idPersona, Double cantidad_Q, long idTipoPago, String descripcion, long idUsuarioRegistro, Long idUsuarioModifica) {
        this.idPersona = idPersona;
        this.cantidad_Q = cantidad_Q;
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioModifica = idUsuarioModifica;
        this.fechaModificado = fechaModificado;
    }

    public Pago( long idPago, long idPersona, Double cantidad_Q, long idTipoPago, String descripcion, long idUsuarioRegistro, Long idUsuarioModifica) {
        this.idPago = idPago;
        this.idPersona = idPersona;
        this.cantidad_Q = cantidad_Q;
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioModifica = idUsuarioModifica;
        this.fechaModificado = fechaModificado;
    }

    public Pago() {

    }


    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Double getCantidad_Q() {
        return cantidad_Q;
    }

    public void setCantidad(Double cantidad_Q) {
        this.cantidad_Q = cantidad_Q;
    }

    public Long getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Long idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Long idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro = LocalDateTime.now();
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdUsuarioModifica() {
        return idUsuarioModifica;
    }

    public void setIdUsuarioModifica(Long idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }

    public LocalDateTime getFechaModificado() {

        return fechaModificado = LocalDateTime.now();
    }

    public void setFechaModificado(LocalDateTime fechaModificado) {
        this.fechaModificado = fechaModificado;
    }


}
