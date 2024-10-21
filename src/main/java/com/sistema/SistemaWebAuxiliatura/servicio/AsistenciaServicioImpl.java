package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.AsistenciaPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.DTO.PersonaSinAsistenciaDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.ActividadAsistenciaRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.AsistenciaRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonasRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadasistencia;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AsistenciaServicioImpl implements AsistenciaServicio {
    @Autowired
    private AsistenciaRepositorio asistenciaRepositorio;

    @Autowired
    private PersonasRepositorio personsaRepo;

    @Autowired
    private ActividadAsistenciaRepositorio actividadAsistenciaRepositorio;

    @Override
    public List<AsistenciaPendienteDTO> obtenerAsistenciasPendientes(Long idPersona) {
        return asistenciaRepositorio.findAsistenciasPendientes(idPersona);
    }
    @Autowired
    public void AsistenciaServicioImpl(AsistenciaRepositorio asistenciaRepositorio) {
        this.asistenciaRepositorio = asistenciaRepositorio;
    }



    @Override
    public List<Asistencia> obtenerTodasLasAsistencias() {
        return (List<Asistencia>) asistenciaRepositorio.findAll();
    }


    @Override
    public Asistencia crearAsistencia(Map<String, Object> asistenciaData) {
        Asistencia newAsistencia = new Asistencia();

        //VALIDAR PERSONA Y TIPO ASISTENCIA LA HACER EL INSERT EN ASSITENCIA
        Long idPersona = Long.valueOf(asistenciaData.get("idPersona").toString());
        Listadogeneralpersona persona = personsaRepo.findById(idPersona).orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Long tipoAsistencia = Long.valueOf(asistenciaData.get("tipoAsistencia").toString());
        Actividadasistencia actividadasistencia = actividadAsistenciaRepositorio.findById(tipoAsistencia).orElseThrow(() -> new RuntimeException("Tipo asistencia no encontrado"));

        newAsistencia.setIdPersona(persona);
        newAsistencia.setTipoAsistencia(actividadasistencia);
        newAsistencia.setDescripcion(asistenciaData.get("descripcion").toString());
        newAsistencia.setIdUsuarioRegistro(Long.valueOf(asistenciaData.get("idUsuarioRegistro").toString()));
        newAsistencia.setIdUsuarioModifica(Long.valueOf(asistenciaData.get("idUsuarioModifica").toString()));


        return asistenciaRepositorio.save(newAsistencia);

    }

    @Override
    public Asistencia ModificarAsistencia(Asistencia asistencia) {
        return this.asistenciaRepositorio.save(asistencia);
    }

    @Override
    public Asistencia BuscarAsistencia(long idAsistencia) {
        return this.asistenciaRepositorio.findById(idAsistencia).get();
    }

    @Override
    public void EliminarAsistencia(long idAsistencia) {
        this.asistenciaRepositorio.deleteById(idAsistencia);
    }


    @Override
    public List<Asistencia> findByidPersona(long idPersona) {
        return asistenciaRepositorio.findByidPersona_idPersona(idPersona);

    }

}
