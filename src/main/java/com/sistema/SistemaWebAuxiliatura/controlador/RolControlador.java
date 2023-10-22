package com.sistema.SistemaWebAuxiliatura.controlador;

import com.sistema.SistemaWebAuxiliatura.servicio.RolServicioImpl;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> ConsultarRol() {
        List<Rol> listarRol = this.rolServicioImpl.listarTodosLosRol();
        return ResponseEntity.ok(listarRol);
    }

    @PostMapping
    @RequestMapping(value = "CrearRol", method = RequestMethod.POST)
    public ResponseEntity<?> CrearRol(@RequestBody Rol rol) {
        Rol RolCreada = this.rolServicioImpl.CrearRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(RolCreada);
    }


    @PutMapping
    @RequestMapping(value = "ModificarRol/{idRol}", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarRol(@PathVariable Long idRol, @RequestBody Rol rol) {
        Rol updateRol = rolServicioImpl.ModificarRol(idRol, rol);
        if (updateRol != null) {
            return new ResponseEntity<>(updateRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping(value = "BuscarRol/{idRol}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarRol(@PathVariable long idRol) {
        Rol BuscarRolById = this.rolServicioImpl.BuscarRol(idRol);
        return ResponseEntity.ok(BuscarRolById);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarRol/{idRol}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarRol(@PathVariable long idRol) {
        this.rolServicioImpl.EliminarRol(idRol);
        Map<String, String> response = new HashMap<>();
        String message = "Rol eliminado Exitosamente en la Base de datos.";
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
}
