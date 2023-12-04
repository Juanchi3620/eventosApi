package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Recurso;
import com.evento.eventosApi.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    RecursoRepository recursoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Recurso> verRecurso() {
        return recursoRepository.findAll();
    }

    @Transactional
    @Override
    public Recurso guardarRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    @Transactional
    @Override
    public Recurso actualizarRecurso(Long id, Recurso recurso) {
        Recurso rec = recursoRepository.findById(id).get();

        if (Objects.nonNull(recurso.getNombre()) && !"".equalsIgnoreCase(recurso.getNombre())) {
            rec.setNombre(recurso.getNombre());
        }
        if (Objects.nonNull(recurso.getCantidad()) && !"".equalsIgnoreCase(recurso.getCantidad().toString())) {
            rec.setCantidad(recurso.getCantidad());
        }
        if (Objects.nonNull(recurso.getTotal_costo()) && !"".equalsIgnoreCase(recurso.getTotal_costo().toString())) {
            rec.setTotal_costo(recurso.getTotal_costo());
        }

        return recursoRepository.save(rec);
    }

    @Transactional
    @Override
    public void deleteRecurso(Long id) {
        recursoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Recurso> findById(Long id) {
        return recursoRepository.findById(id);
    }
}
