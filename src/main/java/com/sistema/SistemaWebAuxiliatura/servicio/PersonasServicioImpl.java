package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import com.sistema.SistemaWebAuxiliatura.repositorio.PersonasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasServicioImpl  implements PersonasServicio{
    @Autowired
    private PersonasRepositorio repositorio;

    @Override
    public List<Listadogeneralpersona> listarTodasLasPersonas(){

    return (List<Listadogeneralpersona>) this.repositorio.findAll();
    }

    public Listadogeneralpersona CrearPersona(Listadogeneralpersona listadogeneralpersona){
     listadogeneralpersona.setNombreApellido(listadogeneralpersona.getNombreApellido());
     listadogeneralpersona.setTelefono(listadogeneralpersona.getTelefono());
     listadogeneralpersona.setSector(listadogeneralpersona.getSector());
     listadogeneralpersona.setIdUsuarioRegistro(listadogeneralpersona.getIdUsuarioRegistro());
     listadogeneralpersona.setFechaRegistrado(listadogeneralpersona.getFechaRegistrado());
     listadogeneralpersona.setDpi(listadogeneralpersona.getDpi());
        return this.repositorio.save(listadogeneralpersona);
    }

    public Listadogeneralpersona ModificarPersona(Listadogeneralpersona listadogeneralpersona) {

       /* Listadogeneralpersona personaExiste = this.repositorio.findById(listadogeneralpersona.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        personaExiste.setNombreApellido(listadogeneralpersona.getNombreApellido());
        personaExiste.setTelefono(listadogeneralpersona.getTelefono());
        personaExiste.setSector(listadogeneralpersona.getSector());
        personaExiste.setDpi(listadogeneralpersona.getDpi());*/

        return repositorio.save(listadogeneralpersona);
    }

    public Listadogeneralpersona BuscarPersona(long idPersona){
        return this.repositorio.findById(idPersona).get();
    }

    @Override
    public  void EliminarPersona(long idPersona){
        this.repositorio.deleteById(idPersona);
    }

}
