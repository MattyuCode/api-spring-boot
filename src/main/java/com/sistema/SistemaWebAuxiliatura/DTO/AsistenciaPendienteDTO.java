package com.sistema.SistemaWebAuxiliatura.DTO;

public class AsistenciaPendienteDTO {
    private Long idActivdadAsistencia;
    private String nombreActividad;

    //private String nombreApellido;




    public AsistenciaPendienteDTO(Long idActivdadAsistencia, String nombreActividad) {
        this.idActivdadAsistencia = idActivdadAsistencia;
        this.nombreActividad = nombreActividad;

    }

    public Long getIdActivdadAsistencia() {
        return idActivdadAsistencia;
    }

    public void setIdActivdadAsistencia(Long idActivdadAsistencia) {
        this.idActivdadAsistencia = idActivdadAsistencia;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
}
