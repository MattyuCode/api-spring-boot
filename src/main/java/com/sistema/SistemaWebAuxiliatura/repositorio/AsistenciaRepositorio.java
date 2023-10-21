package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AsistenciaRepositorio  extends CrudRepository<Asistencia, Long> {

    List<Asistencia> findByidPersona(long idPersona);
}
