package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Pago;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import java.util.List;
public interface UsuarioServicio{



    List<Usuario> listarTodosLosUsuarios();

    List<Usuario> findBynombreUsuarioAndContrasenia(String nombreUsuario, String contrasenia);

    Usuario CrearUsuario(Usuario usuario);
    Usuario ModificarUsuario(Usuario usuario);

    Usuario BuscarUsuario (long idUsuario);

    void EliminarUsuario(long idUsuario);
}
