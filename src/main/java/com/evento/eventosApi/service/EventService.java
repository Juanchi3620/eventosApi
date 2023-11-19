package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Evento> findAllEventos();
    Evento saveEvent(Evento evento);
    Evento updateEvent(Long id, Evento evento);
    void deleteEvent(Long id);
    Optional<Evento> findByname(String name);
    Optional<Evento> findById(Long id);

}
