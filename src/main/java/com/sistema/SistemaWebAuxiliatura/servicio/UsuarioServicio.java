package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioServicio{

    List<Usuario> listarTodosLosUsuarios();

    List<Usuario> findBynombreUsuarioAndContrasenia(String nombreUsuario, String contrasenia);

    Optional<Usuario> findBynombreUsuario(String nombreUsuario);

    Usuario CrearUsuario(Usuario usuario);
    Usuario ModificarUsuario(Usuario usuario);

    Usuario BuscarUsuario (long idUsuario);

    void EliminarUsuario(long idUsuario);
}
