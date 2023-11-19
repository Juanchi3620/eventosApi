package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/eventos")
@Slf4j
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping()
    public List<Evento> findAllEvents(Model model){
        log.info("Estoy en el controlador");
        return eventService.findAllEventos();
    }

    @GetMapping("/{name}")
    public Optional<Evento> findByName(@PathVariable String name){
        log.info("si entré");
        log.info(eventService.findByname(name).toString());
        return eventService.findByname(name);
    }

    @GetMapping("/evento/{id}")
    public Optional<Evento> findById(@PathVariable Long id){
        return eventService.findById(id);
    }

    @PostMapping("/guardar")
    public Evento saveEvent(@RequestBody Evento evento){
        return eventService.saveEvent(evento);
    }

    @PutMapping("/actualizar/{id}")
    public Evento updateLocal(@PathVariable Long id, @RequestBody Evento evento){
        return eventService.updateEvent(id, evento);
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteLocal(@PathVariable Long id){
        eventService.deleteEvent(id);
        return "Successfully deleted";
    }

}
