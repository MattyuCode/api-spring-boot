package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.DTO.ActividadSinPagoDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Actividadpago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadPagoRepositorio extends JpaRepository<Actividadpago, Long> {



}
