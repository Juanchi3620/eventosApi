package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.DTO.SpeakerDTO;
import com.evento.eventosApi.entity.Speaker;

import java.util.List;
import java.util.Optional;

public interface SpeakerService {
    List<Speaker> verSpeaker();
    Speaker guardarSpeaker(SpeakerDTO speakerDTO);
    Speaker actualizarSpeaker(Long id, Speaker speaker);
    void deleteSpeaker(Long id);
    Optional<Speaker> findById(Long id);
}
