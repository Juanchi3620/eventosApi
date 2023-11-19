package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.entity.Organizer;
import com.evento.eventosApi.service.OrganizerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/organizadores")
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;

    @GetMapping()
    public List<Organizer> findAllOrganizers(Model model){
        log.info("Estoy en el controlador de organizadores");
        return organizerService.findAllOrganizers();
    }
    @GetMapping("/{id}")
    public Optional<Organizer> encontrarOrganizador(@PathVariable Long id){
        return organizerService.findById(id);
    }

    @PostMapping("/guardar")
    public Organizer guardarOrganizador(@RequestBody Organizer organizador){
        return organizerService.saveOrganizer(organizador);
    }

    @PutMapping("/actualizar/{id}")
    public Organizer actualizarOrganizador(@PathVariable Long id, @RequestBody Organizer organizador){
        return organizerService.updateOrganizer(id, organizador);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarOrganizador(@PathVariable Long id){
        organizerService.deleteOrganizer(id);
        return "El organizador se ha borrado con éxito";
    }


}
