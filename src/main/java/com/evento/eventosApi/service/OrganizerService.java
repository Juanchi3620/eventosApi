package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    List<Organizer> findAllOrganizers();
    Organizer saveOrganizer(Organizer organizador);
    Organizer updateOrganizer(Long id, Organizer organizador);
    void deleteOrganizer(Long id);
    Optional<Organizer> findById(Long id);

}
