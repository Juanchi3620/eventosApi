package com.evento.eventosApi.repository;

import com.evento.eventosApi.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
