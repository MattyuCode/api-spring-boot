package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;

import java.util.List;

public interface PersonaServiceSinAsistencia {

    List<PersonaSinAsistenciaDTO> obtenerPersonaPendienteAsistencia (Long tipoAsistencia);
}
