package com.cesde.proyecto_integrador.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @JsonManagedReference("profesor-grupo")
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> grupos;   


    @JsonManagedReference("profesor-perfil")
    @OneToOne(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Perfil perfil;

    @PostPersist
    public void inicializar() {
        //Crea perfil
        if (perfil == null) {
            perfil = new Perfil();
            perfil.setProfesor(this);
        }
    }    
   
}
