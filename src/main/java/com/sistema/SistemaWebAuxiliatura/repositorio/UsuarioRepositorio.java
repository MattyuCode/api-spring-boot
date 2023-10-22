package com.sistema.SistemaWebAuxiliatura.repositorio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

   Usuario findBynombreUsuario(String username);
   List<Usuario> findBynombreUsuarioAndContrasenia(String nombreUsuario, String contrasenia);
}
