package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Assistants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; //nombre
    private String lastName; //apellido
    private String email; //correo
    private String Organization; //Organizacion
    private String position; //Cargo
    private String phoneNumber; //numero de telefono
    private String nationality; //nacionalidad
    private Long Card; //cedula

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_event")
    @JsonBackReference
    private Evento evento;
}
