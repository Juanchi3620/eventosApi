package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Participation;
import com.evento.eventosApi.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ParticipationServiceImpl implements ParticipationService{

    @Autowired
    ParticipationRepository participationRepository;

    @Override
    public List<Participation> verParticipacion() {
        return participationRepository.findAll();
    }

    @Override
    public Participation guardarParticipacion(Participation participation) {
        return participationRepository.save(participation);
    }

    @Override
    public Participation actualizarParticipacion(Long id, Participation participation) {
        Participation part = participationRepository.findById(id).get();
        if(Objects.nonNull(participation.getSubject()) && !"".equalsIgnoreCase(participation.getSubject())){part.setSubject(participation.getSubject());
        }
        if(Objects.nonNull(participation.getPresentation()) && !"".equalsIgnoreCase(participation.getPresentation())){part.setPresentation(participation.getPresentation());
        }

        return participationRepository.save(part);
    }

    @Override
    public void deleteParticipacion(Long id) {
        participationRepository.deleteById(id);
    }

    @Override
    public Optional<Participation> findById(Long id) {
        return participationRepository.findById(id);
    }
}
