package com.afsotec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor  // Agrega constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class ConsultaCajaResponse {
    private Integer empresaId;
    private Integer sucursalId;
    private Integer cajaId;
    private String responsable;
    private String usuarioId;
    private String estatusCaja;
    private BigDecimal saldoEfectivo;
}