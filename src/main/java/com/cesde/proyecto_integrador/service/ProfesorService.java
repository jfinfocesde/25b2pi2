package com.cesde.proyecto_integrador.service;

import java.util.List;

import com.cesde.proyecto_integrador.model.Profesor;

public interface ProfesorService {

     // Operaciones CRUD
    List<Profesor> getAllProfesores();

    Profesor getProfesorById(Long id);

    Profesor createProfesor(Profesor profesor);

    Profesor updateProfesor(Long id, Profesor profesor);

    void deleteProfesor(Long id);   
}
