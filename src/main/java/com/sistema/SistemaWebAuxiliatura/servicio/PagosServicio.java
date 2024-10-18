package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.DTO.PagoPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;

import java.util.List;

public interface PagosServicio {

    List<PagoPendienteDTO> obtenerPagosPendientes(Long idPersona);


    List<Pago>listarTodosLosPagos();



    Pago CrearPago(Pago pago);

    Pago ModificarPago(Pago pago);

    Pago BuscarPago(long idPago);

    void EliminarPago(long idPago);

    List<Pago>findByidPersona(long idPersona);

    List<Pago>findByidPersona(Long idPersona);


    //  List<Pago> buscarTodosPorIdPersona(long idPersona);
}
