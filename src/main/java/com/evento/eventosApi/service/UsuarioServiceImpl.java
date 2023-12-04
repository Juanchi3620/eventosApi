package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.DTO.UsuarioDTO;
import com.evento.eventosApi.entity.Rol;
import com.evento.eventosApi.entity.Usuario;
import com.evento.eventosApi.repository.RolRepository;
import com.evento.eventosApi.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> verUsuario() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Usuario guardarUsuario(UsuarioDTO usuarioDTO) {
        log.info(usuarioDTO.getRolDTO().getNombre());
        Rol rol=rolRepository.findByNombre(usuarioDTO.getRolDTO().getNombre());
        Usuario usuario = new Usuario(usuarioDTO.getCorreo(), usuarioDTO.getContrasena(), rol);
        log.info(usuario.toString());
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usu = usuarioRepository.findById(id).get();

        if(Objects.nonNull(usuario.getCorreo()) && !"".equalsIgnoreCase(usuario.getCorreo())){usu.setCorreo(usuario.getCorreo());
        }
        if(Objects.nonNull(usuario.getContrasena()) && !"".equalsIgnoreCase(usuario.getContrasena())){usu.setContrasena(usuario.getContrasena());
        }

        return usuarioRepository.save(usu);
    }

    @Transactional
    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario validarCredenciales(String email, String contrasena) {
        Usuario usuario = usuarioRepository.findByCorreo(email);

        return usuario != null && usuario.getContrasena().equals(contrasena) ? usuario : null;
    }
}
