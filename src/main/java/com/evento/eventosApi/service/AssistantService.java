package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.Assistant;

import java.util.List;
import java.util.Optional;

public interface AssistantService {
    List<Assistant> verAsistentes();
    Assistant guardarAssistant(Assistant assistant);
    Assistant actualizarAssistant(Long id, Assistant assistant);
    void deleteAssistant(Long id);
    Optional<Assistant> findById(Long id);
}
