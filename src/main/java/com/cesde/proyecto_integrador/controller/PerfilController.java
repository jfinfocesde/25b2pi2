package com.cesde.proyecto_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.model.Perfil;
import com.cesde.proyecto_integrador.service.PerfilService;

@RestController
@RequestMapping("/api/perfiles")
@CrossOrigin(origins = "*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

     // Operaciones CRUD
    @GetMapping
    public ResponseEntity<List<Perfil>> getAllPerfiles() {
        List<Perfil> perfiles = perfilService.getAllPerfiles();
        return new ResponseEntity<>(perfiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable Long id) {
        Perfil perfil = perfilService.getPerfilById(id);
        if (perfil != null) {
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilService.createPerfil(perfil);
        return new ResponseEntity<>(nuevoPerfil, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable Long id, @RequestBody Perfil perfil) {
        Perfil perfilActualizado = perfilService.updatePerfil(id, perfil);
        if (perfilActualizado != null) {
            return new ResponseEntity<>(perfilActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable Long id) {
        perfilService.deletePerfil(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }   

    //Operaciones adicionales

    
}