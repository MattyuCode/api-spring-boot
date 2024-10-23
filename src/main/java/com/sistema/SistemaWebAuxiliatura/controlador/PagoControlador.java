package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.ActividadSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PagoPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicio;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicioImpl;
import com.sistema.SistemaWebAuxiliatura.servicio.PagosServicio;
import com.sistema.SistemaWebAuxiliatura.servicio.PagosServicioImpl;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/CRUDPAGO")
public class PagoControlador {
    @Autowired
    private PagosServicioImpl pagosServicioIMPL;


    //FUNCIONA


    // muestra los pagos de idPersona no tiene registrado
    @GetMapping("/pendientes/{idPersona}")
    public ResponseEntity<List<PagoPendienteDTO>> obtenerPagosPendientes(@PathVariable Long idPersona) {
        List<PagoPendienteDTO> pagosPendientes = pagosServicioIMPL.obtenerPagosPendientes(idPersona);
        if (pagosPendientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagosPendientes);
    }

  /*  @GetMapping
    @RequestMapping(value = "/personas-sin-pago/{idTipoPago}", method = RequestMethod.GET)
    public List<PersonaSinPagoDTO> obtenerPersonasSinPago  (@PathVariable long idTipoPago){
        return  personaServiceSinPago.obtenerPersonasSinPago(idTipoPago);

    }
*/


   /* @GetMapping("/sin-pago/{idPersona}")
    public List<ActividadSinPagoDTO> getActividadesSinPagoByIdPersona(@PathVariable int idPersona) {
        return actividadpagoService.getActividadesSinPagoByIdPersona(idPersona);
    }*/


/*------------------------------------
   /* @GetMapping
    @RequestMapping(value = "BuscarPago/{idPago}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPago(@PathVariable long idPago){
        Pago BuscarPagoById = this.pagosServicio.BuscarPago(idPago);
        return ResponseEntity.ok(BuscarPagoById);
    }
*/



    /*@RequestMapping(value = "ConsultarPago", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarPago(){
        List<Pago> listarPago= this.pagosServicioIMPL.listarTodosLosPagos();
        return  ResponseEntity.ok(listarPago);
    }*/

    @GetMapping
    @RequestMapping(value = "GetAllPago", method = RequestMethod.GET)
    public ResponseEntity<?> GetAllPago (){
        List<Pago> listaPago = this.pagosServicioIMPL.listarTodosLosPagos();
        Map<String, List<Pago>> response = new HashMap<>();
        response.put("Result", listaPago);
        return ResponseEntity.ok(response);
    }

    //No funciona
    @GetMapping
    @RequestMapping(value = "buscarPorIdPersona/{id_persona}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorIdPersona(@PathVariable long id_persona) {
      List<Pago>   listaPersona = (List<Pago>) this.pagosServicioIMPL.findByidPersona(id_persona);
        return ResponseEntity.ok(listaPersona);
    }





    @PostMapping
    @RequestMapping(value = "CrearPago", method = RequestMethod.POST)
    public ResponseEntity<?> CrearPago(@RequestBody Map<String, Object> newPago){
        Pago newLista = this.pagosServicioIMPL.CrearPago(newPago);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newLista);
    }

    @PutMapping
    @RequestMapping(value = "ModificarPago", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarPago(@RequestBody Pago pago){
        Pago EditarPago = this.pagosServicioIMPL.ModificarPago(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(EditarPago);
    }

    /// no busca los pagos
    @GetMapping
    @RequestMapping(value = "BuscarPago/{idPago}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPago(@PathVariable long idPago){
        Pago BuscarPagoById = this.pagosServicioIMPL.BuscarPago(idPago);
        return ResponseEntity.ok(BuscarPagoById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarPago/{idPago}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPago(@PathVariable long idPago){
        this.pagosServicioIMPL.EliminarPago(idPago);
        return ResponseEntity.ok().build();

    }
}


