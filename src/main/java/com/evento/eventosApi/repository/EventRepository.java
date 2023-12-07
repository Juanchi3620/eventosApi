package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Evento,Long> {
    Evento findByNombre(String nombre);
}
