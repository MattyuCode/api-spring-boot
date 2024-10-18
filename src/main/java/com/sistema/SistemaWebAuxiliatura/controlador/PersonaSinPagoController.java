package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.servicio.PersonaServiceSinPagoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SINPAGO")
public class PersonaSinPagoController {


    // NO FUNCIONA
    @Autowired
    private PersonaServiceSinPagoImpl personaServiceSinPago;



    /*@GetMapping
    @RequestMapping(value = "/personas-sin-pago/{idTipoPago}", method = RequestMethod.GET)
    public List<PersonaSinPagoDTO> obtenerPersonasSinPago(@PathVariable Long idTipoPago) {
        return personaServiceSinPago.obtenerPersonaPendiente(idTipoPago);
    }*/



   // Muestra las personas que no tienen registrado el idTipoPago
    @GetMapping("/personasinPago2/{idTipoPago}")
    public ResponseEntity<List<PersonaSinPagoDTO>> obtenerPersonaPendiente(@PathVariable Long idTipoPago){
        List<PersonaSinPagoDTO> personaSinPagoDTOS = personaServiceSinPago.obtenerPersonaPendiente(idTipoPago);
        return ResponseEntity.ok(personaSinPagoDTOS);
    }
}
