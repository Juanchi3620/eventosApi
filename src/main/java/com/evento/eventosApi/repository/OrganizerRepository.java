package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    @Override
    Optional<Organizer> findById(Long id);
}
