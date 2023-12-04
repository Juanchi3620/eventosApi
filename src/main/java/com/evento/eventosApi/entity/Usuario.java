package com.evento.eventosApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String correo;
    private String contrasena;

    @OneToOne(mappedBy = "usuario")
    private Admin admin;

    @OneToOne(mappedBy = "usuario")
    private Assistant asistente;

    @OneToOne(mappedBy = "usuario")
    private Organizer organizador;

    @OneToOne(mappedBy = "usuario")
    private Speaker ponente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    @JsonBackReference
    private Rol rol;

    public Usuario(String correo, String contrasena, Rol rol) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Assistant getAsistente() {
        return asistente;
    }

    public void setAsistente(Assistant asistente) {
        this.asistente = asistente;
    }

    public Organizer getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizer organizador) {
        this.organizador = organizador;
    }

    public Speaker getPonente() {
        return ponente;
    }

    public void setPonente(Speaker ponente) {
        this.ponente = ponente;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", admin=" + admin +
                ", asistente=" + asistente +
                ", organizador=" + organizador +
                ", ponente=" + ponente +
                ", rol=" + rol +
                '}';
    }
}
