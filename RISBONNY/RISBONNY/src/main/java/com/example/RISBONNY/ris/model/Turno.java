package com.example.RISBONNY.ris.model;
import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctor;

    @Column(name = "fecha_inicio")
    private Time fechaInicio;

    @Column(name = "fecha_fin")
    private Time fechaFin;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Time getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Time fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Time getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Time fechaFin) {
        this.fechaFin = fechaFin;
    }
}