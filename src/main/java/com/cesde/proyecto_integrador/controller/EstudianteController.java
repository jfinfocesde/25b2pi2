package com.cesde.proyecto_integrador.controller;

import com.cesde.proyecto_integrador.model.Estudiante;
import com.cesde.proyecto_integrador.model.Nota;
import com.cesde.proyecto_integrador.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "API para la gestión de estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Operaciones CRUD
    @Operation(summary = "Obtener todos los estudiantes", description = "Retorna una lista de todos los estudiantes registrados")
    @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida con éxito")
    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        return ResponseEntity.ok(estudianteService.getAllEstudiantes());
    }

    @Operation(summary = "Obtener estudiante por ID", description = "Retorna un estudiante según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(
            @Parameter(description = "ID del estudiante") @PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.getEstudianteById(id));
    }

    @Operation(summary = "Crear nuevo estudiante", description = "Crea un nuevo registro de estudiante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudiante creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos del estudiante inválidos")
    })
    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(
            @Parameter(description = "Datos del estudiante a crear") @RequestBody Estudiante estudiante) {
        return new ResponseEntity<>(estudianteService.createEstudiante(estudiante), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar estudiante", description = "Actualiza los datos de un estudiante existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(
            @Parameter(description = "ID del estudiante") @PathVariable Long id,
            @Parameter(description = "Nuevos datos del estudiante") @RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.updateEstudiante(id, estudiante));
    }

    @Operation(summary = "Eliminar estudiante", description = "Elimina un estudiante por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Estudiante eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(
            @Parameter(description = "ID del estudiante a eliminar") @PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    // Operaciones adicionales
    @Operation(summary = "Buscar estudiante por número de documento", description = "Retorna un estudiante según su número de documento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<Estudiante> buscarPorDocumento(
            @Parameter(description = "Número de documento del estudiante") @PathVariable String numeroDocumento) {
        return estudianteService.buscarPorDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar estudiantes por grupo", description = "Retorna una lista de estudiantes pertenecientes a un grupo específico")
    @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida con éxito")
    @GetMapping("/grupo/{grupoId}")
    public ResponseEntity<List<Estudiante>> buscarPorGrupo(
            @Parameter(description = "ID del grupo") @PathVariable Long grupoId) {
        List<Estudiante> estudiantes = estudianteService.buscarPorGrupo(grupoId);
        return ResponseEntity.ok(estudiantes);
    }

    @Operation(summary = "Obtener notas de un estudiante", description = "Retorna todas las notas asociadas a un estudiante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notas encontradas"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}/notas")
    public ResponseEntity<List<Nota>> obtenerNotas(
            @Parameter(description = "ID del estudiante") @PathVariable Long id) {
        return estudianteService.obtenerNotas(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Asignar estudiante a un grupo", description = "Asigna un estudiante a un grupo específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante asignado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante o grupo no encontrado")
    })
    @PutMapping("/{id}/grupo/{grupoId}")
    public ResponseEntity<Estudiante> asignarGrupo(
            @Parameter(description = "ID del estudiante") @PathVariable Long id,
            @Parameter(description = "ID del grupo") @PathVariable Long grupoId) {
        return estudianteService.asignarGrupo(id, grupoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
