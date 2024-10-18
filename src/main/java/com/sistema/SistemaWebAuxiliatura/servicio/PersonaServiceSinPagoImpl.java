package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.ActividadPagoRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonaSinPagoRepository;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceSinPagoImpl {
    @Autowired
    private PersonaSinPagoRepository personaSinPagoRepository;

    @Autowired
    private ActividadPagoRepositorio actividadPagoRepositorio;
    public List<PersonaSinPagoDTO> obtenerPersonaPendiente(Long idTipoPago) {
        return personaSinPagoRepository.findPersonasSinPago(idTipoPago);

    }


    public Actividadpago obtenerActividadPorId(Long actividadId) {
        return actividadPagoRepositorio.findById(actividadId)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }
}
