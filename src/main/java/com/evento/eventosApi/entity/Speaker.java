package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "speakers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido; //apellido
    private String organizacion; //Organizacion
    private String cargo; //Cargo
    private String nacionalidad;
    private Long cedula;

    @OneToOne
    @JoinColumn(name="usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinTable(
            name = "speaker_participation", joinColumns = @JoinColumn(name = "ponente_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ponencia_id", referencedColumnName = "id")
    )
    private List<Ponencia> ponencias;

    @ManyToMany(mappedBy = "ponentes")
    @JsonBackReference
    private List<Evento> eventos;

    public Speaker(String nombre, String apellido, String organizacion, String cargo, String nacionalidad, Long cedula, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.cargo = cargo;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
        this.usuario = usuario;
    }
}
