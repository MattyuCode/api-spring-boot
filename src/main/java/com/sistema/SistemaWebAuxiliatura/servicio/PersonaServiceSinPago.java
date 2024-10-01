package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonaSinPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceSinPago {
    @Autowired
    private PersonaSinPagoRepository personaSinPagoRepository;
    public List<PersonaSinPagoDTO> obtenerPersonasSinPago(Long idTipoPago) {
        return personaSinPagoRepository.findPersonasSinPago(idTipoPago);

    }
}
