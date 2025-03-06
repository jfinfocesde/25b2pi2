package com.cesde.proyecto_integrador.service;

import java.util.List;
import java.util.Optional;

import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.model.Nota;


public interface EstudianteService {

    //Operaciones CRUD
    List<Estudiante> getAllEstudiantes();

    Estudiante getEstudianteById(Long id);

    Estudiante createEstudiante(Estudiante estudiante);

    Estudiante updateEstudiante(Long id, Estudiante estudiante);

    void deleteEstudiante(Long id);

    //Operaciones adicionales

    public Optional<Estudiante> buscarPorDocumento(String numeroDocumento) ;

    public List<Estudiante> buscarPorGrupo(Long grupoId) ;

    public Optional<List<Nota>> obtenerNotas(Long id) ;  

    public Optional<Estudiante> asignarGrupo(Long estudianteId, Long grupoId) ;

   
}
