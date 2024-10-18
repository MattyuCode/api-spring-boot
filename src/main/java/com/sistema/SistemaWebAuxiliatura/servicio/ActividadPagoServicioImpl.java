package com.sistema.SistemaWebAuxiliatura.servicio;


import com.sistema.SistemaWebAuxiliatura.DTO.ActividadSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.ActividadPagoRepositorio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActividadPagoServicioImpl implements ActividadPagoServicio {
    @Autowired
    private ActividadPagoRepositorio actividadPagoRepositorio;
    public Actividadpago obtenerActividadPorId(Long actividadId) {
        return actividadPagoRepositorio.findById(actividadId)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    @Override
    public List<Actividadpago> listarTodosLasActividades() {
        return (List<Actividadpago>) actividadPagoRepositorio.findAll();
    }

    public Actividadpago CrearActividad(Actividadpago actividadpago) {
        actividadpago.setNombreActividad(actividadpago.getNombreActividad());
        actividadpago.setIdUsuario(actividadpago.getIdUsuario());
        return this.actividadPagoRepositorio.save(actividadpago);
    }

    public Actividadpago ModificarActividad(Actividadpago actividadpago) {
        return this.actividadPagoRepositorio.save(actividadpago);
    }

    public Actividadpago BuscarActividad(long idActividadPago) {
        return this.actividadPagoRepositorio.findById(idActividadPago).get();
    }


    @Override
    public void EliminarActividad(long idActividadPago) {

        this.actividadPagoRepositorio.deleteById(idActividadPago);
    }
}