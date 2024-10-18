package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AsistenciaRepositorio  extends CrudRepository<Asistencia, Long> {

    List<Asistencia> findByidPersona_idPersona(long idPersona);
    @Query("SELECT new com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO(ap.idActividadAsistencia, ap.nombreActividad) "+
          "FROM Actividadasistencia ap LEFT JOIN Asistencia p ON ap.idActividadAsistencia = p.tipoAsistencia.idActividadAsistencia "+
          "AND p.idPersona.idPersona = :idPersona WHERE p.idAsistencia IS NULL ")
    List<AsistenciaPendienteDTO> findAsistenciaPendientePorPersona(@Param("idPersona") Long idPersona);
}
