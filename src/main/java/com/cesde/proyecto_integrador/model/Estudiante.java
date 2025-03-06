package com.cesde.proyecto_integrador.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento; 

    @Column(unique = true)
    private String numeroDocumento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> semestres;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @JsonManagedReference
    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Perfil perfil;

    @PostPersist
    public void inicializar() {

        // Crea los semestres si no existen
        if (semestres == null) {
            semestres = new ArrayList<>();
        }

        // Create notes for semesters 1, 2, and 3 if they don't exist
        for (int i = 1; i <= 3; i++) {
            boolean semestreExists = false;
            for (Nota nota : semestres) {
                if (nota.getNumeroSemestre() == i) {
                    semestreExists = true;
                    break;
                }
            }

            if (!semestreExists) {
                Nota nota = new Nota();
                nota.setNumeroSemestre(i);
                nota.setEstudiante(this);
                semestres.add(nota);
            }
        }

        //Crea perfil
        if (perfil == null) {
            perfil = new Perfil();
            perfil.setEstudiante(this);
        }
    }    
}
