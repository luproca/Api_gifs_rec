package com.afsotec.response;

import java.math.BigDecimal;

/**
 * Clase que representa la respuesta de la consulta de créditos.
 */
public class ConsultaCreditosResponse {

    // Campos relacionados con la empresa
    private Integer empresaId;
    private String nombreEmpresa;

    // Campos relacionados con la sucursal
    private Integer sucursalId;
    private String nombreSucursal;

    // Campos relacionados con el socio y el crédito
    private Integer socioId;
    private Integer numeroCredito;
    private String identificacion;
    private String nombres;
    private String tipoCredito;
    private String descripcionCredito;
    private String estatusCredito;

    // Campos relacionados con los montos del crédito
    private BigDecimal saldoCapital;
    private BigDecimal amortizacion;
    private BigDecimal interes;
    private BigDecimal mora;
    private BigDecimal gestion;
    private BigDecimal seguro;
    private BigDecimal total;

    // Campos relacionados con los datos de contacto
    private String mail;
    private String celular;

    // Campos relacionados con la cuenta de ahorro
    private Integer cuentaAhorroId;
    private String estatusCuenta;
    private String nombreProducto;




    /**
     * Constructor completo para inicializar todos los campos.
     */
    public ConsultaCreditosResponse(
            Integer empresaId, String nombreEmpresa,
            Integer sucursalId, String nombreSucursal,
            Integer socioId, Integer numeroCredito,
            String identificacion, String nombres,
            String tipoCredito, String descripcionCredito,
            String estatusCredito, BigDecimal saldoCapital,
            BigDecimal amortizacion, BigDecimal interes,
            BigDecimal mora, BigDecimal gestion,
            BigDecimal seguro, BigDecimal total,
            String mail, String celular,
            Integer cuentaAhorroId, String estatusCuenta,
            String nombreProducto) {
        this.empresaId = empresaId;
        this.nombreEmpresa = nombreEmpresa;
        this.sucursalId = sucursalId;
        this.nombreSucursal = nombreSucursal;
        this.socioId = socioId;
        this.numeroCredito = numeroCredito;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.tipoCredito = tipoCredito;
        this.descripcionCredito = descripcionCredito;
        this.estatusCredito = estatusCredito;
        this.saldoCapital = saldoCapital;
        this.amortizacion = amortizacion;
        this.interes = interes;
        this.mora = mora;
        this.gestion = gestion;
        this.seguro = seguro;
        this.total = total;
        this.mail = mail;
        this.celular = celular;
        this.cuentaAhorroId = cuentaAhorroId;
        this.estatusCuenta = estatusCuenta;
        this.nombreProducto = nombreProducto;
    }

    /**
     * Getters y Setters para los campos relacionados con la empresa.
     */
    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Getters y Setters para los campos relacionados con la sucursal.
     */
    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    /**
     * Getters y Setters para los campos relacionados con el socio y el crédito.
     */
    public Integer getSocioId() {
        return socioId;
    }

    public void setSocioId(Integer socioId) {
        this.socioId = socioId;
    }

    public Integer getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(Integer numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public String getDescripcionCredito() {
        return descripcionCredito;
    }

    public void setDescripcionCredito(String descripcionCredito) {
        this.descripcionCredito = descripcionCredito;
    }

    public String getEstatusCredito() {
        return estatusCredito;
    }

    public void setEstatusCredito(String estatusCredito) {
        this.estatusCredito = estatusCredito;
    }

    /**
     * Getters y Setters para los campos relacionados con los montos del crédito.
     */
    public BigDecimal getSaldoCapital() {
        return saldoCapital;
    }

    public void setSaldoCapital(BigDecimal saldoCapital) {
        this.saldoCapital = saldoCapital;
    }

    public BigDecimal getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(BigDecimal amortizacion) {
        this.amortizacion = amortizacion;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public BigDecimal getGestion() {
        return gestion;
    }

    public void setGestion(BigDecimal gestion) {
        this.gestion = gestion;
    }

    public BigDecimal getSeguro() {
        return seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * Getters y Setters para los campos relacionados con los datos de contacto.
     */
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Getters y Setters para los campos relacionados con la cuenta de ahorro.
     */
    public Integer getCuentaAhorroId() {
        return cuentaAhorroId;
    }

    public void setCuentaAhorroId(Integer cuentaAhorroId) {
        this.cuentaAhorroId = cuentaAhorroId;
    }

    public String getEstatusCuenta() {
        return estatusCuenta;
    }

    public void setEstatusCuenta(String estatusCuenta) {
        this.estatusCuenta = estatusCuenta;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
