package com.cesde.proyecto_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cesde.proyecto_integrador.model.Estudiante;

import java.util.List;
import java.util.Optional;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    Optional<Estudiante> findByNumeroDocumento(String numeroDocumento); 
    List<Estudiante> findByGrupoId(Long grupoId);
}
