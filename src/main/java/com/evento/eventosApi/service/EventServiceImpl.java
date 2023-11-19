package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Evento> findAllEventos() {
        return eventRepository.findAll();
    }

    @Override
    public Evento saveEvent(Evento evento) {
        return eventRepository.save(evento);
    }

    @Override
    public Evento updateEvent(Long id, Evento evento) {
        Evento event = eventRepository.findById(id).get();
        if(Objects.nonNull(evento.getDateEvent()) && !"".equalsIgnoreCase(evento.getDateEvent().toString())){
            event.setDateEvent(evento.getDateEvent());
        }
        if(Objects.nonNull(evento.getName()) && !"".equalsIgnoreCase(evento.getName())){
            event.setName(evento.getName());
        }
        if(Objects.nonNull(evento.getSchedules()) && !"".equalsIgnoreCase(evento.getSchedules())){
            event.setSchedules(evento.getSchedules());
        }
        if(Objects.nonNull(evento.getDescription()) && !"".equalsIgnoreCase(evento.getDescription())){
            event.setDescription(evento.getDescription());
        }
        if(Objects.nonNull(evento.getPlace()) && !"".equalsIgnoreCase(evento.getPlace())){
            event.setPlace(evento.getPlace());
        }
        if(Objects.nonNull(evento.getNumPersons()) && !"".equalsIgnoreCase(String.valueOf(evento.getNumPersons()))){
            event.setNumPersons(evento.getNumPersons());
        }
        if(Objects.nonNull(evento.getRecurses()) && !"".equalsIgnoreCase(String.valueOf(evento.getRecurses()))){
            event.setRecurses(evento.getRecurses());
        }
        if(Objects.nonNull(evento.getNumPlaces()) && !"".equalsIgnoreCase(String.valueOf(evento.getNumPlaces()))){
            event.setNumPlaces(evento.getNumPlaces());
        }
        if(Objects.nonNull(evento.getSponsor()) && !"".equalsIgnoreCase(evento.getSponsor())){
            event.setSponsor(evento.getSponsor());
        }
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Optional<Evento> findByname(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return eventRepository.findById(id);
    }
}
