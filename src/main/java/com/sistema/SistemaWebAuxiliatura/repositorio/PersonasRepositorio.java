package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonasRepositorio extends CrudRepository<Listadogeneralpersona, Long> {
    Optional<Listadogeneralpersona> findByDpi(String dpi);


}
