package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import com.sistema.SistemaWebAuxiliatura.servicio.PersonaServiceSinPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SINPAGO")
public class PersonaSinPagoController {

    @Autowired
    private PersonaServiceSinPago personaServiceSinPago;

    @GetMapping
            @RequestMapping(value = "/personas-sin-pago/{idTipoPago}", method = RequestMethod.GET)
    public List<PersonaSinPagoDTO> obtenerPersonasSinPago  (@PathVariable long idTipoPago){
        return  personaServiceSinPago.obtenerPersonasSinPago(idTipoPago);

    }

}
