package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.DTO.SpeakerDTO;
import com.evento.eventosApi.entity.Organizer;
import com.evento.eventosApi.entity.Speaker;
import com.evento.eventosApi.entity.Usuario;
import com.evento.eventosApi.repository.SpeakerRepository;
import com.evento.eventosApi.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class SpeakerServiceImpl implements SpeakerService{

    @Autowired
    SpeakerRepository speakerRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Speaker> verSpeaker() {
        return speakerRepository.findAll();
    }

    @Transactional
    @Override
    public Speaker guardarSpeaker(SpeakerDTO speakerDTO) {
        log.info(speakerDTO.getUsuarioDTO().getCorreo());
        Usuario usuario= usuarioRepository.findByCorreo(speakerDTO.getUsuarioDTO().getCorreo());
        Speaker speaker = new Speaker(speakerDTO.getNombre(), speakerDTO.getApellido(), speakerDTO.getOrganizacion(), speakerDTO.getCargo(), speakerDTO.getNacionalidad(), speakerDTO.getCedula(), usuario);
        return speakerRepository.save(speaker);
    }

    @Transactional
    @Override
    public Speaker actualizarSpeaker(Long id, Speaker speaker) {
        Speaker spk = speakerRepository.findById(id).get();
        if(Objects.nonNull(speaker.getOrganizacion()) && !"".equalsIgnoreCase(speaker.getOrganizacion())){spk.setOrganizacion(speaker.getCargo());
        }
        if(Objects.nonNull(speaker.getNombre()) && !"".equalsIgnoreCase(speaker.getNombre())){spk.setNombre(speaker.getNombre());
        }
        if(Objects.nonNull(speaker.getApellido()) && !"".equalsIgnoreCase(speaker.getApellido())){spk.setApellido(speaker.getApellido());
        }
        if(Objects.nonNull(speaker.getCargo()) && !"".equalsIgnoreCase(speaker.getCargo())){spk.setCargo(speaker.getCargo());
        }
        if(Objects.nonNull(speaker.getNacionalidad()) && !"".equalsIgnoreCase(speaker.getNacionalidad())){spk.setNacionalidad(speaker.getNacionalidad());
        }
        if(Objects.nonNull(speaker.getCedula()) && !"".equalsIgnoreCase(speaker.getCedula().toString())){spk.setCedula(speaker.getCedula());
        }

        return speakerRepository.save(spk);
    }

    @Transactional
    @Override
    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Speaker> findById(Long id) {
        return speakerRepository.findById(id);
    }
}
