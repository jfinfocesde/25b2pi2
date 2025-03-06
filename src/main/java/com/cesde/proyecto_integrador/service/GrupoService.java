package com.cesde.proyecto_integrador.service;

import java.util.List;

import com.cesde.proyecto_integrador.model.Grupo;

public interface GrupoService {

    //Operaciones CRUD
    List<Grupo> getAllGrupos();

    Grupo getGrupoById(Long id);

    Grupo createGrupo(Grupo grupo);

    Grupo updateGrupo(Long id, Grupo grupo);

    void deleteGrupo(Long id);

    //Operaciones adicionales
    public List<Grupo> buscarPorProfesor(Long profesorId);
    
}
