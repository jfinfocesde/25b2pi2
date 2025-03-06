package com.cesde.proyecto_integrador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesde.proyecto_integrador.model.Perfil;
import com.cesde.proyecto_integrador.repository.PerfilRepository;
import com.cesde.proyecto_integrador.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

     // Operaciones CRUD
    @Override
    public List<Perfil> getAllPerfiles() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil getPerfilById(Long id) {
        return perfilRepository.findById(id).orElse(null);
    }

    @Override
    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil updatePerfil(Long id, Perfil perfil) {
        Perfil perfilExistente = perfilRepository.findById(id).orElse(null);
        if (perfilExistente != null) {            
            perfilExistente.setFechaNacimiento(perfil.getFechaNacimiento());
            perfilExistente.setDireccion(perfil.getDireccion());
            perfilExistente.setTelefono(perfil.getTelefono());
            perfilExistente.setUrlFoto(perfil.getUrlFoto());
            return perfilRepository.save(perfilExistente);
        }
        return null;
    }

    @Override
    public void deletePerfil(Long id) {
        perfilRepository.deleteById(id);
    }

    // Operaciones adicionales

}