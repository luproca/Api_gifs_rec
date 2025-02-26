package com.afsotec.dto;

public class ConsultaCajaRequest {
    private Integer empresaId;
    private String usuarioId;

    // Getters y Setters
    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}