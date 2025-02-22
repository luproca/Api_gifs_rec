package com.afsotec.dto;

public class ConsultaAhorrosRequest {
    private Integer empresa;
    private String identificacion;

    // Getters y Setters
    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}