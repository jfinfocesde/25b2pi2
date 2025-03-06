package com.cesde.proyecto_integrador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.model.Nota;
import com.cesde.proyecto_integrador.repository.NotasRepository;
import com.cesde.proyecto_integrador.service.NotaService;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotasRepository notasRepository;

    @Override
    public List<Nota> getAllNotas() {
        return notasRepository.findAll();
    }

    @Override
    public Nota getNotaById(Long id) {
        return notasRepository.findById(id).orElse(null);
    }

    @Override
    public Nota createNota(Nota nota) {
        return notasRepository.save(nota);
    }

    @Override
    public Nota updateNota(Long id, Nota nota) {
        Nota existingNota = notasRepository.findById(id).orElse(null);
        if (existingNota != null) {
            existingNota.setM1Conocimiento(nota.getM1Conocimiento());
            existingNota.setM1Desempeno(nota.getM1Desempeno());
            existingNota.setM1Producto(nota.getM1Producto());
            existingNota.setM2Conocimiento(nota.getM2Conocimiento());
            existingNota.setM2Desempeno(nota.getM2Desempeno());
            existingNota.setM2Producto(nota.getM2Producto());
            existingNota.setM3Conocimiento(nota.getM3Conocimiento());
            existingNota.setM3Desempeno(nota.getM3Desempeno());
            existingNota.setM3Producto(nota.getM3Producto());  
            return notasRepository.save(existingNota);
        }
        return null;
    }

    @Override
    public void deleteNota(Long id) {
        notasRepository.deleteById(id);
    }

    @Override
    public List<Nota> findByEstudianteId(Long estudianteId) {
        return notasRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public List<Nota> findByNumeroSemestre(Integer numeroSemestre) {
        return notasRepository.findByNumeroSemestre(numeroSemestre);
    }

    @Override
    public List<Nota> findByEstudianteIdAndNumeroSemestre(Long estudianteId, Integer numeroSemestre) {
        return notasRepository.findByEstudianteIdAndNumeroSemestre(estudianteId, numeroSemestre);
    }

    @Override
    public List<Nota> findByEsAprobado(boolean esAprobado) {
        return notasRepository.findByEsAprobado(esAprobado);
    }

    @Override
    public List<Nota> findByValoracionCualitativa(String valoracionCualitativa) {
        return notasRepository.findByValoracionCualitativa(valoracionCualitativa);
    }
}