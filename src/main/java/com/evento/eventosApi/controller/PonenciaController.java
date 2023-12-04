package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Ponencia;
import com.evento.eventosApi.service.PonenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ponencias")
public class PonenciaController {
    @Autowired
    PonenciaService ponenciaService;

    @GetMapping()
    public List<Ponencia> verPonencias(){
        return ponenciaService.verPonencia();
    }

    @GetMapping("/{id}")
    public Optional<Ponencia> buscarId(@PathVariable Long id){
        return ponenciaService.findById(id);
    }

    @PostMapping("/guardar")
    public Ponencia guardarPonencia(@RequestBody Ponencia ponencia){
        return ponenciaService.guardarPonencia(ponencia);
    }

    @PutMapping("/actualizar/{id}")
    public Ponencia actualizarPonencia(@PathVariable Long id, @RequestBody Ponencia ponencia){
        return ponenciaService.actualizarPonencia(id, ponencia);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPonencia(@PathVariable Long id){
        ponenciaService.deletePonencia(id);
        return "La ponencia se ha borrado con éxito";
    }

}
