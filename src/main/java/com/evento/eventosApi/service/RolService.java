package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.DTO.RolDTO;
import com.evento.eventosApi.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> verRoles();
    Rol guardarRol(RolDTO rol);
    Rol actualizarRol(Long id, Rol rol);
    void deleteRol(Long id);
    Optional<Rol> findById(Long id);

    Rol findByNombre(String nombre);
}
