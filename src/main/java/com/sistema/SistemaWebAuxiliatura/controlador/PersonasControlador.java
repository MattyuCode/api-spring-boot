package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.repositorio.PersonasRepositorio;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import com.sistema.SistemaWebAuxiliatura.servicio.PersonaServicioImpl;
import com.sistema.SistemaWebAuxiliatura.servicio.PersonasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/CRUDPERSONAS")
public class PersonasControlador {

    //@Qualifier("personaServicioImpl")
    @Autowired
    //private PersonasServicio servicio;
    private PersonaServicioImpl personaIMPL;


    @GetMapping
    @RequestMapping(value = "ConsultarPersonas", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarPersonas() {
        List<Listadogeneralpersona> listarPersona = this.personaIMPL.listarTodasLasPersonas();
        return ResponseEntity.ok(listarPersona);
    }

    @PostMapping
    @RequestMapping(value = "CrearPersonas", method = RequestMethod.POST)
    public ResponseEntity<?> CrearPersonas(@RequestBody Listadogeneralpersona listadogeneralpersona) {
        Listadogeneralpersona PersonaCreada = this.personaIMPL.CrearPersona(listadogeneralpersona);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonaCreada);
    }

    @PutMapping
    @RequestMapping(value = "ModificarPersona", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarPersona(@RequestBody Listadogeneralpersona listadogeneralpersona) {

        Listadogeneralpersona personaExiste = this.personaIMPL.BuscarPersona(listadogeneralpersona.getIdPersona());
        if (personaExiste == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada.");
        }
        personaExiste.setNombreApellido(listadogeneralpersona.getNombreApellido());
        personaExiste.setTelefono(listadogeneralpersona.getTelefono());
        personaExiste.setSector(listadogeneralpersona.getSector());
        personaExiste.setDpi(listadogeneralpersona.getDpi());

        Listadogeneralpersona EditarPersona = this.personaIMPL.ModificarPersona(personaExiste);
        return ResponseEntity.status(HttpStatus.OK).body(EditarPersona);
    }

    @GetMapping
    @RequestMapping(value = "BuscarPersona/{idPersona}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPersona(@PathVariable long idPersona) {
        Listadogeneralpersona BuscarPersonaById = this.personaIMPL.BuscarPersona(idPersona);
        return ResponseEntity.ok(BuscarPersonaById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarPersona/{idPersona}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPersona(@PathVariable long idPersona) {
        this.personaIMPL.EliminarPersona(idPersona);
        return ResponseEntity.ok().build();
    }

}
