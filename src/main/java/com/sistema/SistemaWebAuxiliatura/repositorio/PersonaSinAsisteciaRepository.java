package com.sistema.SistemaWebAuxiliatura.repositorio;


import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaSinAsisteciaRepository extends JpaRepository<Listadogeneralpersona, Long> {

    @Query("SELECT new com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO(lp.idPersona, lp.nombreApellido, aa.nombreActividad) " +
            "FROM Listadogeneralpersona lp, Actividadasistencia  aa " +
            "WHERE aa.idActividadAsistencia = :tipoAsistencia " +
            "AND NOT EXISTS (" +
            "SELECT 1 " +
            "FROM Asistencia a " +
            "WHERE a.idPersona.idPersona = lp.idPersona " +
            "AND a.tipoAsistencia.idActividadAsistencia = aa.idActividadAsistencia)")
    List<PersonaSinAsistenciaDTO> findPersonaSinAsistencia(Long tipoAsistencia);
}
