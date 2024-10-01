package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;
import com.sistema.SistemaWebAuxiliatura.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {


    @Autowired
    private UsuarioRepositorio repositorio;



    @Override
    public List<Usuario> listarTodosLosUsuarios() {
        return (List<Usuario>) this.repositorio.findAll();
    }

    @Override
    public List<Usuario> findBynombreUsuarioAndContrasenia(String nombreUsuario, String contrasenia) {
        return repositorio.findBynombreUsuarioAndContrasenia(nombreUsuario, contrasenia);
    }

    @Override
    public Optional<Usuario> findBynombreUsuario(String nombreUsuario) {
        return Optional.empty();
    }


    @Override
    public Usuario CrearUsuario(Usuario usuario) {
        /* BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();  */
       /* String encriptado = passwordEncoder.encode(usuario.getContrasenia());
        usuario.setContrasenia(encriptado);*/


        return repositorio.save(usuario);
    }

    @Override
    public Usuario ModificarUsuario(Usuario usuario) {
        Usuario usuarioExiste = this.repositorio.findById(usuario.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrada"));

        usuarioExiste.setNombreApellido(usuario.getNombreApellido());
        usuarioExiste.setNombreUsuario(usuario.getNombreUsuario());
        usuarioExiste.setIdRol(usuario.getIdRol());
        usuarioExiste.setContrasenia(usuario.getContrasenia());
        usuarioExiste.setTelefono(usuario.getTelefono());

        return this.repositorio.save(usuario);
    }


    @Override
    public Usuario ModificarEstadoUsuario(Long idUsuario, boolean isActive) {
        Usuario usuarioExiste = this.repositorio.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioExiste.setIsActive(isActive);

        return this.repositorio.save(usuarioExiste);
    }


    public Usuario BuscarUsuario(long idUsuario) {

        return this.repositorio.findById(idUsuario).get();
    }

    @Override
    public void EliminarUsuario(long idUsuario) {
        this.repositorio.deleteById(idUsuario);
    }


}
