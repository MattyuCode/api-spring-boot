package com.sistema.SistemaWebAuxiliatura.servicio;

import java.util.List;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Rol;
import com.sistema.SistemaWebAuxiliatura.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolServicioImpl implements RolServicio {
    @Autowired
    private RolRepositorio repositorio;


    @Override
    public List<Rol> listarTodosLosRol() {
        return (List<Rol>) this.repositorio.findAll();

    }


    @Override
    public Rol CrearRol(Rol rol) {
        rol.setNombreRol(rol.getNombreRol());
        return this.repositorio.save(rol);
    }

    @Override
    public Rol ModificarRol(Long idRol, Rol rol) {
        Rol udateRol = repositorio.findById(idRol).orElse(null);
        if (udateRol != null){
            udateRol.setNombreRol(rol.getNombreRol());
            return repositorio.save(udateRol);
        }
        //return this.repositorio.save(rol);
        return  null;
    }


    public Rol BuscarRol(long idRol) {
        return this.repositorio.findById(idRol).get();
    }

    @Override
    public void EliminarRol(long idRol) {
        this.repositorio.deleteById(idRol);
    }


}
