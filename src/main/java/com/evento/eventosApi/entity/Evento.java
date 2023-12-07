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
@Table(name = "eventos")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNro_cupos() {
        return nro_cupos;
    }

    public void setNro_cupos(Integer nro_cupos) {
        this.nro_cupos = nro_cupos;
    }

    public Integer getNum_asistentes() {
        return num_asistentes;
    }

    public void setNum_asistentes(Integer num_asistentes) {
        this.num_asistentes = num_asistentes;
    }

    public String getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(String patrocinadores) {
        this.patrocinadores = patrocinadores;
    }

    public Long getPrecio_asistente() {
        return precio_asistente;
    }

    public void setPrecio_asistente(Long precio_asistente) {
        this.precio_asistente = precio_asistente;
    }

    public Long getPrecio_ponente() {
        return precio_ponente;
    }

    public void setPrecio_ponente(Long precio_ponente) {
        this.precio_ponente = precio_ponente;
    }

    public Long getPresupuesto_estimado() {
        return presupuesto_estimado;
    }

    public void setPresupuesto_estimado(Long presupuesto_estimado) {
        this.presupuesto_estimado = presupuesto_estimado;
    }

    public Long getTotal_gastado() {
        return total_gastado;
    }

    public void setTotal_gastado(Long total_gastado) {
        this.total_gastado = total_gastado;
    }

    public Long getTotal_ingresos() {
        return total_ingresos;
    }

    public void setTotal_ingresos(Long total_ingresos) {
        this.total_ingresos = total_ingresos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public List<Assistant> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Assistant> asistentes) {
        this.asistentes = asistentes;
    }

    public List<Speaker> getPonentes() {
        return ponentes;
    }

    public void setPonentes(List<Speaker> ponentes) {
        this.ponentes = ponentes;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}
