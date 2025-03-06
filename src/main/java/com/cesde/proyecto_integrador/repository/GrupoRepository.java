package com.cesde.proyecto_integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesde.proyecto_integrador.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    List<Grupo> findByProfesorId(Long profesorId);
}
