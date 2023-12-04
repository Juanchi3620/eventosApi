package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "organizers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido; //apellido
    private String numero_telefono; //numero de telefono
    private String organizacion; //Organizacion
    private String cargo; //Cargo
    private Long cedula; //cedula


    @OneToOne
    @JoinColumn(name="usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizer", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Evento> events;

    public Organizer(String nombre, String apellido, String numero_telefono, String organizacion, String cargo, Long cedula, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_telefono = numero_telefono;
        this.organizacion = organizacion;
        this.cargo = cargo;
        this.cedula = cedula;
        this.usuario = usuario;
    }
}
