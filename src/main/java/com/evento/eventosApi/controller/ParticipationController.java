package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Organizer;
import com.evento.eventosApi.entity.Participation;
import com.evento.eventosApi.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participaciones")
public class ParticipationController {
    @Autowired
    ParticipationService participationService;

    @GetMapping()
    public List<Participation> verParticipaciones(){
        return participationService.verParticipacion();
    }

    @GetMapping("/{id}")
    public Optional<Participation> buscarId(@PathVariable Long id){
        return participationService.findById(id);
    }

    @PostMapping("/guardar")
    public Participation guardarParticipacion(@RequestBody Participation participation){
        return participationService.guardarParticipacion(participation);
    }

    @PutMapping("/actualizar/{id}")
    public Participation actualizarParticipacion(@PathVariable Long id, @RequestBody Participation participation){
        return participationService.actualizarParticipacion(id, participation);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarParticipacion(@PathVariable Long id){
        participationService.deleteParticipacion(id);
        return "La participación se ha borrado con éxito";
    }

}
