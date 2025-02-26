package com.afsotec.dto;

import java.math.BigDecimal;

public class RecaudacionRequest {
    private Integer empresaId;
    private Integer cuentaId;
    private String transaccionId;
    private Integer conceptoId;
    private BigDecimal valor;
    private String observacion;
    private String nreferencia;
    private Integer cajaId;

    // Constructor vacío
    public RecaudacionRequest() {
    }

    // Constructor con todos los campos
    public RecaudacionRequest(Integer empresaId, Integer cuentaId, String transaccionId,
                              Integer conceptoId, BigDecimal valor, String observacion,
                              String nreferencia, Integer cajaId) {
        this.empresaId = empresaId;
        this.cuentaId = cuentaId;
        this.transaccionId = transaccionId;
        this.conceptoId = conceptoId;
        this.valor = valor;
        this.observacion = observacion;
        this.nreferencia = nreferencia;
        this.cajaId = cajaId;
    }

    // Getters y setters
    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Integer getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(Integer conceptoId) {
        this.conceptoId = conceptoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNreferencia() {
        return nreferencia;
    }

    public void setNreferencia(String nreferencia) {
        this.nreferencia = nreferencia;
    }

    public Integer getCajaId() {
        return cajaId;
    }

    public void setCajaId(Integer cajaId) {
        this.cajaId = cajaId;
    }
}