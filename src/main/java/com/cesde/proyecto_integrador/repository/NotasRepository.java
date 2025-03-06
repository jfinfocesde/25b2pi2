package com.cesde.proyecto_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesde.proyecto_integrador.model.Nota;


import java.util.List;

public interface NotasRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByEstudianteId(Long estudianteId);
    List<Nota> findByNumeroSemestre(Integer numeroSemestre);
    List<Nota> findByEstudianteIdAndNumeroSemestre(Long estudianteId, Integer numeroSemestre);
    List<Nota> findByEsAprobado(boolean esAprobado);
    List<Nota> findByValoracionCualitativa(String valoracionCualitativa);
}