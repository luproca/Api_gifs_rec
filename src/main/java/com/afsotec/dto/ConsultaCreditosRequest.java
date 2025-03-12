package com.afsotec.dto;

public class ConsultaCreditosRequest {
    private Integer empresa;
    private String identificacion;

    // Getters y Setters
    public Integer getEmpresaId() {
        return empresa;
    }

    public void setEmpresaId(Integer empresa) {
        this.empresa = empresa;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
