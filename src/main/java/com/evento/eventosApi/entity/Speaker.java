package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "speakers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName; //apellido
    private String email; //correo
    private String organization; //Organizacion
    private String position; //Cargo

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinTable(
            name = "speaker_participation", joinColumns = @JoinColumn(name = "speaker_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "participation_id", referencedColumnName = "id")
    )
    private List<Participation> participations;
}
