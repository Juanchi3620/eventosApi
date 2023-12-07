package com.evento.eventosApi.controller;

import com.evento.eventosApi.entity.Actividad;
import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.DTO.ActividadDTO;
import com.evento.eventosApi.service.ActividadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actividades")
@Slf4j
public class ActividadController {
    @Autowired
    ActividadService actividadService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Actividad> verActividades(Model model) {
        log.info("Estoy en el controlador");
        return actividadService.verActividades();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Actividad> findById(@PathVariable Long id) {
        return actividadService.findById(id);
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad saveActividad(@RequestBody ActividadDTO actividadDTO) {
        return actividadService.guardarActividad(actividadDTO);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad actualizarActividad(@PathVariable Long id, @RequestBody Actividad actividad) {
        return actividadService.actualizarActividad(id, actividad);
    }

    @DeleteMapping("/borrar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteActividad(@PathVariable Long id) {
        actividadService.deleteActividad(id);
        return "Successfully deleted";
    }

}
