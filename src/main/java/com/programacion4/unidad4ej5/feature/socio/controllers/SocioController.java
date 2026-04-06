package com.programacion4.unidad4ej5.feature.socio.controllers;

import com.programacion4.unidad4ej5.config.BaseResponse;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.PagoRequestDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.PlanCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.PagoResponseDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.PlanResponseDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDTO;
import com.programacion4.unidad4ej5.feature.socio.services.PagoService;
import com.programacion4.unidad4ej5.feature.socio.services.PlanService;
import com.programacion4.unidad4ej5.feature.socio.services.SocioService;
import com.programacion4.unidad4ej5.feature.socio.validation.groups.OnUpdate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;
    private final PlanService planService;
    private final PagoService pagoService;

    public SocioController(SocioService socioService, PlanService planService, PagoService pagoService) {
        this.socioService = socioService;
        this.planService = planService;
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<SocioResponseDTO>> crearSocio(@Valid @RequestBody SocioCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.ok(socioService.crearSocio(dto), "Socio creado correctamente"));
    }

    @PostMapping("/{socioId}/planes")
    public ResponseEntity<BaseResponse<PlanResponseDTO>> crearPlan(
            @PathVariable Long socioId,
            @Valid @RequestBody PlanCreateDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.ok(planService.crearPlan(socioId, dto), "Plan creado correctamente"));
    }

    @PostMapping("/{socioId}/pagos")
    public ResponseEntity<BaseResponse<PagoResponseDTO>> registrarPago(
            @PathVariable Long socioId,
            @Valid @RequestBody PagoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.ok(pagoService.registrarPago(socioId, dto), "Pago registrado correctamente"));
    }

    @PutMapping("/perfil")
    public ResponseEntity<BaseResponse<SocioResponseDTO>> actualizarPerfil(
            @Validated(OnUpdate.class) @RequestBody SocioUpdateDTO dto) {

        return ResponseEntity.ok(
                BaseResponse.ok(socioService.actualizarPerfil(dto), "Perfil actualizado correctamente"));
    }
}