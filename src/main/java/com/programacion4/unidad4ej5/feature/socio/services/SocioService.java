package com.programacion4.unidad4ej5.feature.socio.services;

import com.programacion4.unidad4ej5.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SocioService {

    private final AtomicLong secuencia = new AtomicLong(0);
    private final Map<Long, SocioResponseDTO> socios = new ConcurrentHashMap<>();

    public SocioResponseDTO crearSocio(SocioCreateDTO dto) {
        Long id = secuencia.incrementAndGet();

        SocioResponseDTO response = new SocioResponseDTO();
        response.setId(id);
        response.setNombre(dto.getNombre());
        response.setApellido(dto.getApellido());
        response.setEmail(dto.getEmail());
        response.setDni(dto.getDni());
        response.setFechaNacimiento(dto.getFechaNacimiento());
        response.setTelefono(dto.getTelefono());
        response.setUrlFoto(null);
        response.setAlias(null);

        socios.put(id, response);
        return response;
    }

    public SocioResponseDTO obtenerSocioExistente(Long id) {
        SocioResponseDTO socio = socios.get(id);
        if (socio == null) {
            throw new ResourceNotFoundException("No existe un socio con id: " + id);
        }
        return socio;
    }

    public SocioResponseDTO actualizarPerfil(SocioUpdateDTO dto) {
        SocioResponseDTO socio = obtenerSocioExistente(dto.getId());

        if (dto.getEmail() != null) {
            socio.setEmail(dto.getEmail());
        }
        if (dto.getTelefono() != null) {
            socio.setTelefono(dto.getTelefono());
        }
        if (dto.getUrlFoto() != null) {
            socio.setUrlFoto(dto.getUrlFoto());
        }
        if (dto.getAlias() != null) {
            socio.setAlias(dto.getAlias());
        }

        socios.put(socio.getId(), socio);
        return socio;
    }
}