package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ponencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ponencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tema;
    private String descripcion;

    @ManyToMany(mappedBy = "ponencias")
    @JsonBackReference
    private List<Speaker> ponentes;

    @ManyToMany(mappedBy = "ponencias")
    @JsonBackReference
    private List<Speaker> speakers;

}
