package com.sistema.SistemaWebAuxiliatura.servicio;



import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;

import com.sistema.SistemaWebAuxiliatura.repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PagosServicioImpl implements PagosServicio{
    @Autowired
    private PagoRepositorio pagoRepositorio;

@Override
    public List<Pago>listarTodosLosPagos(){
    return (List<Pago>) pagoRepositorio.findAll();

}

@Override
public Pago CrearPago(Pago pago){
    pago.setIdPersona(pago.getIdPersona());
    pago.setCantidad(pago.getCantidad_Q());
    pago.setIdTipoPago(pago.getIdTipoPago());
    pago.setDescripcion(pago.getDescripcion());
    pago.setIdUsuarioRegistro(pago.getIdUsuarioRegistro());
    pago.setFechaRegistro(pago.getFechaRegistro());
    pago.setIdUsuarioModifica(pago.getIdUsuarioModifica());
    pago.setFechaModificado(pago.getFechaModificado());
    return this.pagoRepositorio.save(pago);
}
@Override
public Pago ModificarPago(Pago pago){
    return this.pagoRepositorio.save(pago);
}

@Override
public  Pago BuscarPago(long idPago){
    return this.pagoRepositorio.findById(idPago).get();
}



@Override
    public void EliminarPago(long idPago){
    this.pagoRepositorio.deleteById(idPago);
}




@Override
    public List<Pago>findByidPersona(long idPersona) {
    return pagoRepositorio.findByidPersona(idPersona);
    }
}
