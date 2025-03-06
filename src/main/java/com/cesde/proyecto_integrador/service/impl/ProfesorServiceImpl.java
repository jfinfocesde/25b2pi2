package com.cesde.proyecto_integrador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.model.Profesor;
import com.cesde.proyecto_integrador.repository.ProfesorRepository;
import com.cesde.proyecto_integrador.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

     // Operaciones CRUD
    @Override
    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor getProfesorById(Long id) {
        return profesorRepository.findById(id).get();
    }

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor updateProfesor(Long id, Profesor profesor) {
        Profesor profesorActual = profesorRepository.findById(id).get();
        profesorActual.setNombre(profesor.getNombre());
        profesorActual.setApellido(profesor.getApellido());
        return profesorRepository.save(profesorActual);
    }

    @Override
    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
   
    // Operaciones adicionales
}