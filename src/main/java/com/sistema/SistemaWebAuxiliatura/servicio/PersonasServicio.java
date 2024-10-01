package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonasServicio {
    public List<Listadogeneralpersona> listarTodasLasPersonas();
    Listadogeneralpersona CrearPersona(Listadogeneralpersona listadogeneralpersona);
    Listadogeneralpersona ModificarPersona(Listadogeneralpersona listadogeneralpersona);
    Listadogeneralpersona BuscarPersona(long idPersona);
    void EliminarPersona(long idPersona);
}
