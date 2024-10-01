package com.sistema.SistemaWebAuxiliatura.DTO;

public class PersonaSinPagoDTO {
    private Long idPersona;
    private String nombreApellido;

    public PersonaSinPagoDTO(Long idPersona, String nombreApellido) {
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
}
