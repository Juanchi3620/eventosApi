package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    public Rol findByNombre(String nombre);
}
