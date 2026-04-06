package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public class PlanCreateDTO {

    @NotBlank(message = "El objetivo es obligatorio")
    @Size(min = 10, max = 200, message = "El objetivo debe tener entre 10 y 200 caracteres")
    private String objetivo;

    @NotNull(message = "La frecuencia semanal es obligatoria")
    @Min(value = 1, message = "La frecuencia semanal mínima es 1")
    @Max(value = 7, message = "La frecuencia semanal máxima es 7")
    private Integer frecuenciaSemanal;

    @NotNull(message = "El peso inicial es obligatorio")
    @DecimalMin(value = "30.0", inclusive = true, message = "El peso inicial mínimo es 30.0")
    @DecimalMax(value = "250.0", inclusive = true, message = "El peso inicial máximo es 250.0")
    private BigDecimal pesoInicial;

    @NotNull(message = "La altura es obligatoria")
    @DecimalMin(value = "1.0", inclusive = true, message = "La altura mínima es 1.0")
    @DecimalMax(value = "2.5", inclusive = true, message = "La altura máxima es 2.5")
    private BigDecimal altura;

    @NotEmpty(message = "La lista de ejercicios no puede estar vacía")
    @Size(min = 3, message = "Debe contener al menos 3 ejercicios")
    private List<@NotBlank(message = "Cada ejercicio debe estar definido") String> ejercicios;

    public PlanCreateDTO() {
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getFrecuenciaSemanal() {
        return frecuenciaSemanal;
    }

    public void setFrecuenciaSemanal(Integer frecuenciaSemanal) {
        this.frecuenciaSemanal = frecuenciaSemanal;
    }

    public BigDecimal getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(BigDecimal pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public List<String> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<String> ejercicios) {
        this.ejercicios = ejercicios;
    }
}