package com.afsotec.dto;

public class ConsultaAhorrosRequest {
    private Integer empresaId; // Cambiado de "empresa" a "empresaId"
    private String identificacion;

    // Getters y Setters
    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}