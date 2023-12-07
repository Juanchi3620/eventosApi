package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Evento;
import com.evento.eventosApi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Evento> findAllEventos() {
        return eventRepository.findAll();
    }

    @Transactional
    @Override
    public Evento saveEvent(Evento evento) {
        return eventRepository.save(evento);
    }

    @Transactional
    @Override
    public Evento updateEvent(Long id, Evento evento) {
        Evento event = eventRepository.findById(id).get();
        if(Objects.nonNull(evento.getLugar()) && !"".equalsIgnoreCase(evento.getLugar())){
            event.setLugar(evento.getLugar());
        }
        if(Objects.nonNull(evento.getFecha()) && !"".equalsIgnoreCase(evento.getFecha().toString())){
            event.setFecha(evento.getFecha());
        }
        if(Objects.nonNull(evento.getNombre()) && !"".equalsIgnoreCase(evento.getNombre())){
            event.setNombre(evento.getNombre());
        }
        if(Objects.nonNull(evento.getNro_cupos()) && !"".equalsIgnoreCase(evento.getNro_cupos().toString())){
            event.setNro_cupos(evento.getNro_cupos());
        }
        if(Objects.nonNull(evento.getNum_asistentes()) && !"".equalsIgnoreCase(String.valueOf(evento.getNum_asistentes()))){
            event.setNum_asistentes(evento.getNum_asistentes());
        }
        if(Objects.nonNull(evento.getPatrocinadores()) && !"".equalsIgnoreCase(String.valueOf(evento.getPatrocinadores()))){
            event.setPatrocinadores(evento.getPatrocinadores());
        }
        if(Objects.nonNull(evento.getPrecio_asistente()) && !"".equalsIgnoreCase(String.valueOf(evento.getPrecio_asistente().toString()))){
            event.setPrecio_asistente(evento.getPrecio_asistente());
        }
        if(Objects.nonNull(evento.getPrecio_ponente()) && !"".equalsIgnoreCase(evento.getPrecio_ponente().toString())){
            event.setPrecio_ponente(evento.getPrecio_ponente());
        }
        if(Objects.nonNull(evento.getPresupuesto_estimado()) && !"".equalsIgnoreCase(evento.getPresupuesto_estimado().toString())){
            event.setPresupuesto_estimado(evento.getPresupuesto_estimado());
        }
        if(Objects.nonNull(evento.getTotal_gastado()) && !"".equalsIgnoreCase(evento.getTotal_gastado().toString())){
            event.setTotal_gastado(evento.getTotal_gastado());
        }
        if(Objects.nonNull(evento.getTotal_ingresos()) && !"".equalsIgnoreCase(evento.getTotal_ingresos().toString())){
            event.setTotal_ingresos(evento.getTotal_ingresos());
        }
        if(Objects.nonNull(evento.getEstado()) && !"".equalsIgnoreCase(evento.getEstado())){
            event.setEstado(evento.getEstado());
        }

        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Evento findByname(String nombre) {
        return eventRepository.findByNombre(nombre);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Evento> findById(Long id) {
        return eventRepository.findById(id);
    }
}
