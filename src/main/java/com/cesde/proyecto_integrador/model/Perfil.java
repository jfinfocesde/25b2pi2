package com.cesde.proyecto_integrador.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaNacimiento;

    private String direccion;

    private String telefono;

    private String urlFoto;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    @JsonBackReference
    private Estudiante estudiante;

    @JsonBackReference("profesor-perfil")
    @OneToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;  
}