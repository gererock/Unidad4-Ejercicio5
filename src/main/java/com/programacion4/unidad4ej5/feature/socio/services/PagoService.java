package com.programacion4.unidad4ej5.feature.socio.services;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.PagoRequestDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.PagoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PagoService {

    private final AtomicLong secuencia = new AtomicLong(0);
    private final SocioService socioService;

    public PagoService(SocioService socioService) {
        this.socioService = socioService;
    }

    public PagoResponseDTO registrarPago(Long socioId, PagoRequestDTO dto) {
        socioService.obtenerSocioExistente(socioId);

        PagoResponseDTO response = new PagoResponseDTO();
        response.setId(secuencia.incrementAndGet());
        response.setSocioId(socioId);
        response.setMonto(dto.getMonto());
        response.setCodigoTransaccion(dto.getCodigoTransaccion());
        response.setFechaVencimiento(dto.getFechaVencimiento());
        response.setTipoPago(dto.getTipoPago());

        return response;
    }
}