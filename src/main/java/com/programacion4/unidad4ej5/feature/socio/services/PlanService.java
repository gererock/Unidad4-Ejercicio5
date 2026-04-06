package com.programacion4.unidad4ej5.feature.socio.services;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.PlanCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.PlanResponseDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PlanService {

    private final AtomicLong secuencia = new AtomicLong(0);
    private final SocioService socioService;

    public PlanService(SocioService socioService) {
        this.socioService = socioService;
    }

    public PlanResponseDTO crearPlan(Long socioId, PlanCreateDTO dto) {
        socioService.obtenerSocioExistente(socioId);

        PlanResponseDTO response = new PlanResponseDTO();
        response.setId(secuencia.incrementAndGet());
        response.setSocioId(socioId);
        response.setObjetivo(dto.getObjetivo());
        response.setFrecuenciaSemanal(dto.getFrecuenciaSemanal());
        response.setPesoInicial(dto.getPesoInicial());
        response.setAltura(dto.getAltura());
        response.setEjercicios(dto.getEjercicios());

        return response;
    }
}