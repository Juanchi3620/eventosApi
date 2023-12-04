package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
}
