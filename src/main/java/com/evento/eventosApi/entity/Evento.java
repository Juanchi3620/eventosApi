package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Lugar; //Lugar

    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha; //fecha

    private String nombre; //nombre de evento
    private Integer nro_cupos; // descripción, de que trata
    private Integer num_asistentes; // numero de cupos
    private String patrocinadores; //patrocinadores
    private Long precio_asistente;
    private Long precio_ponente;
    private Long presupuesto_estimado;
    private Long total_gastado;
    private Long total_ingresos;
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_organizer")
    @JsonBackReference
    private Organizer organizer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "evento_asistente", joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "asistente_id", referencedColumnName = "id")
    )
    @JsonBackReference
    private List<Assistant> asistentes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "evento_ponente", joinColumns = @JoinColumn(name = "evento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ponente_id", referencedColumnName = "id")
    )
    @JsonBackReference
    private List<Speaker> ponentes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evento", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Recurso> recursos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evento", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Actividad> actividades;
}
