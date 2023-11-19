package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> verAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin guardarAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin actualizarAdmin(Long id, Admin admin) {
        Admin ad = adminRepository.findById(id).get();
        if(Objects.nonNull(admin.getName()) && !"".equalsIgnoreCase(admin.getName().toString())){
            ad.setName(admin.getName());
        }
        if(Objects.nonNull(admin.getLastName()) && !"".equalsIgnoreCase(admin.getLastName().toString())){
            ad.setLastName(admin.getLastName());
        }
        if(Objects.nonNull(admin.getRole()) && !"".equalsIgnoreCase(admin.getRole().toString())){
            ad.setName(admin.getRole());
        }
        if(Objects.nonNull(admin.getPermissions()) && !"".equalsIgnoreCase(admin.getPermissions().toString())){
            ad.setName(admin.getPermissions());
        }
        return adminRepository.save(ad);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }
}
