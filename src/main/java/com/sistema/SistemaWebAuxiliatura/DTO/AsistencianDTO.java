package com.sistema.SistemaWebAuxiliatura.DTO;

import org.antlr.v4.runtime.atn.LL1Analyzer;

public class AsistencianDTO {
    private Long idActividadAsistencia;
    private String nombreActividad;

    public AsistencianDTO(Long idActividadAsistencia, String nombreActividad) {
        this.idActividadAsistencia = idActividadAsistencia;
        this.nombreActividad = nombreActividad;
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
}
