package com.sistema.SistemaWebAuxiliatura.servicio;


import com.sistema.SistemaWebAuxiliatura.repositorio.ActividadAsistenciaRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadasistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadAsistenciaServicioImpl  implements  ActividadAsistenciaServicio {

    @Autowired
    private ActividadAsistenciaRepositorio actividadAsistenciaRepositorio;

    @Override
     public List<Actividadasistencia> listarTodasLasActividades(){
        return (List<Actividadasistencia>) actividadAsistenciaRepositorio.findAll();

    }

    @Override
    public Actividadasistencia CrearAsistencia(Actividadasistencia actividadasistencia) {
        actividadasistencia.setNombreActividad(actividadasistencia.getNombreActividad());
        actividadasistencia.setIdUsuario(actividadasistencia.getIdUsuario());
        return this.actividadAsistenciaRepositorio.save(actividadasistencia);
    }

    @Override
    public Actividadasistencia ModificarActividad(Actividadasistencia actividadAsistencia) {
        return this.actividadAsistenciaRepositorio.save(actividadAsistencia);
    }

    @Override
    public Actividadasistencia BuscarActividad(long idActividadAsistencia) {
        return this.actividadAsistenciaRepositorio.findById(idActividadAsistencia).get();
    }

    @Override
    public void EliminarActividad(long idActividadAsistencia) {
        this.actividadAsistenciaRepositorio.deleteById(idActividadAsistencia);

    }


}
