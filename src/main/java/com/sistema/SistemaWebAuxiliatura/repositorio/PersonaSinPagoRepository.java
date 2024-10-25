package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaSinPagoRepository extends JpaRepository<Listadogeneralpersona, Long> {

    //CODIDO FUNCIONA
    @Query("SELECT new com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO(lp.idPersona, lp.nombreApellido, aa.nombreActividad, aa.cantidad) " +
            "from Listadogeneralpersona lp, Actividadpago aa " +
            "where aa.idActividadPago = :idTipoPago " +
            "and not exists (" +
            "    select 1 from Pago a " +
            "    where a.idPersona.idPersona = lp.idPersona " +
            "    and a.idTipoPago.idActividadPago = aa.idActividadPago" +
            ")")

    List<PersonaSinPagoDTO> findPersonasSinPago(Long idTipoPago);
}
