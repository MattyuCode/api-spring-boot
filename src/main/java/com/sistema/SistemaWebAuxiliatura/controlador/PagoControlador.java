package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.ActividadSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PagoPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicio;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicioImpl;
import com.sistema.SistemaWebAuxiliatura.servicio.PagosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/CRUDPAGO")
public class PagoControlador {
    @Autowired
    private  PagosServicio pagosServicio;


    //FUNCIONA


    // muestra los pagos de idPersona no tiene registrado
    @GetMapping("/pendientes/{idPersona}")
    public ResponseEntity<List<PagoPendienteDTO>> obtenerPagosPendientes(@PathVariable Long idPersona) {
        List<PagoPendienteDTO> pagosPendientes = pagosServicio.obtenerPagosPendientes(idPersona);
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



    @RequestMapping(value = "ConsultarPago", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarPago(){
        List<Pago> listarPago= this.pagosServicio.listarTodosLosPagos();
        return  ResponseEntity.ok(listarPago);
    }


    @GetMapping
    @RequestMapping(value = "buscarPorIdPersona/{id_persona}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorIdPersona(@PathVariable long id_persona) {
      List<Pago>   listaPersona = (List<Pago>) this.pagosServicio.findByidPersona(id_persona);
        return ResponseEntity.ok(listaPersona);
    }





    @PostMapping
    @RequestMapping(value = "CrearPago", method = RequestMethod.POST)
    public ResponseEntity<?> CrearPago(@RequestBody Pago pago){
        Pago PagoCreado = this.pagosServicio.CrearPago(pago);
        return  ResponseEntity.status(HttpStatus.CREATED).body(PagoCreado);
    }

    @PutMapping
    @RequestMapping(value = "ModificarPago", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarPago(@RequestBody Pago pago){
        Pago EditarPago = this.pagosServicio.ModificarPago(pago);
        return ResponseEntity.status(HttpStatus.CREATED).body(EditarPago);
    }

    @GetMapping
    @RequestMapping(value = "BuscarPago/{idPago}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPago(@PathVariable long idPago){
        Pago BuscarPagoById = this.pagosServicio.BuscarPago(idPago);
        return ResponseEntity.ok(BuscarPagoById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarPago/{idPago}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPago(@PathVariable long idPago){
        this.pagosServicio.EliminarPago(idPago);
        return ResponseEntity.ok().build();

    }
}


