package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/CRUDACTIVIDAD")
public class ActividadPagoControlador {
    @Autowired
    private ActividadPagoServicio servicio;
   @GetMapping
    @RequestMapping(value = "ConsultarActividad", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarActividad(){
        List<Actividadpago> listarActividad= this.servicio.listarTodosLasActividades();
        return  ResponseEntity.ok(listarActividad);
    }


   @PostMapping
    @RequestMapping(value = "CrearActividad", method = RequestMethod.POST)
    public ResponseEntity<?> CrearActividad(@RequestBody Actividadpago actividadpago){
        Actividadpago ActividadCreada = this.servicio.CrearActividad(actividadpago);
        return  ResponseEntity.status(HttpStatus.CREATED).body(ActividadCreada);
    }


    @PutMapping
    @RequestMapping(value = "ModificarActividad", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarActividad(@RequestBody Actividadpago actividadpago){
        Actividadpago EditarActividad = this.servicio.ModificarActividad(actividadpago);
        return ResponseEntity.status(HttpStatus.CREATED).body(EditarActividad);
    }

    @GetMapping
    @RequestMapping(value = "BuscarActividad/{idActividad}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarActividad(@PathVariable long idActividad){
        Actividadpago BuscarActividadById = this.servicio.BuscarActividad(idActividad);
        return ResponseEntity.ok(BuscarActividadById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarActividad/{idActividad}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarActividad(@PathVariable long idActividad){
        this.servicio.EliminarActividad(idActividad);
        return ResponseEntity.ok().build();
    }
    }


