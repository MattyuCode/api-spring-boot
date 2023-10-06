package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Listadogeneralpersona;
import com.sistema.SistemaWebAuxiliatura.servicio.PersonasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("CRUDPERSONAS")
public class PersonasControlador {
@Autowired
    private PersonasServicio  servicio;

@GetMapping
    @RequestMapping(value = "ConsultarPersonas", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarPersonas(){
    List<Listadogeneralpersona> listarPersona= this.servicio.listarTodasLasPersonas();
    return  ResponseEntity.ok(listarPersona);
}

@PostMapping
    @RequestMapping(value = "CrearPersonas", method = RequestMethod.POST)
    public ResponseEntity<?> CrearPersonas(@RequestBody Listadogeneralpersona listadogeneralpersona){
    Listadogeneralpersona PersonaCreada = this.servicio.CrearPersona(listadogeneralpersona);
    return  ResponseEntity.status(HttpStatus.CREATED).body(PersonaCreada);
}

@PutMapping
    @RequestMapping(value = "ModificarPersona", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarPersona(@RequestBody Listadogeneralpersona listadogeneralpersona){
    Listadogeneralpersona EditarPersona = this.servicio.ModificarPersona(listadogeneralpersona);
    return ResponseEntity.status(HttpStatus.CREATED).body(EditarPersona);
}

    @GetMapping
    @RequestMapping(value = "BuscarPersona/{idPersona}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarPersona(@PathVariable long idPersona){
        Listadogeneralpersona BuscarPersonaById = this.servicio.BuscarPersona(idPersona);
        return ResponseEntity.ok(BuscarPersonaById);
    }
    @DeleteMapping
    @RequestMapping(value = "EliminarPersona/{idPersona}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarPersona(@PathVariable long idPersona){
        this.servicio.EliminarPersona(idPersona);
        return ResponseEntity.ok().build();
    }

}
