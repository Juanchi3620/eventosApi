package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.DTO.AdminDTO;
import com.evento.eventosApi.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> verAdmins();
    Admin guardarAdmin(AdminDTO adminDTO);
    Admin actualizarAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
    Optional<Admin> findById(Long id);
}
