package com.sistema.SistemaWebAuxiliatura.servicio;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;

import java.util.List;

public interface PersonasServicio {
    public List<Listadogeneralpersona> listarTodasLasPersonas();

    Listadogeneralpersona CrearPersona(Listadogeneralpersona listadogeneralpersona);
    Listadogeneralpersona ModificarPersona(Listadogeneralpersona listadogeneralpersona);
    Listadogeneralpersona BuscarPersona(long idPersona);
    void EliminarPersona(long idPersona);
}
