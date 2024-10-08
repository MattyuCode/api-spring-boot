package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaSinPagoRepository extends JpaRepository<Listadogeneralpersona, Long> {

    //com.tu.paquete.PersonaSinPagoDTO
    @Query("SELECT new com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO(lp.idPersona, lp.nombreApellido) " +
            "FROM Listadogeneralpersona lp " +
            "LEFT JOIN Pago p ON lp.idPersona = p.idPersona AND p.idTipoPago = :idTipoPago " +
            "WHERE p.idPago IS NULL")
    List<PersonaSinPagoDTO> findPersonasSinPago(Long idTipoPago);
}
