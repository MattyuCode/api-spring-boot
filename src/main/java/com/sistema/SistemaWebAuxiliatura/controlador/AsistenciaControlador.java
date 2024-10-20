package com.sistema.SistemaWebAuxiliatura.controlador;


import com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadasistencia;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;
import com.sistema.SistemaWebAuxiliatura.servicio.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/CRUDASISTENCIA")
public class AsistenciaControlador {
    @Autowired
    private AsistenciaServicio asistenciaServicio;


    @Autowired
    public AsistenciaControlador(AsistenciaServicio asistenciaService) {
        this.asistenciaServicio = asistenciaService;
    }
   /* @GetMapping("/pendientes/{idPersona}")
    public ResponseEntity<List<PersonaSinAsistenciaDTO>> obtenerAsistenciasPendientes(@PathVariable Long idPersona){
        List<PersonaSinAsistenciaDTO> asistenciasPendientes = asistenciaServicio.obtenerAsistenciaPendiente(idPersona);
        if (asistenciasPendientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(asistenciasPendientes);
    }*/


    @GetMapping
    @RequestMapping(value ="/pendientes/{idPersona}", method =  RequestMethod.GET)
    public ResponseEntity<?> pendientes(@PathVariable Long idPersona) {
        List<AsistenciaPendienteDTO> result = asistenciaServicio.obtenerAsistenciasPendientes(idPersona);
        Map<String, List<AsistenciaPendienteDTO>> response = new HashMap<>();
        response.put("Result", result);
      return  ResponseEntity.ok(response);
    }

    @GetMapping("/ConsultarAsistencia")
    public ResponseEntity<?> ConsultarAsistencia() {
        List<Asistencia> listarAsistencia = asistenciaServicio.obtenerTodasLasAsistencias();
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
        List<Asistencia> listaPersona = (List<Asistencia>) this.asistenciaServicio.findByidPersona(id_persona);
        return ResponseEntity.ok(listaPersona);
    }


    @GetMapping
    @RequestMapping(value = "EliminarAsistencia/{idPago}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarAsistencia(@PathVariable long idAsistencia) {
        this.asistenciaServicio.EliminarAsistencia(idAsistencia);
        return ResponseEntity.ok().build();
    }

}
