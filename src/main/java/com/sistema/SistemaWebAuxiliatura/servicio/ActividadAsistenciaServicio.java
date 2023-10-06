package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadasistencia;

import java.util.List;

public interface ActividadAsistenciaServicio  {
    public List<Actividadasistencia> listarTodasLasActividades();

    Actividadasistencia CrearAsistencia(Actividadasistencia actividadasistencia);
    Actividadasistencia ModificarActividad(Actividadasistencia actividadAsistencia);


    Actividadasistencia BuscarActividad(long idActividadAsistencia);


    void EliminarActividad(long idActividadAsistencia);

}
