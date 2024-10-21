package com.sistema.SistemaWebAuxiliatura.DTO;

public class PagoPendienteDTO {
    //FUNCIONA
    private Long idActividadPago;
    private String nombreActividad;
    private Double cantidad;
    private Long idPersona;
    private String nombreApellido;


    public PagoPendienteDTO(Long idActividadPago, String nombreActividad, Double cantidad, Long idPersona, String nombreApellido) {
        this.idActividadPago = idActividadPago;
        this.nombreActividad = nombreActividad;
        this.cantidad = cantidad;
        this.idPersona = idPersona;
        this.nombreApellido = nombreApellido;
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

    public Long getIdActividadPago() {
        return idActividadPago;
    }

    public void setIdActividadPago(Long idActividadPago) {
        this.idActividadPago = idActividadPago;
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
