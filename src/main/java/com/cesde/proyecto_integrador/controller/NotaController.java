package com.cesde.proyecto_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cesde.proyecto_integrador.model.Nota;
import com.cesde.proyecto_integrador.service.NotaService;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

     // Operaciones CRUD
    @GetMapping
    public ResponseEntity<List<Nota>> getAllNotas() {
        return ResponseEntity.ok(notaService.getAllNotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        Nota nota = notaService.getNotaById(id);
        if (nota != null) {
            return ResponseEntity.ok(nota);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Nota> createNota(@RequestBody Nota nota) {
        return ResponseEntity.ok(notaService.createNota(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Long id, @RequestBody Nota nota) {
        Nota updatedNota = notaService.updateNota(id, nota);
        if (updatedNota != null) {
            return ResponseEntity.ok(updatedNota);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        notaService.deleteNota(id);
        return ResponseEntity.ok().build();
    }

    //Operaciones adicionales

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Nota>> findByEstudianteId(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(notaService.findByEstudianteId(estudianteId));
    }

    @GetMapping("/semestre/{numeroSemestre}")
    public ResponseEntity<List<Nota>> findByNumeroSemestre(@PathVariable Integer numeroSemestre) {
        return ResponseEntity.ok(notaService.findByNumeroSemestre(numeroSemestre));
    }

    @GetMapping("/estudiante/{estudianteId}/semestre/{numeroSemestre}")
    public ResponseEntity<List<Nota>> findByEstudianteIdAndNumeroSemestre(
            @PathVariable Long estudianteId,
            @PathVariable Integer numeroSemestre) {
        return ResponseEntity.ok(notaService.findByEstudianteIdAndNumeroSemestre(estudianteId, numeroSemestre));
    }

    @GetMapping("/aprobado/{esAprobado}")
    public ResponseEntity<List<Nota>> findByEsAprobado(@PathVariable boolean esAprobado) {
        return ResponseEntity.ok(notaService.findByEsAprobado(esAprobado));
    }

    @GetMapping("/valoracion/{valoracionCualitativa}")
    public ResponseEntity<List<Nota>> findByValoracionCualitativa(
            @PathVariable String valoracionCualitativa) {
        return ResponseEntity.ok(notaService.findByValoracionCualitativa(valoracionCualitativa));
    }
}