package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="Assistants")
@AllArgsConstructor
@NoArgsConstructor
public class Assistant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre; //nombre
    private String apellido; //apellido
    private String Organizacion; //Organizacion
    private String cargo; //Cargo
    private String numero_telefono; //numero de telefono
    private String nacionalidad; //nacionalidad
    private Long cedula; //cedula

    @OneToOne
    @JoinColumn(name="usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToMany(mappedBy = "asistentes")
    @JsonBackReference
    private List<Evento> eventos;


    public Assistant(String nombre, String apellido, String organizacion, String cargo, String numero_telefono, String nacionalidad, Long cedula, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        Organizacion = organizacion;
        this.cargo = cargo;
        this.numero_telefono = numero_telefono;
        this.nacionalidad = nacionalidad;
        this.cedula = cedula;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOrganizacion() {
        return Organizacion;
    }

    public void setOrganizacion(String organizacion) {
        Organizacion = organizacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
