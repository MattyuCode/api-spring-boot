package com.sistema.SistemaWebAuxiliatura.servicio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Rol;
import java.util.List;
public interface RolServicio {

    static Rol ModificationRol1(long idRol, String nuevoNombre) {
        return null;
    }


    List<Rol> listarTodosLosRol();

    Rol CrearRol(Rol rol);
    Rol ModificarRol(Rol rol);
    Rol BuscarRol (long idRol);

    void EliminarRol(long idRol);
}
