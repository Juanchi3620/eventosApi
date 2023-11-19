package com.evento.eventosApi.controller;


import com.evento.eventosApi.entity.Speaker;
import com.evento.eventosApi.service.SpeakerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speakers")
@Slf4j
public class SpeakerController {
    @Autowired
    SpeakerService speakerService;

    @GetMapping()
    public List<Speaker> findAllSpeaker(Model model){
        log.info("Estoy en el controlador de Speaker");
        return speakerService.verSpeaker();
    }

    @GetMapping("/{id}")
    public Optional<Speaker> encontrarSpeaker(@PathVariable Long id){
        return speakerService.findById(id);
    }

    @PostMapping("/guardar")
    public Speaker guardarSpeaker(@RequestBody Speaker speaker){
        return speakerService.guardarSpeaker(speaker);
    }

    @PutMapping("/actualizar/{id}")
    public Speaker actualizarSpeaker(@PathVariable Long id, @RequestBody Speaker speaker){
        return speakerService.actualizarSpeaker(id, speaker);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarSpeaker(@PathVariable Long id){
        speakerService.deleteSpeaker(id);
        return "El speaker se ha borrado con éxito";
    }
}
