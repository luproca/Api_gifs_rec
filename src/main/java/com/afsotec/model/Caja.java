package com.afsotec.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CAJA")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMPRESA_ID")
    private Integer empresa;

    @Column(name = "SUCURSAL_ID")
    private Integer sucursalId;

    @Column(name = "CAJA_ID")
    private Integer cajaId;

    @Column(name = "RESPONSABLE")
    private String responsable;

    @Column(name = "USUARIO_ID")
    private String usuarioId;

    @Column(name = "ESTATUS_CAJA")
    private String estatusCaja;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmpresaid() {
        return empresa;
    }

    public void setempresa(Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Integer getCajaId() {
        return cajaId;
    }

    public void setCajaId(Integer cajaId) {
        this.cajaId = cajaId;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEstatusCaja() {
        return estatusCaja;
    }

    public void setEstatusCaja(String estatusCaja) {
        this.estatusCaja = estatusCaja;
    }
}