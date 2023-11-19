package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.Assistant;
import com.evento.eventosApi.repository.AssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AssistantServiceImpl implements AssistantService{

    @Autowired
    AssistantRepository assistantRepository;

    @Override
    public List<Assistant> verAsistentes() {
        return assistantRepository.findAll();
    }

    @Override
    public Assistant guardarAssistant(Assistant assistant) {
        return assistantRepository.save(assistant);
    }

    @Override
    public Assistant actualizarAssistant(Long id, Assistant assistant) {
        Assistant ass = assistantRepository.findById(id).get();
        if(Objects.nonNull(assistant.getName()) && !"".equalsIgnoreCase(assistant.getName())){
            ass.setName(assistant.getName());
        }
        if(Objects.nonNull(assistant.getLastName()) && !"".equalsIgnoreCase(assistant.getLastName())){
            ass.setLastName(assistant.getLastName());
        }
        if(Objects.nonNull(assistant.getEmail()) && !"".equalsIgnoreCase(assistant.getEmail())){
            ass.setEmail(assistant.getEmail());
        }
        if(Objects.nonNull(assistant.getOrganization()) && !"".equalsIgnoreCase(assistant.getOrganization())){
            ass.setOrganization(assistant.getOrganization());
        }
        if(Objects.nonNull(assistant.getPosition()) && !"".equalsIgnoreCase(assistant.getPosition())){
            ass.setPosition(assistant.getPosition());
        }
        if(Objects.nonNull(assistant.getPhoneNumber()) && !"".equalsIgnoreCase(assistant.getPhoneNumber())){
            ass.setPhoneNumber(assistant.getPhoneNumber());
        }
        if(Objects.nonNull(assistant.getNationality()) && !"".equalsIgnoreCase(assistant.getNationality())){
            ass.setNationality(assistant.getNationality());
        }
        if(Objects.nonNull(assistant.getCard()) && !"".equalsIgnoreCase(assistant.getCard().toString())){
            ass.setCard(assistant.getCard());
        }

        return assistantRepository.save(ass);
    }

    @Override
    public void deleteAssistant(Long id) {
        assistantRepository.deleteById(id);
    }

    @Override
    public Optional<Assistant> findById(Long id) {
        return assistantRepository.findById(id);
    }
}
