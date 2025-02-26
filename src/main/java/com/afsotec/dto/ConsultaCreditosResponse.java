package com.afsotec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor  // Agrega constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class ConsultaCreditosResponse {
    private Integer empresaId;
    private String nombreEmpresa;
    private Integer sucursalId;
    private String nombreSucursal;
    private Integer socioId;
    private Integer numeroCredito;
    private String identificacion;
    private String nombres;
    private String tipoCredito;
    private String descripcionCredito;
    private String estatusCredito;
    private BigDecimal saldoCapital;
    private BigDecimal amortizacion;
    private BigDecimal interes;
    private BigDecimal mora;
    private BigDecimal gestion;
    private BigDecimal seguro;
    private BigDecimal total;
    private String mail;
    private String celular;
    private Integer cuentaAhorroId;
    private String estatusCuenta;
    private String nombreProducto;
}
