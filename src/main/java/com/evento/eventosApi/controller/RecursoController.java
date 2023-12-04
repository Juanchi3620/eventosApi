package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Ponencia;
import com.evento.eventosApi.entity.Recurso;
import com.evento.eventosApi.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recursos")
public class RecursoController {
    @Autowired
    RecursoService recursoService;

    @GetMapping()
    public List<Recurso> verRecursos(){
        return recursoService.verRecurso();
    }

    @GetMapping("/{id}")
    public Optional<Recurso> buscarId(@PathVariable Long id){
        return recursoService.findById(id);
    }

    @PostMapping("/guardar")
    public Recurso guardarRecurso(@RequestBody Recurso recurso){
        return recursoService.guardarRecurso(recurso);
    }

    @PutMapping("/actualizar/{id}")
    public Recurso actualizarRecurso(@PathVariable Long id, @RequestBody Recurso recurso){
        return recursoService.actualizarRecurso(id, recurso);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarRecurso(@PathVariable Long id){
        recursoService.deleteRecurso(id);
        return "El recurso se ha borrado con éxito";
    }
}
