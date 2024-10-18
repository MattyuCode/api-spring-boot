package com.sistema.SistemaWebAuxiliatura.controlador;


import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonaSinAsisteciaRepository;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;
import com.sistema.SistemaWebAuxiliatura.servicio.PersonaServiceSinAsistenciaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/SINASISTENCIA")
public class PersonaSinAsistenciaController {
    @Autowired
    private PersonaServiceSinAsistenciaImpl personaServiceSinAsistencia;
    @GetMapping ("/personaSinAsistencia/{tipoAsistencia}")
    public ResponseEntity<List<PersonaSinAsistenciaDTO>> obternerPersonaSinAsistenciaPendiente(@PathVariable Long tipoAsistencia) {
        List<PersonaSinAsistenciaDTO> personaSinAsistenciaDTOS = personaServiceSinAsistencia.obtenerPersonaSinAsistencia(tipoAsistencia);
        return ResponseEntity.ok(personaSinAsistenciaDTOS);
    }

}
