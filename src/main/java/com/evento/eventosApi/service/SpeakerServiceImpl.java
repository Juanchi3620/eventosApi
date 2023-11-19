package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Speaker;
import com.evento.eventosApi.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SpeakerServiceImpl implements SpeakerService{

    @Autowired
    SpeakerRepository speakerRepository;

    @Override
    public List<Speaker> verSpeaker() {
        return speakerRepository.findAll();
    }

    @Override
    public Speaker guardarSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @Override
    public Speaker actualizarSpeaker(Long id, Speaker speaker) {
        Speaker spk = speakerRepository.findById(id).get();
        if(Objects.nonNull(speaker.getOrganization()) && !"".equalsIgnoreCase(speaker.getOrganization())){spk.setOrganization(speaker.getOrganization());
        }
        if(Objects.nonNull(speaker.getName()) && !"".equalsIgnoreCase(speaker.getName())){spk.setName(speaker.getName());
        }
        if(Objects.nonNull(speaker.getLastName()) && !"".equalsIgnoreCase(speaker.getLastName())){spk.setLastName(speaker.getLastName());
        }
        if(Objects.nonNull(speaker.getEmail()) && !"".equalsIgnoreCase(speaker.getEmail())){spk.setEmail(speaker.getEmail());
        }
        if(Objects.nonNull(speaker.getPosition()) && !"".equalsIgnoreCase(speaker.getPosition())){spk.setPosition(speaker.getPosition());
        }

        return speakerRepository.save(spk);
    }

    @Override
    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }

    @Override
    public Optional<Speaker> findById(Long id) {
        return speakerRepository.findById(id);
    }
}
