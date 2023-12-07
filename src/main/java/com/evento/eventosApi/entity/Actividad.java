package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "actividades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha;

    private Time hora_inicio;
    private Time hora_final;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    @JsonBackReference
    private Evento evento;

    public Actividad(String nombre, Date fecha, Time hora_inicio, Time hora_final, Evento evento) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.evento = evento;
    }
}
