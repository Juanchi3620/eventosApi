package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Assistant;
import com.evento.eventosApi.service.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asistentes")
public class AssistantController {
    @Autowired
    AssistantService assistantService;

    @GetMapping()
    public List<Assistant> verAsistentes(){
        return assistantService.verAsistentes();
    }

    @GetMapping("/{id}")
    public Optional<Assistant> verAsistenteId(@PathVariable Long id){
        return assistantService.findById(id);
    }

    @PostMapping("/guardar")
    public Assistant guardarAsistente(@RequestBody Assistant assistant){
        return assistantService.guardarAssistant(assistant);
    }

    @PutMapping("/actualizar/{id}")
    public Assistant actualizarAsistente(@PathVariable Long id, @RequestBody Assistant assistant){
        return assistantService.actualizarAssistant(id, assistant);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarAsistente(@PathVariable Long id){
        assistantService.deleteAssistant(id);
        return "Successfully deleted";
    }

}
