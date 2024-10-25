package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.DTO.ActividadSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicio;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api/CRUDACTIVIDAD")
public class ActividadPagoControlador {
    @Autowired
    private ActividadPagoServicioImpl servicioIMPL;


    @GetMapping
    @RequestMapping(value = "ConsultarActividad", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarActividad() {
        List<Actividadpago> listarActividad = this.servicioIMPL.listarTodosLasActividades();
        return ResponseEntity.ok(listarActividad);
    }


    @PostMapping
    @RequestMapping(value = "CrearActividad", method = RequestMethod.POST)
    public ResponseEntity<?> CrearActividad(@RequestBody Actividadpago actividadpago) {
        Actividadpago ActividadCreada = this.servicioIMPL.CrearActividad(actividadpago);
        return ResponseEntity.status(HttpStatus.CREATED).body(ActividadCreada);
    }


    @PutMapping
    @RequestMapping(value = "ModificarActividad", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarActividad(@RequestBody Actividadpago actividadpago) {
        Actividadpago EditarActividad = this.servicioIMPL.ModificarActividad(actividadpago);
        return ResponseEntity.status(HttpStatus.CREATED).body(EditarActividad);
    }

    @GetMapping
    @RequestMapping(value = "BuscarActividad/{idActividad}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarActividad(@PathVariable long idActividad) {
        Actividadpago BuscarActividadById = this.servicioIMPL.BuscarActividad(idActividad);
        return ResponseEntity.ok(BuscarActividadById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarActividad/{idActividad}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarActividad(@PathVariable long idActividad) {

        try {
            this.servicioIMPL.EliminarActividad(idActividad);
            Map<String, String> response = new HashMap<>();
            response.put("Result", "Actividad pago Eliminado exitosamente");
            return ResponseEntity.ok(response);
        } catch (IllegalStateException e) {
            Map<String, String> response = new HashMap<>();
            response.put("Result", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}