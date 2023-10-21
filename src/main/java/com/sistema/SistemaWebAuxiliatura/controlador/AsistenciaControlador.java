package com.sistema.SistemaWebAuxiliatura.controlador;


import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;
import com.sistema.SistemaWebAuxiliatura.servicio.AsistenciaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("CRUDASISTENCIA")
public class AsistenciaControlador {
  private AsistenciaServicio asistenciaServicio;

  @RequestMapping(value = "ConsultarAsistencia", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarAsistencia(){
      List<Asistencia> listarAsistencia= this.asistenciaServicio.listarTodasLasAsistencias();
      return ResponseEntity.ok(listarAsistencia);


  }

 @GetMapping
 @RequestMapping(value = "buscarporIdPersona/{id_persona}", method = RequestMethod.GET)
 public ResponseEntity<?> buscarPorIdPersona(@PathVariable long id_persona){
      List<Asistencia> listaPersona = (List<Asistencia>) this.asistenciaServicio.findByidPersona(id_persona);
    return  ResponseEntity.ok(listaPersona);
 }


 @GetMapping
 @RequestMapping(value = "EliminarAsistencia/{idPago}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarAsistencia(@PathVariable long idAsistencia){
      this.asistenciaServicio.EliminarAsistencia(idAsistencia);
      return ResponseEntity.ok().build();
 }

}
