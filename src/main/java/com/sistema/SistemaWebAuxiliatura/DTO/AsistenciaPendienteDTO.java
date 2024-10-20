package com.sistema.SistemaWebAuxiliatura.DTO;

public class AsistenciaPendienteDTO {
    private Long idActivdadAsistencia;
    private String nombreActividad;
    private Long idPersona;

    private String nombreApellido;


    public AsistenciaPendienteDTO(Long idActivdadAsistencia, String nombreActividad, Long idPersona, String nombreApellido) {
        this.idActivdadAsistencia = idActivdadAsistencia;
        this.nombreActividad = nombreActividad;
        this.idPersona = idPersona;
        this.nombreApellido = nombreApellido;
    }

    /*public AsistenciaPendienteDTO(Long idActivdadAsistencia, String nombreActividad) {
        this.idActivdadAsistencia = idActivdadAsistencia;
        this.nombreActividad = nombreActividad;

    }
*/
    public Long getIdActivdadAsistencia() {
        return idActivdadAsistencia;
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
