package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;

import java.util.List;

public interface ActividadPagoServicio{

    public List<Actividadpago> listarTodosLasActividades();

    Actividadpago CrearActividad(Actividadpago actividadpago);
    Actividadpago ModificarActividad(Actividadpago actividadpago);

    Actividadpago BuscarActividad(long idActividad);
    void EliminarActividad(long idActividad);


}
