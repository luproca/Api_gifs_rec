package com.afsotec.dto;

import java.math.BigDecimal;

public class ConsultaAhorrosResponse {
    private Integer empresa;
    private String nombreCortoEmpresa;
    private Integer sucursalId;
    private String nombreSucursal;
    private Integer codigo;
    private String mensaje;
    private Integer nsocio;
    private String identificacion;
    private String nombreCompleto;
    private Long ncuenta;
    private String titular;
    private Integer idProducto;
    private String nProducto;
    private String tipoAhorro;
    private String estatus;
    private BigDecimal sTotal;
    private BigDecimal saldoBloqueado;
    private BigDecimal saldoTransito;
    private BigDecimal sDisponible;

    // Getters
    public Integer getEmpresa() {
        return empresa;
    }

    public String getNombreCortoEmpresa() {
        return nombreCortoEmpresa;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Integer getNsocio() {
        return nsocio;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Long getNcuenta() {
        return ncuenta;
    }

    public String getTitular() {
        return titular;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getnProducto() {
        return nProducto;
    }

    public String getTipoAhorro() {
        return tipoAhorro;
    }

    public String getEstatus() {
        return estatus;
    }

    public BigDecimal getsTotal() {
        return sTotal;
    }

    public BigDecimal getSaldoBloqueado() {
        return saldoBloqueado;
    }

    public BigDecimal getSaldoTransito() {
        return saldoTransito;
    }

    public BigDecimal getsDisponible() {
        return sDisponible;
    }

    // Setters
    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public void setNombreCortoEmpresa(String nombreCortoEmpresa) {
        this.nombreCortoEmpresa = nombreCortoEmpresa;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNsocio(Integer nsocio) {
        this.nsocio = nsocio;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNcuenta(Long ncuenta) {
        this.ncuenta = ncuenta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setnProducto(String nProducto) {
        this.nProducto = nProducto;
    }

    public void setTipoAhorro(String tipoAhorro) {
        this.tipoAhorro = tipoAhorro;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setsTotal(BigDecimal sTotal) {
        this.sTotal = sTotal;
    }

    public void setSaldoBloqueado(BigDecimal saldoBloqueado) {
        this.saldoBloqueado = saldoBloqueado;
    }

    public void setSaldoTransito(BigDecimal saldoTransito) {
        this.saldoTransito = saldoTransito;
    }

    public void setsDisponible(BigDecimal sDisponible) {
        this.sDisponible = sDisponible;
    }
}