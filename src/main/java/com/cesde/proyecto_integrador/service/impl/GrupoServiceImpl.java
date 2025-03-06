package com.cesde.proyecto_integrador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    // Operaciones CRUD
    @Override
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo getGrupoById(Long id) {
        return grupoRepository.findById(id).get();
    }

    @Override
    public Grupo createGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public Grupo updateGrupo(Long id, Grupo grupo) {
        Grupo grupoActual = grupoRepository.findById(id).get();
        grupoActual.setNombre(grupo.getNombre());
        grupoActual.setArea(grupo.getArea());
        return grupoRepository.save(grupoActual);
    }

    @Override
    public void deleteGrupo(Long id) {
        grupoRepository.deleteById(id);
    }

    // Operaciones adicionales
    public List<Grupo> buscarPorProfesor(Long profesorId) {
        return grupoRepository.findByProfesorId(profesorId);
    }
}