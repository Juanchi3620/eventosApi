package com.evento.eventosApi.entity.DTO;

import com.evento.eventosApi.entity.Evento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ActividadDTO {
    private Long id;
    private String nombre;
    private Date fecha;
    private Time hora_inicio;
    private Time hora_final;

    private Evento evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_final() {
        return hora_final;
    }

    public void setHora_final(Time hora_final) {
        this.hora_final = hora_final;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
