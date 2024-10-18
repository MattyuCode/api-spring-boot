package com.sistema.SistemaWebAuxiliatura.DTO;

public class ActividadSinPagoDTO {

    //FUNCIONA
    private Long idActividadPago;
    private String nombreActividad;
    private Double cantidad;

    public ActividadSinPagoDTO(Long idActividadPago, String nombreActividad, Double cantidad) {
        this.idActividadPago = idActividadPago;
        this.nombreActividad = nombreActividad;
        this.cantidad = cantidad;
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
