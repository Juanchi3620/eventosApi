package com.evento.eventosApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "participations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subject; //tema
    private String presentation; //ponencia

    @ManyToMany(mappedBy = "participations")
    private List<Evento> events;

    @ManyToMany(mappedBy = "participations")
    private List<Speaker> speakers;

}
