package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Assistant;
import com.evento.eventosApi.entity.DTO.OrganizerDTO;
import com.evento.eventosApi.entity.Organizer;
import com.evento.eventosApi.entity.Usuario;
import com.evento.eventosApi.repository.OrganizerRepository;
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
public class OrganizerServiceImpl implements OrganizerService{

    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Organizer> findAllOrganizers() {
        return organizerRepository.findAll();
    }

    @Transactional
    @Override
    public Organizer saveOrganizer(OrganizerDTO organizerDTO) {

        log.info(organizerDTO.getUsuarioDTO().getCorreo());
        Usuario usuario= usuarioRepository.findByCorreo(organizerDTO.getUsuarioDTO().getCorreo());
        Organizer organizador = new Organizer(organizerDTO.getNombre(),organizerDTO.getApellido(), organizerDTO.getNumero_telefono(), organizerDTO.getOrganizacion(), organizerDTO.getCargo(), organizerDTO.getCedula(), usuario);

        return organizerRepository.save(organizador);
    }

    @Transactional
    @Override
    public Organizer updateOrganizer(Long id, Organizer organizador) {
        Organizer organ = organizerRepository.findById(id).get();
        if(Objects.nonNull(organizador.getOrganizacion()) && !"".equalsIgnoreCase(organizador.getOrganizacion())){organ.setOrganizacion(organizador.getOrganizacion());
        }
        if(Objects.nonNull(organizador.getCedula()) && !"".equalsIgnoreCase(organizador.getCedula().toString())){organ.setCedula(organizador.getCedula());
        }
        if(Objects.nonNull(organizador.getNombre()) && !"".equalsIgnoreCase(organizador.getNombre())){organ.setNombre(organizador.getNombre());
        }
        if(Objects.nonNull(organizador.getApellido()) && !"".equalsIgnoreCase(organizador.getApellido())){organ.setApellido(organizador.getApellido());
        }
        if(Objects.nonNull(organizador.getCargo()) && !"".equalsIgnoreCase(organizador.getCargo())){organ.setCargo(organizador.getCargo());
        }
        if(Objects.nonNull(organizador.getNumero_telefono()) && !"".equalsIgnoreCase(organizador.getNumero_telefono())){organ.setNumero_telefono(organizador.getNumero_telefono());
        }
        return organizerRepository.save(organ);
    }

    @Transactional
    @Override
    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id);
    }
}
