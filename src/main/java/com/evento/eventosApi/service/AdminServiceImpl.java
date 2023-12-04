package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.DTO.AdminDTO;
import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.entity.Usuario;
import com.evento.eventosApi.repository.AdminRepository;
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
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Admin> verAdmins() {
        return adminRepository.findAll();
    }

    @Transactional
    @Override
    public Admin guardarAdmin(AdminDTO adminDTO) {
        log.info(adminDTO.getUsuarioDTO().getCorreo());
        Usuario usuario= usuarioRepository.findByCorreo(adminDTO.getUsuarioDTO().getCorreo());
        Admin admin = new Admin(adminDTO.getNombre(), adminDTO.getApellido(), usuario);
        return adminRepository.save(admin);
    }

    @Transactional
    @Override
    public Admin actualizarAdmin(Long id, Admin admin) {
        Admin ad = adminRepository.findById(id).get();
        if(Objects.nonNull(admin.getNombre()) && !"".equalsIgnoreCase(admin.getNombre())){
            ad.setNombre(admin.getNombre());
        }
        if(Objects.nonNull(admin.getApellido()) && !"".equalsIgnoreCase(admin.getApellido())){
            ad.setApellido(admin.getApellido());
        }
        return adminRepository.save(ad);
    }

    @Transactional
    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }
}
