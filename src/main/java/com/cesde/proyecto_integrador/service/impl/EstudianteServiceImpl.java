package com.cesde.proyecto_integrador.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.exception.RecursoNoEncontradoException;
import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.model.Nota;
import com.cesde.proyecto_integrador.repository.EstudianteRepository;
import com.cesde.proyecto_integrador.repository.GrupoRepository;
import com.cesde.proyecto_integrador.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    //Operaciones CRUD
    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante getEstudianteById(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("El ID " + id + " no existe."));
    }

    @Override
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante updateEstudiante(Long id, Estudiante estudiante) {
        Estudiante estudianteActual = estudianteRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("El ID " + id + " no existe."));

        estudianteActual.setTipoDocumento(estudiante.getTipoDocumento());
        estudianteActual.setNumeroDocumento(estudiante.getNumeroDocumento());
        estudianteActual.setNombre(estudiante.getNombre());
        estudianteActual.setApellido(estudiante.getApellido());
        estudianteActual.setEmail(estudiante.getEmail());

        return estudianteRepository.save(estudianteActual);
    }

    @Override
    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    //Operaciones adicionales
    public Optional<Estudiante> buscarPorDocumento(String numeroDocumento) {
        return estudianteRepository.findByNumeroDocumento(numeroDocumento);
    }

    public List<Estudiante> buscarPorGrupo(Long grupoId) {
        return estudianteRepository.findByGrupoId(grupoId);
    }

    public Optional<List<Nota>> obtenerNotas(Long id) {
        return estudianteRepository.findById(id)
                .map(Estudiante::getSemestres);
    }   

    public Optional<Estudiante> asignarGrupo(Long estudianteId, Long grupoId) {
        Optional<Estudiante> estudianteOpt = estudianteRepository.findById(estudianteId);
        Optional<Grupo> grupoOpt = grupoRepository.findById(grupoId);

        if (estudianteOpt.isPresent() && grupoOpt.isPresent()) {
            Estudiante estudiante = estudianteOpt.get();
            estudiante.setGrupo(grupoOpt.get());
            return Optional.of(estudianteRepository.save(estudiante));
        }
        return Optional.empty();
    }
    
}
