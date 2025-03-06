package com.cesde.proyecto_integrador.service;

import java.util.List;

import com.cesde.proyecto_integrador.model.Nota;

public interface NotaService {

    // Operaciones CRUD
    List<Nota> getAllNotas();

    Nota getNotaById(Long id);

    Nota createNota(Nota nota);

    Nota updateNota(Long id, Nota nota);

    void deleteNota(Long id);

    // Operaciones adicionales
    List<Nota> findByEstudianteId(Long estudianteId);
    
    List<Nota> findByNumeroSemestre(Integer numeroSemestre);
    
    List<Nota> findByEstudianteIdAndNumeroSemestre(Long estudianteId, Integer numeroSemestre);
    
    List<Nota> findByEsAprobado(boolean esAprobado);
    
    List<Nota> findByValoracionCualitativa(String valoracionCualitativa);
}