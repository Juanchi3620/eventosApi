package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Ponencia;
import com.evento.eventosApi.repository.PonenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PonenciaServiceImpl implements PonenciaService {

    @Autowired
    PonenciaRepository ponenciaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Ponencia> verPonencia() {
        return ponenciaRepository.findAll();
    }

    @Transactional
    @Override
    public Ponencia guardarPonencia(Ponencia ponencia) {
        return ponenciaRepository.save(ponencia);
    }

    @Transactional
    @Override
    public Ponencia actualizarPonencia(Long id, Ponencia ponencia) {
        Ponencia pon = ponenciaRepository.findById(id).get();
        if (Objects.nonNull(ponencia.getTema()) && !"".equalsIgnoreCase(ponencia.getTema())) {
            pon.setTema(ponencia.getTema());
        }
        if (Objects.nonNull(ponencia.getDescripcion()) && !"".equalsIgnoreCase(ponencia.getDescripcion())) {
            pon.setDescripcion(ponencia.getDescripcion());
        }

        return ponenciaRepository.save(pon);
    }

    @Transactional
    @Override
    public void deletePonencia(Long id) {
        ponenciaRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Ponencia> findById(Long id) {
        return ponenciaRepository.findById(id);
    }
}
