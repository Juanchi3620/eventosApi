package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping()
    public List<Admin> findAllEvents(Model model){
        log.info("Estoy en el controlador");
        return adminService.verAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> findById(@PathVariable Long id){
        return adminService.findById(id);
    }

    @PostMapping("/guardar")
    public Admin saveAdmin(@RequestBody Admin admin){
        return adminService.guardarAdmin(admin);
    }

    @PutMapping("/actualizar/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin){
        return adminService.actualizarAdmin(id, admin);
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return "Successfully deleted";
    }
}
