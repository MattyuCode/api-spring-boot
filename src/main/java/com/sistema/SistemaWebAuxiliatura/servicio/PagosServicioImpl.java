package com.sistema.SistemaWebAuxiliatura.servicio;


import com.sistema.SistemaWebAuxiliatura.DTO.PagoPendienteDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.ActividadPagoRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonasRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;

import com.sistema.SistemaWebAuxiliatura.repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PagosServicioImpl implements PagosServicio {
    @Autowired
    private PagoRepositorio pagoRepositorio;

    @Autowired
    PersonasRepositorio personaRepo;
    @Autowired
    private ActividadPagoRepositorio actividadPagoRepositorio;

    @Override
    public List<PagoPendienteDTO> obtenerPagosPendientes(Long idPersona) {
        return pagoRepositorio.findPagosPendientesPorPersona(idPersona);
    }


    @Override
    public List<Pago> listarTodosLosPagos() {
        return (List<Pago>) pagoRepositorio.findAll();

    }


    @Override
    public Pago CrearPago(Map<String, Object> pagoData) {
        Pago newPago = new Pago();

        Long idPersona = Long.valueOf(pagoData.get("idPersona").toString());
        Listadogeneralpersona persona = personaRepo.findById(idPersona).orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Long idTipoPago = Long.valueOf(pagoData.get("idTipoPago").toString());
        Actividadpago actividadpago = actividadPagoRepositorio.findById(idTipoPago).orElseThrow(() -> new RuntimeException("Id tipo pago no encontrado"));

        newPago.setIdPersona(persona);
        newPago.setIdTipoPago(actividadpago);
        newPago.setDescripcion(pagoData.get("descripcion").toString());
        newPago.setIdUsuarioRegistro(Long.valueOf(pagoData.get("idUsuarioRegistro").toString()));
        newPago.setIdUsuarioModifica(Long.valueOf(pagoData.get("idUsuarioModifica").toString()));

        return pagoRepositorio.save(newPago);


        /*pago.setIdPersona(pago.getIdPersona());
        pago.setCantidad_Q(pago.getCantidad_Q());
        pago.setIdTipoPago(pago.getIdTipoPago());
        pago.setDescripcion(pago.getDescripcion());
        pago.setIdUsuarioRegistro(pago.getIdUsuarioRegistro());
        pago.setFechaRegistro(pago.getFechaRegistro());
        pago.setIdUsuarioModifica(pago.getIdUsuarioModifica());
        pago.setFechaModificado(pago.getFechaModificado());
        return this.pagoRepositorio.save(pago);*/
    }

    @Override
    public Pago ModificarPago(Map<String, Object> pagoData) {
        Long idPago = Long.valueOf(pagoData.get("idPago").toString());
        Pago pagoExistente = pagoRepositorio.findById(idPago)
                .orElseThrow(() -> new RuntimeException("Pago no encontrada"));

        Long idPersona = Long.valueOf(pagoData.get("idPersona").toString());
        Listadogeneralpersona persona = personaRepo.findById(idPersona)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Long idTipoPago = Long.valueOf(pagoData.get("idTipoPago").toString());
        Actividadpago actividadpago = actividadPagoRepositorio.findById(idTipoPago)
                .orElseThrow(() -> new RuntimeException("Tipo de pago no encontrado"));

        pagoExistente.setIdPersona(persona);
        pagoExistente.setIdTipoPago(actividadpago);
        pagoExistente.setDescripcion(pagoData.get("descripcion").toString());
        pagoExistente.setIdUsuarioRegistro(Long.valueOf(pagoData.get("idUsuarioRegistro").toString()));
        pagoExistente.setIdUsuarioModifica(Long.valueOf(pagoData.get("idUsuarioModifica").toString()));

        pagoExistente.setFechaModificado(LocalDateTime.now());

        return this.pagoRepositorio.save(pagoExistente);
    }
// que sigue? va
    @Override
    public Pago BuscarPago(long idPago) {
        return this.pagoRepositorio.findById(idPago).get();
    }


    @Override
    public void EliminarPago(long idPago) {
        this.pagoRepositorio.deleteById(idPago);
    }

    @Override
    public List<Pago> findByidPersona(long idPersona) {
        return pagoRepositorio.findByidPersona_IdPersona(idPersona);
    }

    // @Override
    /*public List<Pago> findByidPersona(long idPersona) {
        return null;
    }*/


    @Override
    public List<Pago> findByidPersona(Long idPersona) {
        return pagoRepositorio.findByidPersona_IdPersona(idPersona);
    }
}
