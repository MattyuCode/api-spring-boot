package com.sistema.SistemaWebAuxiliatura.controlador;


import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadasistencia;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import com.sistema.SistemaWebAuxiliatura.servicio.ActividadAsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/CRUDACTIVIDADASISTENCIA")
public class ActividadAsistenciaControlador {
    @Autowired
    private ActividadAsistenciaServicio actividadAsistenciaServicio;

    @GetMapping
    @RequestMapping(value ="ConsultarActividad", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarActividad(){
        List<Actividadasistencia> listarActividad = this.actividadAsistenciaServicio.listarTodasLasActividades();
        return ResponseEntity.ok(listarActividad);
    }


    @PostMapping
    @RequestMapping(value = "CrearActividad", method = RequestMethod.POST)
    public ResponseEntity<?> CrearActividad(@RequestBody Actividadasistencia actividaAsistencia){
        Actividadasistencia ActividadCreada = this.actividadAsistenciaServicio.CrearAsistencia(actividaAsistencia);
        return  ResponseEntity.status(HttpStatus.CREATED).body(ActividadCreada);
    }


    @PutMapping
    @RequestMapping(value = "ModificarActividad", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarActividad(@RequestBody Actividadasistencia actividadasistencia){
        Actividadasistencia EditarActividad = this.actividadAsistenciaServicio.ModificarActividad(actividadasistencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(EditarActividad);
    }

    @GetMapping
    @RequestMapping(value = "BuscarActividad/{idActividadAsistencia}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarActividad(@PathVariable long idActividadAsistencia){
        Actividadasistencia BuscarActividadById = this.actividadAsistenciaServicio.BuscarActividad( idActividadAsistencia);
        return ResponseEntity.ok(BuscarActividadById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarActividad/{idActividadAsistencia}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarActividad(@PathVariable long idActividadAsistencia){
        this.actividadAsistenciaServicio.EliminarActividad(idActividadAsistencia);
        return ResponseEntity.ok().build();
    }


}
