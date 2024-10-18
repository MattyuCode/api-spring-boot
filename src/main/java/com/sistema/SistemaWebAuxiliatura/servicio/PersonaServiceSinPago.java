package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;

import java.util.List;

public interface PersonaServiceSinPago {
    List<PersonaSinPagoDTO> obtenerPersonaPendiente(Long idTipoPago);
}
