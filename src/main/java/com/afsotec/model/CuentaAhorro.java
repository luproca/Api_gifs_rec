package com.afsotec.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas_ahorro") // Asegúrate de que este nombre coincida con tu tabla en Oracle
public class CuentaAhorro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "tipo_ahorro", nullable = false)
    private String tipoAhorro;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipoAhorro() {
        return tipoAhorro;
    }

    public void setTipoAhorro(String tipoAhorro) {
        this.tipoAhorro = tipoAhorro;
    }
}