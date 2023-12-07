package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Actividad;
import com.evento.eventosApi.entity.DTO.ActividadDTO;
import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.repository.ActividadRepository;
import com.evento.eventosApi.repository.EventRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService{

    @Autowired
    ActividadRepository actividadRepository;
    @Autowired
    EventRepository eventRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Actividad> verActividades() {
        return actividadRepository.findAll();
    }

    @Transactional
    @Override
    public Actividad guardarActividad(ActividadDTO actividadDTO)
    {
        Evento evento = eventRepository.findByNombre(actividadDTO.getEvento().getNombre());
        Actividad actividad = new Actividad(actividadDTO.getNombre(),actividadDTO.getFecha(),actividadDTO.getHora_inicio(),actividadDTO.getHora_final(),actividadDTO.getEvento());

        return actividadRepository.save(actividad);
    }

    @Transactional
    @Override
    public Actividad actualizarActividad(Long id, Actividad actividad) {
        Actividad activi = actividadRepository.findById(id).get();

        if(Objects.nonNull(actividad.getNombre()) && !"".equalsIgnoreCase(actividad.getNombre())){
            activi.setNombre(actividad.getNombre());
        }
        if(Objects.nonNull(actividad.getFecha()) && !"".equalsIgnoreCase(actividad.getFecha().toString())){
            activi.setFecha(actividad.getFecha());
        }
        if(Objects.nonNull(actividad.getHora_inicio()) && !"".equalsIgnoreCase(actividad.getHora_inicio().toString())){
            activi.setHora_inicio(actividad.getHora_inicio());
        }
        if(Objects.nonNull(actividad.getHora_final()) && !"".equalsIgnoreCase(actividad.getHora_final().toString())){
            activi.setHora_final(actividad.getHora_final());
        }

        return actividadRepository.save(activi);
    }

    @Transactional
    @Override
    public void deleteActividad(Long id) {
        actividadRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Actividad> findById(Long id) {
        return actividadRepository.findById(id);
    }
}
