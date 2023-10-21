package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.AsistenciaRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaServicioImpl implements  AsistenciaServicio {
    @Autowired
    private AsistenciaRepositorio asistenciaRepositorio;


    @Override
    public List<Asistencia>listarTodasLasAsistencias(){
    return (List<Asistencia>) asistenciaRepositorio.findAll();
    }

    @Override
    public Asistencia CrearAsistencia(Asistencia asistencia){
        asistencia.setIdPersona(asistencia.getIdPersona());
        asistencia.setAsistencia(asistencia.getAsistencia());
        asistencia.setTipoAsistencia(asistencia.getTipoAsistencia());
        asistencia.setDescripcion(asistencia.getDescripcion());
        asistencia.setIdUsuarioRegistro(asistencia.getIdUsuarioRegistro());
        asistencia.setFechaRegistro(asistencia.getFechaRegistro());
        asistencia.setIdUsuarioModifica(asistencia.getIdUsuarioModifica());
        asistencia.setFechaModificado(asistencia.getFechaModificado());
        return this.asistenciaRepositorio.save(asistencia);

    }

    @Override
    public Asistencia ModificarAsistencia(Asistencia asistencia){return this.asistenciaRepositorio.save(asistencia);}

    @Override
    public Asistencia BuscarAsistencia(long idAsistencia){return  this.asistenciaRepositorio.findById(idAsistencia).get();}

    @Override
    public void EliminarAsistencia(long idAsistencia){ this.asistenciaRepositorio.deleteById(idAsistencia);}


   @Override
   public List<Asistencia> findByidPersona(long idPersona){
        return asistenciaRepositorio.findByidPersona(idPersona);

   }

}
