package com.cesde.proyecto_integrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
public class inicioController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> welcome(HttpServletRequest request) {
        String serverUrl = request.getRequestURL().toString();
        
        Map<String, String> response = new HashMap<>();
        response.put("title", "CESDE API de Gestión Académica");
        response.put("version", "1.0");
        response.put("description", "API para la gestión de calificaciones");
        response.put("documentation", serverUrl + "swagger-ui/index.html");
        response.put("author", "Jhon Valencia");
        
        return ResponseEntity.ok(response);
    }
}