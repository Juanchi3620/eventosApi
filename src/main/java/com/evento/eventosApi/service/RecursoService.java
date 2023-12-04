package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Ponencia;
import com.evento.eventosApi.entity.Recurso;

import java.util.List;
import java.util.Optional;

public interface RecursoService {
    List<Recurso> verRecurso();
    Recurso guardarRecurso(Recurso recurso);
    Recurso actualizarRecurso(Long id, Recurso recurso);
    void deleteRecurso(Long id);
    Optional<Recurso> findById(Long id);
}
