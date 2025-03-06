package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Grupo;
import com.cesde.proyecto_integrador.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

     // Operaciones CRUD

    @GetMapping
    public ResponseEntity<List<Grupo>> getAllGrupos() {
        return ResponseEntity.ok(grupoService.getAllGrupos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable Long id) {
        return ResponseEntity.ok(grupoService.getGrupoById(id));
    }

    @PostMapping
    public ResponseEntity<Grupo> createGrupo(@RequestBody Grupo grupo) {
        return new ResponseEntity<>(grupoService.createGrupo(grupo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable Long id, @RequestBody Grupo grupo) {
        return ResponseEntity.ok(grupoService.updateGrupo(id, grupo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long id) {
        grupoService.deleteGrupo(id);
        return ResponseEntity.noContent().build();
    }

    //Operaciones adicionales
    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<Grupo>> obtenerGruposPorProfesor(@PathVariable Long profesorId) {
        return ResponseEntity.ok(grupoService.buscarPorProfesor(profesorId));
    }
}