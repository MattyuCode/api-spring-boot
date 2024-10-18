package com.sistema.SistemaWebAuxiliatura.DTO;

public class PersonaSinAsistenciaDTO {


    private Long idPersona;
    private String nombreApellido;

    public PersonaSinAsistenciaDTO(Long idPersona, String nombreApellido, String nombreActividad) {
        this.idPersona = idPersona;
        this.nombreApellido = nombreApellido;
        this.nombreActividad = nombreActividad;
    }

    private  String nombreActividad;


    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
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
}
