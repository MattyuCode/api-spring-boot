package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Listadogeneralpersona idPersona;



    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_actividad_pago")
    private Actividadpago idTipoPago;


    private String descripcion;
    @Nullable
    private Long idUsuarioRegistro;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaRegistro;

    @Nullable
    private Long idUsuarioModifica;
    @Nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaModificado;



    /*public Pago( long idPago, long idPersona, Double cantidad_Q, long idTipoPago, String descripcion, long idUsuarioRegistro, Long idUsuarioModifica) {
        this.idPago = idPago;
        this.idPersona = idPersona;
        this.cantidad_Q = cantidad_Q;
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioModifica = idUsuarioModifica;
        this.fechaModificado = fechaModificado;
    }*/

    public Pago() {

    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Listadogeneralpersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Listadogeneralpersona idPersona) {
        this.idPersona = idPersona;
    }

    public Actividadpago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Actividadpago idTipoPago) {
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
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