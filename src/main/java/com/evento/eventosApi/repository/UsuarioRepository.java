package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByCorreo(String correo);
}
