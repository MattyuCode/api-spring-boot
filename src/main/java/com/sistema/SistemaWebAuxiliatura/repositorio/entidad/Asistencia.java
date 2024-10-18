package com.sistema.SistemaWebAuxiliatura.repositorio.entidad;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table (name = "asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAsistencia;

    @ManyToOne
    @JoinColumn  (name = "id_persona", referencedColumnName = "id_persona")
    private Listadogeneralpersona idPersona;

    @ManyToOne
    @JoinColumn (name = "tipo_asistencia", referencedColumnName = "id_actividad_asistencia")
    private Actividadasistencia tipoAsistencia;
    private String descripcion;
    @Nullable
    private long idUsuarioRegistro;
    @Nullable

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaRegistro;
    @Nullable
    private long idUsuarioModifica;
    @Nullable

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaModificado;


    public Asistencia() {
    }
/*
    public Asistencia(long idAsistencia, long idPersona, String asistencia, long tipoAsistencia, String descripcion, long idUsuarioRegistro, Date fechaRegistro, long idUsuarioModifica, LocalDateTime fechaModificado) {
        this.idAsistencia = idAsistencia;
        this.idPersona = idPersona;
        this.asistencia = asistencia;
        this.tipoAsistencia = tipoAsistencia;
        this.descripcion = descripcion;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioModifica = idUsuarioModifica;
        this.fechaModificado = fechaModificado;
    }
*/
    public long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Listadogeneralpersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Listadogeneralpersona idPersona) {
        this.idPersona = idPersona;
    }



    public Actividadasistencia getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(Actividadasistencia tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(long idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public long getIdUsuarioModifica() {
        return idUsuarioModifica;
    }

    public void setIdUsuarioModifica(long idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }

    public LocalDateTime getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(LocalDateTime fechaModificado) {
        this.fechaModificado = fechaModificado;
    }
}
