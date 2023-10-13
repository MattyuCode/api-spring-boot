package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.servicio.RolServicioImpl;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/CRUD")
public class RolControlador {
    @Autowired
    private RolServicioImpl rolServicioImpl;
  //  @GetMapping({"/rol","/"})
    //public String listarRol(Model modelo){
       // modelo.addAttribute("rol", servicio.listarTodosLosRol());
        //return "rol";//nos retorna al archivo de rol
    //}
@GetMapping
@RequestMapping(value = "ConsultarRol", method = RequestMethod.GET)
  public ResponseEntity<?> ConsultarRol(){
    List<Rol> listarRol= this.rolServicioImpl.listarTodosLosRol();
    return ResponseEntity.ok(listarRol);
}

@PostMapping
    @RequestMapping(value ="CrearRol", method =  RequestMethod.POST)
    public ResponseEntity<?> CrearRol(@RequestBody Rol rol){
    Rol RolCreada = this.rolServicioImpl.CrearRol(rol);
    return ResponseEntity.status(HttpStatus.CREATED).body(RolCreada);
}

@PutMapping
    @RequestMapping(value = "ModificarRol", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarRol(@RequestBody Rol rol){
    Rol EditaRol = this.rolServicioImpl.ModificarRol(rol);
    return ResponseEntity.status(HttpStatus.CREATED).body(EditaRol);
}

@GetMapping
    @RequestMapping(value = "BuscarRol/{idRol}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarRol(@PathVariable long idRol){
    Rol BuscarRolById = this.rolServicioImpl.BuscarRol(idRol);
    return ResponseEntity.ok(BuscarRolById);
}

@DeleteMapping
    @RequestMapping(value = "EliminarRol/{idRol}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarRol(@PathVariable long idRol){
    this.rolServicioImpl.EliminarRol(idRol);
    return ResponseEntity.ok().build();
}
}
