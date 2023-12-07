package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Actividad;
import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.DTO.ActividadDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadService {
    List<Actividad> verActividades();
    Actividad guardarActividad(ActividadDTO actividadDTO);
    Actividad actualizarActividad(Long id, Actividad actividad);
    void deleteActividad(Long id);
    Optional<Actividad> findById(Long id);
}
