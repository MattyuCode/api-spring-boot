package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;

import java.util.List;

public interface AsistenciaServicio {

    List<AsistenciaPendienteDTO> obtenerAsistenciasPendientes(Long idPersona);

    List<Asistencia> obtenerTodasLasAsistencias();

    Asistencia CrearAsistencia(Asistencia asistencia);

    Asistencia ModificarAsistencia(Asistencia asistencia);

    Asistencia BuscarAsistencia(long idAsistencia);

    void EliminarAsistencia(long idAsistencia);

    List<Asistencia> findByidPersona(long idPersona);
}
