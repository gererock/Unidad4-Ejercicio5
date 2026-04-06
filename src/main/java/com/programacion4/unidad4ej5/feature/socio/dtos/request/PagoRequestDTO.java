package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoRequestDTO {

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "1000.00", inclusive = true, message = "El monto no puede ser menor a 1000.00")
    @Digits(integer = 10, fraction = 2, message = "El monto debe soportar hasta 2 decimales")
    private BigDecimal monto;

    @NotBlank(message = "El código de transacción es obligatorio")
    @Pattern(regexp = "^PAY-[A-Z0-9]{4}-[A-Z0-9]{4}$", message = "El código debe seguir el patrón PAY-XXXX-XXXX")
    private String codigoTransaccion;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    @Future(message = "La fecha de vencimiento debe estar en el futuro")
    private LocalDate fechaVencimiento;

    @NotBlank(message = "El tipo de pago es obligatorio")
    @Pattern(
            regexp = "^(EFECTIVO|DEBITO|CREDITO|TRANSFERENCIA)$",
            message = "El tipo de pago debe ser EFECTIVO, DEBITO, CREDITO o TRANSFERENCIA"
    )
    private String tipoPago;

    public PagoRequestDTO() {
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
}