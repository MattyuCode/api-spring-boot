package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;

import java.util.List;

public interface AsistenciaServicio {
    List<Asistencia> listarTodasLasAsistencias();

    Asistencia CrearAsistencia(Asistencia asistencia);

    Asistencia ModificarAsistencia(Asistencia asistencia);

    Asistencia BuscarAsistencia(long idAsistencia);

    void EliminarAsistencia(long idAsistencia);

    List<Asistencia> findByidPersona(long idPersona);
}
