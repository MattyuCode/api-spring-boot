package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepositorio extends CrudRepository<Listadogeneralpersona, Long> {
}
