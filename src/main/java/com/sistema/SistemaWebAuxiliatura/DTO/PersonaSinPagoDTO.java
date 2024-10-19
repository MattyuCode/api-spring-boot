package com.sistema.SistemaWebAuxiliatura.DTO;

public class PersonaSinPagoDTO {

    private Long idPersona;
    private String nombreApellido;
    private String nombreActividad;
    private Double cantidad;


    public PersonaSinPagoDTO(Long idPersona, String nombreApellido, String nombreActividad, Double cantidad) {
        this.idPersona = idPersona;
        this.nombreApellido = nombreApellido;
        this.nombreActividad = nombreActividad;
        this.cantidad = cantidad;
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
