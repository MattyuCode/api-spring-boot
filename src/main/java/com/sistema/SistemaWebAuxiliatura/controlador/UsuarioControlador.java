package com.sistema.SistemaWebAuxiliatura.controlador;


import com.sistema.SistemaWebAuxiliatura.DTO.EstadosUsuarioDTO;
import com.sistema.SistemaWebAuxiliatura.repositorio.entidad.Usuario;

import com.sistema.SistemaWebAuxiliatura.servicio.UsuarioServicio;
import com.sistema.SistemaWebAuxiliatura.servicio.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/CRUDUSUARIO")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicioImpl usuarioServicioImpl;
    @Autowired
    private UsuarioServicio usuarioServicio;


    @GetMapping
    @RequestMapping(value = "ConsultarUsuario", method = RequestMethod.GET)
    public ResponseEntity<?> ConsultarUsuario() {
        List<Usuario> listarUsuario = this.usuarioServicio.listarTodosLosUsuarios();
        Map<String, List<Usuario>> response = new HashMap<>();
        response.put("Result", listarUsuario);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @RequestMapping(value = "CrearUsuario", method = RequestMethod.POST)
    public ResponseEntity<?> CrearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = this.usuarioServicio.CrearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    @PutMapping
    @RequestMapping(value = "ModificarUsuario", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarUsuario(@RequestBody Usuario usuario) {
        Usuario EditaUsuario = this.usuarioServicioImpl.ModificarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(EditaUsuario);
    }

    @PutMapping
    @RequestMapping(value = "ModificarEstadoUsuario/{idUsuario}", method = RequestMethod.PUT)
    public ResponseEntity<?> ModificarEstadoUsuario(@PathVariable Long idUsuario, @RequestBody EstadosUsuarioDTO estado) {
        Usuario usuario = this.usuarioServicioImpl.ModificarEstadoUsuario(idUsuario, estado.getIsActive());
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }


    @GetMapping
    @RequestMapping(value = "BuscarUsuario/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<?> BuscarUsuario(@PathVariable long idUsuario) {
        Usuario BuscarUsuarioById = this.usuarioServicio.BuscarUsuario(idUsuario);
        return ResponseEntity.ok(BuscarUsuarioById);
    }

    @GetMapping("/NombreContrasenia/{usuario}/{contrasenia}")
    public ResponseEntity<?> buscarUsuarioPorNombreYContrasenia(
            @PathVariable String usuario, @PathVariable String contrasenia) {
        List<Usuario> users = usuarioServicio.findBynombreUsuarioAndContrasenia(usuario, contrasenia);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users.get(0));
        } else {

            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarUsuario/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<?> EliminarUsuario(@PathVariable long idUsuario) {
        this.usuarioServicio.EliminarUsuario(idUsuario);
        return ResponseEntity.ok().build();
    }


}

