package com.evento.eventosApi.service;

import com.evento.eventosApi.entity.Admin;
import com.evento.eventosApi.entity.Assistant;
import com.evento.eventosApi.entity.DTO.AssistantDTO;
import com.evento.eventosApi.entity.Usuario;
import com.evento.eventosApi.repository.AssistantRepository;
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
public class AssistantServiceImpl implements AssistantService{

    @Autowired
    AssistantRepository assistantRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Assistant> verAsistentes() {
        return assistantRepository.findAll();
    }

    @Transactional
    @Override
    public Assistant guardarAssistant(AssistantDTO assistantDTO) {
        log.info(assistantDTO.getUsuarioDTO().getCorreo());
        Usuario usuario= usuarioRepository.findByCorreo(assistantDTO.getUsuarioDTO().getCorreo());
        Assistant assistant = new Assistant(assistantDTO.getNombre(), assistantDTO.getApellido(), assistantDTO.getOrganizacion(), assistantDTO.getCargo(), assistantDTO.getNumero_telefono(), assistantDTO.getNacionalidad(), assistantDTO.getCedula(), usuario);
        return assistantRepository.save(assistant);
    }

    @Transactional
    @Override
    public Assistant actualizarAssistant(Long id, Assistant assistant) {
        Assistant ass = assistantRepository.findById(id).get();
        if(Objects.nonNull(assistant.getNombre()) && !"".equalsIgnoreCase(assistant.getNombre())){
            ass.setNombre(assistant.getNombre());
        }
        if(Objects.nonNull(assistant.getApellido()) && !"".equalsIgnoreCase(assistant.getApellido())){
            ass.setApellido(assistant.getApellido());
        }
        if(Objects.nonNull(assistant.getOrganizacion()) && !"".equalsIgnoreCase(assistant.getOrganizacion())){
            ass.setOrganizacion(assistant.getOrganizacion());
        }
        if(Objects.nonNull(assistant.getCargo()) && !"".equalsIgnoreCase(assistant.getCargo())){
            ass.setCargo(assistant.getCargo());
        }
        if(Objects.nonNull(assistant.getNumero_telefono()) && !"".equalsIgnoreCase(assistant.getNumero_telefono())){
            ass.setNumero_telefono(assistant.getNumero_telefono());
        }
        if(Objects.nonNull(assistant.getNacionalidad()) && !"".equalsIgnoreCase(assistant.getNacionalidad())){
            ass.setNacionalidad(assistant.getNacionalidad());
        }
        if(Objects.nonNull(assistant.getCedula()) && !"".equalsIgnoreCase(assistant.getCedula().toString())){
            ass.setCedula(assistant.getCedula());
        }

        return assistantRepository.save(ass);
    }

    @Transactional
    @Override
    public void deleteAssistant(Long id) {
        assistantRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Assistant> findById(Long id) {
        return assistantRepository.findById(id);
    }
}
