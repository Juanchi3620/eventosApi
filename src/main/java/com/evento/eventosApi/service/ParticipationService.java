package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Participation;

import java.util.List;
import java.util.Optional;

public interface ParticipationService {
    List<Participation> verParticipacion();
    Participation guardarParticipacion(Participation participation);
    Participation actualizarParticipacion(Long id, Participation participation);
    void deleteParticipacion(Long id);
    Optional<Participation> findById(Long id);
}
