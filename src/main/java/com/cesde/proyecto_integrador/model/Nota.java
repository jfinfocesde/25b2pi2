package com.cesde.proyecto_integrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private Integer numeroSemestre;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m1Conocimiento = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m1Desempeno = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m1Producto = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m2Conocimiento = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m2Desempeno = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m2Producto = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m3Conocimiento = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m3Desempeno = 0.0;

    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Double m3Producto = 0.0;

    private Double promedioMomento1;
    private Double promedioMomento2;
    private Double promedioMomento3;

    private Double promedioFinal;

    private String valoracionCualitativa;
    private boolean esAprobado;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    @JsonBackReference
    private Estudiante estudiante;

    @PrePersist
    @PreUpdate
    public void calcularPromedio() {

        // Calcular el promedio de cada momento y el promedio final
        promedioMomento1 = (m1Conocimiento + m1Desempeno + m1Producto) / 3;
        promedioMomento2 = (m2Conocimiento + m2Desempeno + m2Producto) / 3;
        promedioMomento3 = (m3Conocimiento + m3Desempeno + m3Producto) / 3;
        promedioFinal = (promedioMomento1 + promedioMomento2 + promedioMomento3) / 3;

        // Calcular la valoración cualitativa
        if (promedioFinal >= 4.6)
            valoracionCualitativa = "EXCELENTE";
        else if (promedioFinal >= 4.0)
            valoracionCualitativa = "SOBRESALIENTE";
        else if (promedioFinal >= 3.5)
            valoracionCualitativa = "BUENO";
        else if (promedioFinal >= 3.0)
            valoracionCualitativa = "ACEPTABLE";
        else
            valoracionCualitativa = "INSUFICIENTE";

        // Verificar si el estudiante está aprobado o no
        if (promedioFinal >= 3.5)
            esAprobado = true;
        else
            esAprobado = false;
    }    

}
