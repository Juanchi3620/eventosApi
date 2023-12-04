package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.DTO.RolDTO;
import com.evento.eventosApi.entity.Recurso;
import com.evento.eventosApi.entity.Rol;
import com.evento.eventosApi.service.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@Slf4j
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping()
    public List<Rol> verRoles() {
        return rolService.verRoles();
    }

    @PostMapping("/guardar")
    public Rol guardarRol(@RequestBody RolDTO rolDTO) {
        log.info("Entré a guardar el rol", rolDTO);
        return rolService.guardarRol(rolDTO);
    }

    @GetMapping("/rol/{nombre}")
    public Rol buscarNombre(@PathVariable String nombre) {
        return rolService.findByNombre(nombre);
    }

    @GetMapping("/{id}")
    public Optional<Rol> buscarId(@PathVariable Long id) {
        return rolService.findById(id);
    }


    @PutMapping("/actualizar/{id}")
    public Rol actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        return rolService.actualizarRol(id, rol);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarRol(@PathVariable Long id) {
        rolService.deleteRol(id);
        return "El rol se ha borrado con éxito";
    }

}
