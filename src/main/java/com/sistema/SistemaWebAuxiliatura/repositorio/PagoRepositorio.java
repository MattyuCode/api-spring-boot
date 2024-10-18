package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.DTO.PagoPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Long> {
 //FUNCIONA
        List<Pago> findByidPersona_IdPersona(Long idPersona);

        @Query("SELECT new com.sistema.SistemaWebAuxiliatura.DTO.PagoPendienteDTO(ap.idActividadPago, ap.nombreActividad, ap.cantidad) " +
                "FROM Actividadpago ap LEFT JOIN Pago p ON ap.idActividadPago = p.idTipoPago.idActividadPago " +
                "AND p.idPersona.idPersona = :idPersona WHERE p.idPago IS NULL")
        List<PagoPendienteDTO> findPagosPendientesPorPersona(@Param("idPersona") Long idPersona);
}
