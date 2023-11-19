package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Organizer;
import com.evento.eventosApi.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrganizerServiceImpl implements OrganizerService{

    @Autowired
    OrganizerRepository organizerRepository;

    @Override
    public List<Organizer> findAllOrganizers() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer saveOrganizer(Organizer organizador) {
        return organizerRepository.save(organizador);
    }

    @Override
    public Organizer updateOrganizer(Long id, Organizer organizador) {
        Organizer organ = organizerRepository.findById(id).get();
        if(Objects.nonNull(organizador.getOrganization()) && !"".equalsIgnoreCase(organizador.getOrganization())){organ.setOrganization(organizador.getOrganization());
        }
        if(Objects.nonNull(organizador.getCard()) && !"".equalsIgnoreCase(organizador.getCard().toString())){organ.setCard(organizador.getCard());
        }
        if(Objects.nonNull(organizador.getName()) && !"".equalsIgnoreCase(organizador.getName())){organ.setName(organizador.getName());
        }
        if(Objects.nonNull(organizador.getLastName()) && !"".equalsIgnoreCase(organizador.getLastName())){organ.setLastName(organizador.getLastName());
        }
        if(Objects.nonNull(organizador.getEmail()) && !"".equalsIgnoreCase(organizador.getEmail())){organ.setEmail(organizador.getEmail());
        }
        if(Objects.nonNull(organizador.getPosition()) && !"".equalsIgnoreCase(organizador.getPosition())){organ.setPosition(organizador.getPosition());
        }
        if(Objects.nonNull(organizador.getPhoneNumber()) && !"".equalsIgnoreCase(organizador.getPhoneNumber())){organ.setPhoneNumber(organizador.getPhoneNumber());
        }
        return organizerRepository.save(organ);
    }

    @Override
    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }

    @Override
    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id);
    }
}
