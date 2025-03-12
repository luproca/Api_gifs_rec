package com.afsotec.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "creditos") // Asegúrate de que el nombre coincida con el de tu tabla
public class Creditos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O el estrategia que uses en tu BD
    private Long id;

    @Column(name = "empresa_id")
    private Integer empresa;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "sucursal_id")
    private Integer sucursalId;

    @Column(name = "nombre_sucursal")
    private String nombreSucursal;

    @Column(name = "socio_id")
    private Integer socioId;

    @Column(name = "numero_credito")
    private Integer numeroCredito;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "tipo_credito")
    private String tipoCredito;

    @Column(name = "descripcion_credito")
    private String descripcionCredito;

    @Column(name = "estatus_credito")
    private String estatusCredito;

    @Column(name = "saldo_capital")
    private BigDecimal saldoCapital;

    @Column(name = "amortizacion")
    private BigDecimal amortizacion;

    @Column(name = "interes")
    private BigDecimal interes;

    @Column(name = "mora")
    private BigDecimal mora;

    @Column(name = "gestion")
    private BigDecimal gestion;

    @Column(name = "seguro")
    private BigDecimal seguro;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "mail")
    private String mail;

    @Column(name = "celular")
    private String celular;

    @Column(name = "cuenta_ahorro_id")
    private Integer cuentaAhorroId;

    @Column(name = "estatus_cuenta")
    private String estatusCuenta;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    // Getters y Setters
    public Integer getEmpresaId() {
        return empresa;
    }

    public void setempresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    // Sucursal
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

    // Socio y Crédito
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

    // Montos del Crédito
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

    // Datos de Contacto
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

    // Cuenta de Ahorro
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