package com.evento.eventosApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "organizers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName; //apellido
    private String email; //correo
    private String organization; //Organizacion
    private String position; //Cargo
    private String phoneNumber; //numero de telefono
    private Long card; //cedula

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizer", cascade = CascadeType.ALL)
    List<Evento> events;
}
