package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.DTO.RolDTO;
import com.evento.eventosApi.entity.Rol;
import com.evento.eventosApi.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    RolRepository rolRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Rol> verRoles() {
        return rolRepository.findAll();
    }

    @Transactional
    @Override
    public Rol guardarRol(RolDTO rolDTO) {
        Rol rol = new Rol(rolDTO.getNombre());

        return rolRepository.save(rol);
    }

    @Transactional
    @Override
    public Rol actualizarRol(Long id, Rol rol) {
        Rol rl = rolRepository.findById(id).get();

        if (Objects.nonNull(rol.getNombre()) && !"".equalsIgnoreCase(rol.getNombre())) {
            rl.setNombre(rol.getNombre());
        }

        return rolRepository.save(rl);
    }

    @Transactional
    @Override
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}
