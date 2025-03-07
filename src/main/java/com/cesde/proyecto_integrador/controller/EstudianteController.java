package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.model.Nota;
import com.cesde.proyecto_integrador.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    //Operaciones CRUD
    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        return ResponseEntity.ok(estudianteService.getAllEstudiantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {        
        return ResponseEntity.ok(estudianteService.getEstudianteById(id));
    }   

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {
        return new ResponseEntity<>(estudianteService.createEstudiante(estudiante), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.updateEstudiante(id, estudiante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    //Operaciones adicionales

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<Estudiante> buscarPorDocumento(@PathVariable String numeroDocumento) {
        return estudianteService.buscarPorDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/grupo/{grupoId}")
    public ResponseEntity<List<Estudiante>> buscarPorGrupo(@PathVariable Long grupoId) {
        List<Estudiante> estudiantes = estudianteService.buscarPorGrupo(grupoId);
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}/notas")
    public ResponseEntity<List<Nota>> obtenerNotas(@PathVariable Long id) {
        return estudianteService.obtenerNotas(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 

    @PutMapping("/{id}/grupo/{grupoId}")
    public ResponseEntity<Estudiante> asignarGrupo(
            @PathVariable Long id, 
            @PathVariable Long grupoId) {
        return estudianteService.asignarGrupo(id, grupoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
   
}