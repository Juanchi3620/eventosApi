package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String place; //Lugar
    private String schedules; //Horarios

    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dateEvent; //fecha

    private String name; //nombre de evento
    private String description; // descripción, de que trata
    private Integer numPlaces; // numero de cupos
    private Integer numPersons; // numero de asistentes
    private String sponsor; //patrocinadores
    private Long recurses; // recursos

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Assistant> assistants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_organizer")
    @JsonBackReference
    private Organizer organizer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "event_participation", joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "participation_id", referencedColumnName = "id")
    )
    private List<Participation> participations;
}
