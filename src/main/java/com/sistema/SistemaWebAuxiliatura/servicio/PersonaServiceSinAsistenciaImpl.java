package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonaSinAsisteciaRepository;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonaSinPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceSinAsistenciaImpl {
    @Autowired
    private PersonaSinAsisteciaRepository personaSinAsisteciaRepository;

    public List<PersonaSinAsistenciaDTO> obtenerPersonaSinAsistencia(Long tipoAsistencia){
        return personaSinAsisteciaRepository.findPersonaSinAsistencia(tipoAsistencia);

    }

}
