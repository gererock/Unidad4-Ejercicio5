package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import com.programacion4.unidad4ej5.feature.socio.validation.groups.OnUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SocioUpdateDTO {

    @NotNull(message = "El id del socio es obligatorio en la actualización", groups = OnUpdate.class)
    private Long id;

    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Pattern(regexp = "^\\+[1-9]\\d{7,14}$", message = "El teléfono debe tener formato internacional válido")
    private String telefono;

    @Pattern(regexp = "^(https?://).+$", message = "La URL de foto debe ser válida")
    private String urlFoto;

    @Size(min = 3, max = 15, message = "El alias debe tener entre 3 y 15 caracteres")
    @Pattern(regexp = "^\\S+$", message = "El alias no debe contener espacios")
    private String alias;

    public SocioUpdateDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}