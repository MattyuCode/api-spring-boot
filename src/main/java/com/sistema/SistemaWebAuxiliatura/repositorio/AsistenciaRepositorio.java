package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AsistenciaRepositorio  extends JpaRepository<Asistencia, Long> {


   // List<Asistencia> findByidPersona(long idPersona);
    List<Asistencia> findByidPersona_idPersona(long idPersona);
    @Query("SELECT new com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO(ap.idActividadAsistencia, ap.nombreActividad, lp.idPersona, lp.nombreApellido) " +
            "FROM Actividadasistencia ap " +
            "LEFT JOIN Asistencia p ON ap.idActividadAsistencia = p.tipoAsistencia.idActividadAsistencia AND p.idPersona.idPersona = :idPersona " +
            "LEFT JOIN Listadogeneralpersona lp ON lp.idPersona = :idPersona " +
            "WHERE p.idAsistencia IS NULL")
    List<AsistenciaPendienteDTO> findAsistenciasPendientes(@Param("idPersona") Long idPersona);
   // List<PersonaSinAsistenciaDTO> findPersonasSinAsistencia(@Param("tipoAsistencia") Long tipoAsistencia);
   // List<AsistenciaPendienteDTO> findAsistenciaPendientePorPersona(@Param("idPersona") Long idPersona);



}
