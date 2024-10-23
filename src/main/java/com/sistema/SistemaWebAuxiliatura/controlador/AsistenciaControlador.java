package com.sistema.SistemaWebAuxiliatura.controlador;


import com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadasistencia;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;
import com.sistema.SistemaWebAuxiliatura.servicio.AsistenciaServicio;
import com.sistema.SistemaWebAuxiliatura.servicio.AsistenciaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/api/CRUDASISTENCIA")
public class AsistenciaControlador {
    @Autowired
    private AsistenciaServicioImpl asistenciaServicioIMPL;


   @GetMapping
   @RequestMapping(value = "GetAllAsisencia", method = RequestMethod.GET)
   public ResponseEntity<?> GetAllAsisencia(){
       List<Asistencia> listaAsistencia = this.asistenciaServicioIMPL.obtenerTodasLasAsistencias();
       Map<String, List<Asistencia>> response = new HashMap<>();
       response.put("Result", listaAsistencia);
       return  ResponseEntity.ok(response);
   }

   @PostMapping
   @RequestMapping(value = "CrearAsistencia", method = RequestMethod.POST)
   public ResponseEntity<?> crearAsistencia(@RequestBody  Map<String, Object>  newAsistencia){
       Asistencia newLista = this.asistenciaServicioIMPL.crearAsistencia(newAsistencia);
       return ResponseEntity.status(HttpStatus.CREATED).body(newLista);
   }


    @GetMapping
    @RequestMapping(value ="/pendientes/{idPersona}", method =  RequestMethod.GET)
    public ResponseEntity<?> pendientes(@PathVariable Long idPersona) {
        List<AsistenciaPendienteDTO> result = asistenciaServicioIMPL.obtenerAsistenciasPendientes(idPersona);
        Map<String, List<AsistenciaPendienteDTO>> response = new HashMap<>();
        response.put("Result", result);
      return  ResponseEntity.ok(response);
    }

    @GetMapping("/ConsultarAsistencia")
    public ResponseEntity<?> ConsultarAsistencia() {
        List<Asistencia> listarAsistencia = asistenciaServicioIMPL.obtenerTodasLasAsistencias();
       /* if (listarAsistencia.isEmpty()) {
            String message = "No se encontraron asistencias en la base de datos.";
            Map<String, String> response = new HashMap<>();
            response.put("message", message);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
       } else {*/
        return ResponseEntity.ok(listarAsistencia);
        //}
    }


    @GetMapping
    @RequestMapping(value = "buscarporIdPersona/{id_persona}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorIdPersona(@PathVariable long id_persona) {
        List<Asistencia> listaPersona = (List<Asistencia>) this.asistenciaServicioIMPL.findByidPersona(id_persona);
        return ResponseEntity.ok(listaPersona);
    }


    @GetMapping
    @RequestMapping(value = "EliminarAsistencia/{idAsistencia}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarAsistencia(@PathVariable long idAsistencia) {
        this.asistenciaServicioIMPL.EliminarAsistencia(idAsistencia);
        return ResponseEntity.ok().build();
    }

}
