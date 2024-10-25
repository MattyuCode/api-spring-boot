package com.sistema.SistemaWebAuxiliatura.DTO;

public class PersonaSinPagoDTO {

    private Long id_persona;
    private String nombre_apellido;
    private String nombre_actividad;
    private Double cantidad;

    public PersonaSinPagoDTO(Long id_persona, String nombre_apellido, String nombre_actividad, Double cantidad) {
        this.id_persona = id_persona;
        this.nombre_apellido = nombre_apellido;
        this.nombre_actividad = nombre_actividad;
        this.cantidad = cantidad;
    }


    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}

