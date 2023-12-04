package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.DTO.UsuarioDTO;
import com.evento.eventosApi.entity.Speaker;
import com.evento.eventosApi.entity.Usuario;
import com.evento.eventosApi.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public List<Usuario> findAllUsuarios(Model model) {
        log.info("Estoy en el controlador de Usuario");
        return usuarioService.verUsuario();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> encontrarUsuario(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.guardarUsuario(usuarioDTO);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "El Usuario se ha borrado con éxito";
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario usuario) {
        String correo = usuario.getCorreo();
        String contrasena = usuario.getContrasena();
        log.info("Entre al login");

        Usuario usuario1 = usuarioService.validarCredenciales(correo, contrasena);

        if (usuario1 != null) {
            return ResponseEntity.ok(usuario1); // Retorna los datos del usuario en caso de éxito
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}