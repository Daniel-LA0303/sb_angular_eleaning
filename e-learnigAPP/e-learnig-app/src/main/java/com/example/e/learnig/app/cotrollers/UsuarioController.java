package com.example.e.learnig.app.cotrollers;

import com.example.e.learnig.app.entities.Rol;
import com.example.e.learnig.app.entities.Usuario;
import com.example.e.learnig.app.entities.UsuarioRol;
import com.example.e.learnig.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario saveUser(@RequestBody Usuario usuario) throws Exception{

        Set<UsuarioRol> roles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setName("USER");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        roles.add(usuarioRol);

        //usuario.setUsuarioRol(roles);

        return usuarioService.save(usuario, roles);

    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        try {
            Usuario usuario = usuarioService.getUser(username);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            // Manejar la excepción aquí
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el usuario.");
        }
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        usuarioService.deleteUser(id);
    }

}
