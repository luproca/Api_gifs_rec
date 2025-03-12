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
    private Integer ncuenta;
    private String titular;
    private Integer idProducto;
    private String nProducto;
    private String tipoAhorro;
    private String estatus;
    private BigDecimal sTotal;
    private BigDecimal saldoBloqueado;
    private BigDecimal saldoTransito;
    private BigDecimal sDisponible;
    private String celular;
    private String mail;

    // Getters y Setters
    public Integer getEmpresaId() { return empresa; }
    public void setEmpresa(Integer empresa) { this.empresa = empresa; }

    public String getNombreCortoEmpresa() { return nombreCortoEmpresa; }
    public void setNombreCortoEmpresa(String nombreCortoEmpresa) { this.nombreCortoEmpresa = nombreCortoEmpresa; }

    public Integer getSucursalId() { return sucursalId; }
    public void setSucursalId(Integer sucursalId) { this.sucursalId = sucursalId; }

    public String getNombreSucursal() { return nombreSucursal; }
    public void setNombreSucursal(String nombreSucursal) { this.nombreSucursal = nombreSucursal; }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public Integer getNsocio() { return nsocio; }
    public void setNsocio(Integer nsocio) { this.nsocio = nsocio; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public Integer getNcuenta() { return ncuenta; }
    public void setNcuenta(Integer ncuenta) { this.ncuenta = ncuenta; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getNProducto() { return nProducto; }
    public void setNProducto(String nProducto) { this.nProducto = nProducto; }

    public String getTipoAhorro() { return tipoAhorro; }
    public void setTipoAhorro(String tipoAhorro) { this.tipoAhorro = tipoAhorro; }

    public String getEstatus() { return estatus; }
    public void setEstatus(String estatus) { this.estatus = estatus; }

    public BigDecimal getSTotal() { return sTotal; }
    public void setSTotal(BigDecimal sTotal) { this.sTotal = sTotal; }

    public BigDecimal getSaldoBloqueado() { return saldoBloqueado; }
    public void setSaldoBloqueado(BigDecimal saldoBloqueado) { this.saldoBloqueado = saldoBloqueado; }

    public BigDecimal getSaldoTransito() { return saldoTransito; }
    public void setSaldoTransito(BigDecimal saldoTransito) { this.saldoTransito = saldoTransito; }

    public BigDecimal getSDisponible() { return sDisponible; }
    public void setSDisponible(BigDecimal sDisponible) { this.sDisponible = sDisponible; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    @Override
    public String toString() {
        return "ConsultaAhorrosResponse{" +
                "empresa=" + empresa +
                ", nombreCortoEmpresa='" + nombreCortoEmpresa + '\'' +
                ", sucursalId=" + sucursalId +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", codigo=" + codigo +
                ", mensaje='" + mensaje + '\'' +
                ", nsocio=" + nsocio +
                ", identificacion='" + identificacion + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", ncuenta=" + ncuenta +
                ", titular='" + titular + '\'' +
                ", idProducto=" + idProducto +
                ", nProducto='" + nProducto + '\'' +
                ", tipoAhorro='" + tipoAhorro + '\'' +
                ", estatus='" + estatus + '\'' +
                ", sTotal=" + sTotal +
                ", saldoBloqueado=" + saldoBloqueado +
                ", saldoTransito=" + saldoTransito +
                ", sDisponible=" + sDisponible +
                ", celular='" + celular + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}