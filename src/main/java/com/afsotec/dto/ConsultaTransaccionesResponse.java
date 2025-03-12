package com.afsotec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaTransaccionesResponse {
    private Integer empresaId;
    private Integer sucursalId;
    private Integer cajaId;
    private Integer movimientoCajaId;
    private LocalDate fecha;
    private LocalTime hora;
    private BigDecimal efectivo;
    private BigDecimal total;
    private Integer transaccionSistemaId;
    private String transaccion;
    private Integer nSocio;  // Cambiado de nsocio a nSocio para mantener consistencia con setter
    private Integer cuenta;
    private String personeria;
    private String tipoDocumento;
    private String identificacion;
    private String nombreCompleto;

    // Método adicional para compatibilidad con setNSocio pero usando el campo nSocio
    public void setNSocio(Integer nSocio) {
        this.nSocio = nSocio;
    }

    public Integer getNSocio() {
        return this.nSocio;
    }
}