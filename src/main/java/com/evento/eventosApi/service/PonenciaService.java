package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Ponencia;

import java.util.List;
import java.util.Optional;

public interface PonenciaService {
    List<Ponencia> verPonencia();
    Ponencia guardarPonencia(Ponencia ponencia);
    Ponencia actualizarPonencia(Long id, Ponencia ponencia);
    void deletePonencia(Long id);
    Optional<Ponencia> findById(Long id);
}
