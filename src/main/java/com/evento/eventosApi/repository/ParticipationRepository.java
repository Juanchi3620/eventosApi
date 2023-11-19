package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
