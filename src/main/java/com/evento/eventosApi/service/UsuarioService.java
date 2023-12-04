package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.DTO.UsuarioDTO;
import com.evento.eventosApi.entity.Speaker;
import com.evento.eventosApi.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> verUsuario();
    Usuario guardarUsuario(UsuarioDTO usuario);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
    Optional<Usuario> findById(Long id);

    Usuario validarCredenciales(String email, String contrasena);
}
