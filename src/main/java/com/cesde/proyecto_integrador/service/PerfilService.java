package com.cesde.proyecto_integrador.service;

import java.util.List;
import com.cesde.proyecto_integrador.model.Perfil;

public interface PerfilService {

     // Operaciones CRUD
    List<Perfil> getAllPerfiles();
    
    Perfil getPerfilById(Long id);
    
    Perfil createPerfil(Perfil perfil);
    
    Perfil updatePerfil(Long id, Perfil perfil);
    
    void deletePerfil(Long id);
   
}